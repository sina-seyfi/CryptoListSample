package com.sinaseyfi.presentation.ui.crypto.details

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.sinaseyfi.presentation.R
import com.sinaseyfi.presentation.ui.base.BaseComposeFragment
import com.sinaseyfi.presentation.ui.crypto.CryptoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoDetailsFragment: BaseComposeFragment() {

    val viewModel: CryptoViewModel by hiltNavGraphViewModels(R.id.cryptoGraph)

    @ExperimentalMaterialApi
    @ExperimentalUnitApi
    @Composable
    override fun ShowUI() {
        TODO("Not yet implemented")
    }

}