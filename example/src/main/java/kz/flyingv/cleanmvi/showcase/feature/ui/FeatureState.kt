package kz.flyingv.cleanmvi.showcase.feature.ui

import kz.flyingv.cleanmvi.UIState

data class FeatureState(
    val isLoading: Boolean = false
): UIState

fun initialState() = FeatureState(
    isLoading = false
)