package com.sinaseyfi.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewbinding.ViewBinding
import com.sinaseyfi.log.Logger
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


abstract class BaseFragment<V : ViewState, T : BaseViewModel<V>, B : ViewBinding> :
    Fragment() {

    protected abstract val viewModel: T
    private var _viewBinding: B? = null
    protected val viewBinding: B
        get() = _viewBinding ?: throw IllegalArgumentException("Trying to access the binding outside of the view lifecycle.")
    protected lateinit var navController: NavController

    @Inject
    protected lateinit var logger: Logger

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _viewBinding = createViewBinding(inflater)
        return viewBinding.root
    }

    @CallSuper
    open fun deallocate() {

    }

    final override fun onDestroyView() {
        super.onDestroyView()
        deallocate()
        _viewBinding = null
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        init()
    }

    @CallSuper
    open fun init() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.viewState.collect { renderView(it) }
        }
    }

    abstract fun renderView(state: V)
    abstract fun createViewBinding(inflater: LayoutInflater): B

    // Helper function to not use the navController directly and make the code a little cleaner:
    fun navigateUp() {
        if(this::navController.isInitialized) {
            navController.navigateUp()
        }
    }

}