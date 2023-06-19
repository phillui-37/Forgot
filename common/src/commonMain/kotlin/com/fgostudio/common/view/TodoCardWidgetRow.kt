package com.fgostudio.common.view

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface TodoCardWidgetRowScope {
    val isExpand: Boolean
}

@Composable
expect fun TodoCardWidgetRow(
    modifier: Modifier = Modifier.horizontalScroll(rememberScrollState()),
    content: @Composable TodoCardWidgetRowScope.() -> Unit
)