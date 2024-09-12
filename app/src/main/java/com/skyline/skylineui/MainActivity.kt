package com.skyline.skylineui

import com.skyline.skylineui.textfield.PassWordText
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                var password by remember { mutableStateOf("") }
                PassWordText(
                    isDarkTheme = false,
                    password = password,
                    onPasswordChange = { newPassword ->
                        password = newPassword
                    }
                )
            }
        }
    }
}
