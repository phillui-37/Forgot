package com.fgostudio.common.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fgostudio.common.util.getSvgPainter
import com.fgostudio.common.widgetExt.defaultConf.ButtonConf

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
            elevation = ButtonConf.ElevationConf.No(),
            colors = ButtonConf.ColorConf.Transparent(),
        ) {
            Image(getSvgPainter(if (isExpand) "collapse" else "expand"), null, Modifier.width(10.dp))
        }
    }
}