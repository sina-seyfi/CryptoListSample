package com.sinaseyfi.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.fragment.app.Fragment

abstract class BaseComposeFragment: Fragment() {

    @ExperimentalUnitApi
    @ExperimentalMaterialApi
    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent { ShowUI() }
    }

    @ExperimentalMaterialApi
    @ExperimentalUnitApi
    @Composable
    abstract fun ShowUI()

}