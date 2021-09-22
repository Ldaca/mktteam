package com.ldaca.app.ready.ui

import com.facebook.CallbackManager

interface Contracts {

    interface CallActivity {
        fun getCallbackManager(): CallbackManager
    }

    interface CallFragment {
        fun getActivityResult()
    }

    interface CallPostDialog {
        fun onLoadImage()
    }

    /** Define comunicación del BottomSheetContextFragment al fragmento padre */
    interface CallBottomSheetContext {
        fun requestCallPhone(tel: String)
        fun insertTop(idSelectClient: String)
        fun insertDown(idSelectClient: String)
        fun reverseMoving(idSelectClient: String)
    }
}