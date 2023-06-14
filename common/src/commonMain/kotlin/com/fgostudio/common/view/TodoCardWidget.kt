package com.fgostudio.common.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun TodoCardWidget(
    painter: Painter,
    title: String,
    isExpand: Boolean,
    isActive: Boolean,
    onClick: () -> Unit,
) {
    if (isExpand)
        Row {
            Image(painter, null, Modifier.width(40.dp).height(40.dp))
            Text(title)
        }
    else
        Image(painter, null, Modifier.width(40.dp).height(40.dp))
}