package com.fgostudio.common.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.loadSvgPainter
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.Density

@Composable
actual fun getSvgPainter(filename: String): Painter {
    return useResource(filename.let { if (!it.endsWith(".svg")) "${it}.svg" else it }) { loadSvgPainter(it, Density(10f)) }
}