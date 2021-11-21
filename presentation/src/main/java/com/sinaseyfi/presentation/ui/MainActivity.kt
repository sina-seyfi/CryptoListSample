package com.sinaseyfi.presentation.ui

import android.view.LayoutInflater
import com.sinaseyfi.presentation.R
import com.sinaseyfi.presentation.databinding.ActivityMainBinding
import com.sinaseyfi.presentation.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main
    override val navHostFragmentId: Int
        get() = R.id.mainNavHostFragment

    override fun createViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

}