package com.paras.generatedapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.paras.generatedapp.ui.Script2VideoAppRoot
import com.paras.generatedapp.ui.theme.Script2VideoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Script2VideoTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Script2VideoAppRoot()
                }
            }
        }
    }
}
