package com.tutorial.bnr.ditzlern.draganddraw


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class DragAndDrawFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_drag_and_draw, container, false)
    }

    companion object {
        fun newInstance(): DragAndDrawFragment {
            return DragAndDrawFragment()
        }
    }
}
