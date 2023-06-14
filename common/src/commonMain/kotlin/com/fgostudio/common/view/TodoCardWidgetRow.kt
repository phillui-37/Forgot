package com.fgostudio.common.view

import androidx.compose.runtime.Composable

interface TodoCardWidgetRowScope {
    val isExpand: Boolean
}

@Composable
expect fun TodoCardWidgetRow(
    content: @Composable TodoCardWidgetRowScope.() -> Unit
)