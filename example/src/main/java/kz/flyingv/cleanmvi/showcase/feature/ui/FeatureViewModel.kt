package kz.flyingv.cleanmvi.showcase.feature.ui

import kz.flyingv.cleanmvi.UIViewModel

class FeatureViewModel(): UIViewModel<FeatureState, FeatureAction>(initialState = FeatureState()) {


    override fun reduce(action: FeatureAction) {

        currentState().copy()

    }


}