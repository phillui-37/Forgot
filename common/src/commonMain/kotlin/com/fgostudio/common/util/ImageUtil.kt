package com.fgostudio.common.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable
expect fun getSvgPainter(filename: String): Painter