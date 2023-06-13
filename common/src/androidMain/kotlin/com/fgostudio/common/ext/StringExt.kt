package com.fgostudio.common.ext

import android.content.Context

fun String.getRawResources(ctx: Context) = ctx.resources.let { r -> r.openRawResource(r.getIdentifier(this.replace(".svg", ""), "raw", ctx.packageName)) }
