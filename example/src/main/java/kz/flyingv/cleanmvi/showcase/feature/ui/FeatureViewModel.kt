package kz.flyingv.cleanmvi.showcase.feature.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.flyingv.cleanmvi.UIViewModel
import kz.flyingv.cleanmvi.showcase.feature.domain.usecase.FeatureUseCase
import kz.flyingv.cleanmvi.tools.timemachine.TimeMachineProvider
import javax.inject.Inject

@HiltViewModel
class FeatureViewModel @Inject constructor(
    private val useCase: FeatureUseCase
): UIViewModel<FeatureState, FeatureAction, FeatureEvent>(
    initialState = FeatureState(),
    timeMachine = TimeMachineProvider<FeatureState, FeatureAction>().default()
) {

    override fun reduce(action: FeatureAction) {
        super.reduce(action)
        when(action){
            is FeatureAction.UpdateFact -> {
                pushState(currentState().copy(isLoading = true))
                viewModelScope.launch(Dispatchers.IO) {
                    val newFact = useCase()
                    pushState(currentState().copy(
                        fact = newFact?.factContent,
                        isLoading = false
                    ))
                }
            }
        }

    }


}