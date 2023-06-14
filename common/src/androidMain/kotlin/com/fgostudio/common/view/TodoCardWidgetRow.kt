package com.fgostudio.common.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.fgostudio.common.util.getSvgImageRequest
import com.fgostudio.common.util.getSvgPainter
import com.fgostudio.common.util.toImagePainter

@Composable
actual fun TodoCardWidgetRow(
    content: @Composable TodoCardWidgetRowScope.() -> Unit
) {
    var isExpand by remember { mutableStateOf(false) }
    val scope = object: TodoCardWidgetRowScope {
        override val isExpand: Boolean
            get() = isExpand
    }

    Row (modifier = Modifier.padding(10.dp)) {
        scope.content()
        Spacer(Modifier.weight(1f))
        Button(
            onClick = { isExpand = !isExpand },
            colors = ButtonDefaults.buttonColors(Color.Transparent),
        ) {
            Image(getSvgPainter(if (isExpand) "collapse" else "expand"), null, Modifier.width(10.dp))
        }
    }
}