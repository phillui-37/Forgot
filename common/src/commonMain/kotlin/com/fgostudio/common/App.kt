package com.fgostudio.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val platformName = getPlatformName()

    Column {
        Row {
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    text = "Hello, ${platformName}"
                }) {
                Text(text)
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = {
            text = "Hello, ${platformName}"
        }) {
            Text(text)
        }
    }
}
