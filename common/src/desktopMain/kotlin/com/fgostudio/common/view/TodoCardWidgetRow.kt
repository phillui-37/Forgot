package com.fgostudio.common.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.res.loadSvgPainter
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.Density


//typealias WidgetEntry = (Boolean, )

@Composable
actual fun TodoCardWidgetRow(
    vararg widgets: Array<@Composable (Boolean) -> Unit>
) {
    var isExpand by remember { mutableStateOf(false) }

    val painter = useResource("apps.svg") { loadSvgPainter(it, Density(10f)) }
    Image(painter, null)
}