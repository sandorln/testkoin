package com.test.testkoin1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        binding.lifecycleOwner = this

        if (getToolbar() != null)
            setSupportActionBar(getToolbar()!!)

        initBindingSetting()
        initObjectSetting()
        initViewSetting()
        initObserverSetting()
    }

    abstract fun getToolbar(): Toolbar?

    abstract fun initBindingSetting()

    abstract fun initObserverSetting()

    abstract fun initViewSetting()

    abstract fun initObjectSetting()

    abstract fun getLayoutRes(): Int
}