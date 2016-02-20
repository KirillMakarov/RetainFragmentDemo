package com.kamakarov.retainfragmentdemo.views.fragments

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kamakarov.retainfragmentdemo.R

class RetainDemoFragment : Fragment() {
    companion object {
        val TAG = "retain_fragment"
        fun newInstance(): RetainDemoFragment {
            val args = Bundle()

            val fragment = RetainDemoFragment()
            fragment.arguments = args
            return fragment
        }
    }

    var someVariable: String = "Init in class"
    var mActionButton: View? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.i(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        someVariable = "Init in onCreate"
        Log.i(TAG, "onCreate") //onCreate/onDestroy is not called when device changes orientation
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_retain_demo, container, false)
        mActionButton = view?.findViewById(R.id.show_value_btn)
        mActionButton?.setOnClickListener { Toast.makeText(it.context, someVariable, Snackbar.LENGTH_SHORT).show() }
        return view
    }

    override fun onDestroyView() {
        mActionButton?.setOnClickListener(null)
        super.onDestroyView()
    }
}
