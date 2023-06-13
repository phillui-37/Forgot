package com.fgostudio.common.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.fgostudio.common.R
import com.fgostudio.common.util.getSvgImageRequest
import com.fgostudio.common.util.toImagePainter

@Composable
actual fun TodoCardWidgetRow(
    vararg widgets: Array<(@Composable Boolean) -> Unit>
) {
    var isExpand by remember { mutableStateOf(false) }

    val ctx = LocalContext.current
    val painter = getSvgImageRequest(ctx, "apps").toImagePainter()


    Image(painter, null)
}