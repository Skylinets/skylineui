package com.skyline.skylineui.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun PassWordText(isDarkTheme: Boolean, password: String, onPasswordChange: (String) -> Unit) {
    val passwordVisible = remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = onPasswordChange,
        label = { Text("Password") },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            val image = if (passwordVisible.value) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }

            IconButton(onClick = {
                passwordVisible.value = !passwordVisible.value
            }) {
                Icon(imageVector = image, contentDescription = if (passwordVisible.value) "Hide password" else "Show password")
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = if (isDarkTheme) Color.White else Color.Black,
            unfocusedIndicatorColor = if (isDarkTheme) Color.LightGray else Color.DarkGray
        )
    )
}