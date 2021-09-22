package com.ldaca.app.ready.utils

import android.content.Context
import android.view.View
import com.ldaca.app.ready.ContactApp
import java.text.SimpleDateFormat
import java.util.*

val Context.app: ContactApp
    get() = applicationContext as ContactApp

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }

fun Date.formatDate(): String = SimpleDateFormat("h:mm:ss a dd/MM/yyyy", Locale.getDefault()).format(this)