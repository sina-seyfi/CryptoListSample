package com.sinaseyfi.presentation.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


abstract class BaseViewModel<V : ViewState>(
    initViewState: V
) : ViewModel()
{
    
    protected val _viewState = MutableStateFlow(initViewState)
    val viewState: StateFlow<V> = _viewState

}