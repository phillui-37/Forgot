package com.fgostudio.common.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ParentDataModifier
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

    val localModifier = Modifier.height(IntrinsicSize.Min).padding(10.dp)

    Row (
        modifier = modifier.then(localModifier)
    ) {
        scope.content()
        Spacer(Modifier.weight(1f))
        PlainButton(
            onClick = { isExpand = !isExpand },
        ) {
            Image(getSvgPainter(if (isExpand) "collapse" else "expand"), null, Modifier.width(10.dp))
        }
    }
}