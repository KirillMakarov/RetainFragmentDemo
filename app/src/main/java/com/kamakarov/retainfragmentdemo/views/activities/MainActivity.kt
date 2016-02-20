package com.kamakarov.retainfragmentdemo.views.activities

import com.kamakarov.retainfragmentdemo.views.fragments.RetainDemoFragment

class MainActivity : SingleFragmentActivity() {
    override fun createFragment() = RetainDemoFragment.newInstance()
}