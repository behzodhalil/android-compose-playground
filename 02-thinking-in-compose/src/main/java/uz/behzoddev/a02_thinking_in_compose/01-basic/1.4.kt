package uz.behzoddev.a02_thinking_in_compose.`01-basic`

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to basic codelab")
        Button(
            modifier = modifier.padding(24.dp),
            onClick = { onContinueClicked() }) {
            Text(text = "Continue")
        }
    }
}

@Composable
fun MyAppScreen(modifier: Modifier = Modifier) {
    val shouldShowOnboarding = remember { mutableStateOf(true) }

    Surface(modifier = modifier) {
        if (shouldShowOnboarding.value) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding.value = false })
        } else {
            GreetingElevatedButtonExpanded()
        }
    }

}

@Composable
fun Onboarding() {
}