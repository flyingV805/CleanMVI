package kz.flyingv.cleanmvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class UIViewModel<S : UIState, in A : UIAction>(initialState: S): ViewModel() {

    private val _uiState = MutableStateFlow(initialState)

    fun provideState(): StateFlow<S> = _uiState.asStateFlow()

    protected fun currentState(): S = _uiState.value

    protected fun pushState(newState: S){
        _uiState.tryEmit(newState)
    }

    abstract fun reduce(action: A)

}