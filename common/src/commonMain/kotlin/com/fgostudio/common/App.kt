package com.fgostudio.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fgostudio.common.util.getSvgPainter
import com.fgostudio.common.view.TodoCardWidget
import com.fgostudio.common.view.TodoCardWidgetRow

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    Column {
        TodoCardWidgetRow {
            TodoCardWidget(
                getSvgPainter("apps.svg"),
                "test1",
                isExpand,
                false,
            ) {}
            TodoCardWidget(
                getSvgPainter("apps.svg"),
                "test2",
                isExpand,
                false,
            ) {}
            TodoCardWidget(
                getSvgPainter("apps.svg"),
                "test3",
                isExpand,
                false,
            ) {}
        }
    }
}
