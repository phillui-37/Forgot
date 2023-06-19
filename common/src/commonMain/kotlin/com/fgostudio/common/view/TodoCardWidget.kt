package com.fgostudio.common.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Shapes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TodoCardWidget(
    painter: Painter,
    title: String,
    isExpand: Boolean,
    isActive: Boolean,
    onClick: () -> Unit = {},
) {
    PlainButton(
        onClick = onClick
    ) {
        if (isExpand && isActive)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.border(border = BorderStroke(2.dp, Color.Gray), shape = RoundedCornerShape(5.dp)).padding(5.dp)
            ) {
                Image(painter, null, Modifier.width(40.dp).height(40.dp))
                Text(text = title, textAlign = TextAlign.Center)
            }
        else if (isExpand)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.border(border = BorderStroke(2.dp, Color.Gray), shape = RoundedCornerShape(5.dp)).padding(5.dp)
            ) {
                Image(painter = painter,contentDescription = null, modifier =  Modifier.width(40.dp).height(40.dp), colorFilter = ColorFilter.tint(Color.Gray))
            }
        else
            Image(painter, null, Modifier.width(40.dp).height(40.dp))
    }
}