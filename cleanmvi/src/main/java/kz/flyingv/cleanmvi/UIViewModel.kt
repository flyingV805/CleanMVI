package kz.flyingv.cleanmvi

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kz.flyingv.cleanmvi.tools.timemachine.TimeMachine

abstract class UIViewModel<S : UIState, in A : UIAction>(
    initialState: S,
    private val timeMachine: TimeMachine<S, A>? = null
): ViewModel() {

    private val _uiState = MutableStateFlow(initialState)

    fun provideState(): StateFlow<S> = _uiState.asStateFlow()

    protected fun currentState(): S = _uiState.value

    protected fun pushState(newState: S){
        timeMachine?.stateEmitted(newState)
        _uiState.tryEmit(newState)
    }

    @CallSuper
    open fun reduce(action: A){
        timeMachine?.actionMade(action)
    }

}