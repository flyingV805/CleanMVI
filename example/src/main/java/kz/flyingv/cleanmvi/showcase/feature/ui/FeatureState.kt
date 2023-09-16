package kz.flyingv.cleanmvi.showcase.feature.ui

import kz.flyingv.cleanmvi.UIState

data class FeatureState(
    val isLoading: Boolean = false,
    val fact: String? = null
): UIState
