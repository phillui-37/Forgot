package com.fgostudio.common.view

import androidx.compose.runtime.Composable

@Composable
expect fun TodoCardWidgetRow(
    vararg widgets: Array<@Composable (Boolean) -> Unit>
)