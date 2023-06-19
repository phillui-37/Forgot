package com.fgostudio.common.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.loadSvgPainter
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import com.fgostudio.common.util.getSvgPainter
import com.fgostudio.common.widgetExt.defaultConf.ButtonConf

@Composable
actual fun TodoCardWidgetRow(
    modifier: Modifier,
    content: @Composable TodoCardWidgetRowScope.() -> Unit
) {
    var isExpand by remember { mutableStateOf(false) }

    val scope = object: TodoCardWidgetRowScope {
        override val isExpand: Boolean
            get() = isExpand
    }

    val localModifier = Modifier.padding(10.dp)

    Row(
        modifier = modifier.then(localModifier)
    ) {
        scope.content()
        Spacer(Modifier.weight(1f))
        Button(
            onClick = { isExpand = !isExpand },
            elevation = ButtonConf.ElevationConf.No(),
            colors = ButtonConf.ColorConf.Transparent(),
        ) {
            Image(getSvgPainter(if (isExpand) "collapse" else "expand"), null, Modifier.width(40.dp))
        }
    }
}