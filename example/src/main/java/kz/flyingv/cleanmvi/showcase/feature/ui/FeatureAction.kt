package kz.flyingv.cleanmvi.showcase.feature.ui

import kz.flyingv.cleanmvi.UIAction

sealed class FeatureAction: UIAction {

    object UpdateFact: FeatureAction()


}