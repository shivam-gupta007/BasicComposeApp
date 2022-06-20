package com.app.basiccomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import com.app.basiccomposeapp.ui.theme.BasicComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicComposeAppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var showOnBoardingScreen by rememberSaveable { mutableStateOf(true) }

    if (showOnBoardingScreen) {
        OnBoardingScreen(onContinueButtonClicked = { showOnBoardingScreen = false })
    } else {
        HomeScreen()
    }
}


@Preview(showBackground = true, widthDp = 400)
@Composable
fun DefaultPreview() {
    BasicComposeAppTheme {
        HomeScreen()
    }
}