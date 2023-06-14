package com.fgostudio.common.widgetExt.defaultConf

import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object ButtonConf {
    object ElevationConf {
        @Composable
        fun No() = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp)
    }

    object ColorConf {
        @Composable
        fun Transparent() = ButtonDefaults.buttonColors(Color.Transparent)
    }
}