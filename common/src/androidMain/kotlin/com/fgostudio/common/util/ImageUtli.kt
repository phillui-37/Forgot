package com.fgostudio.common.util

import android.content.Context
import androidx.compose.runtime.Composable
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