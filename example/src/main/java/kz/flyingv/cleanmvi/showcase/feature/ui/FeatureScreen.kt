package kz.flyingv.cleanmvi.showcase.feature.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FeatureScreen(viewModel: FeatureViewModel = hiltViewModel()) {

    val uiState by viewModel.provideState().collectAsState()


    LaunchedEffect(Unit){
        viewModel.reduce(FeatureAction.UpdateFact)
    }

}