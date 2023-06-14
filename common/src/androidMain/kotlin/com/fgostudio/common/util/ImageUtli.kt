package com.fgostudio.common.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.fgostudio.common.ext.getRawResources


fun getSvgImageRequest(
    ctx: Context,
    filename: String,
    size: Size = Size.ORIGINAL
): ImageRequest {
    return ImageRequest.Builder(ctx)
        .decoderFactory(SvgDecoder.Factory())
        .data(filename.getRawResources(ctx).readBytes())
        .size(size)
        .build()
}

@Composable
fun ImageRequest.toImagePainter() = rememberAsyncImagePainter(this)

@Composable
actual fun getSvgPainter(filename: String): Painter {
    return getSvgImageRequest(LocalContext.current, filename.removeSuffix(".svg")).toImagePainter()
}