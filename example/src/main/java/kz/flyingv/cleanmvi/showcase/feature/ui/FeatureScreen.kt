package kz.flyingv.cleanmvi.showcase.feature.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun FeatureScreen(viewModel: FeatureViewModel = hiltViewModel()) {

    val uiState by viewModel.provideState().collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            AnimatedVisibility(visible = uiState.isLoading) {
                CircularProgressIndicator()
            }

            Text(
                text = uiState.fact ?: "Cant load fact",
            )

            Button(onClick = { viewModel.reduce(FeatureAction.UpdateFact) }) {
                Text("UPDATE")
            }



        }



    }

    LaunchedEffect(Unit){
        viewModel.reduce(FeatureAction.UpdateFact)
    }

    LaunchedEffect(Unit){
        viewModel.provideEvents().collectLatest {

        }
    }


}