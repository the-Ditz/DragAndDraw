package com.tutorial.bnr.ditzlern.draganddraw

import android.support.v4.app.Fragment

class DragAndDrawActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return DragAndDrawFragment.newInstance()
    }
}
