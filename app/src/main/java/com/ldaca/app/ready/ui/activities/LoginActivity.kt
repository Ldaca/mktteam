package com.ldaca.app.ready.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.ldaca.app.ready.R
import com.ldaca.app.ready.databinding.ActivityLoginBinding

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var googleClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(getString(R.string.default_web_clien_id))
                .build()
        googleClient = GoogleSignIn.getClient(this, gso)
        googleClient.signOut()

        binding.signInButton.setOnClickListener {
            loginWithGoogle()
        }
    }

    private fun loginWithGoogle() {
        startActivityForResult(googleClient.signInIntent, RC_SIGN_IN)
    }

    private fun String.snacky() {
        Snackbar.make(binding.root, this, Snackbar.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            if (task.isSuccessful) {
                try {
                    val account = task.getResult(ApiException::class.java)
                    account?.let {
                        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
                        auth.signInWithCredential(credential).addOnCompleteListener {
                            Intent(this, DetailActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                putExtra("email", account.email)
                                startActivity(this)
                            }
                        }
                    }
                } catch (e: ApiException) {
                    "No fue posible obtener la cuenta de Google".snacky()
                }
            } else {
                "Failer $resultCode - ${task.exception?.message}".snacky()
            }
        }
    }

    companion object {
        private const val RC_SIGN_IN = 1000
    }
}