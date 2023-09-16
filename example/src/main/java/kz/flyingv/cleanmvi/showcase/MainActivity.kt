package kz.flyingv.cleanmvi.showcase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import kz.flyingv.cleanmvi.showcase.defaults.theme.CleanMVITheme
import kz.flyingv.cleanmvi.showcase.feature.ui.FeatureScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanMVITheme {
                // A surface container using the 'background' color from the theme
                FeatureScreen()
            }
        }
    }
}