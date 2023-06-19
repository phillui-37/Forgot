package com.fgostudio.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fgostudio.common.util.getLogProxy
import com.fgostudio.common.util.getSvgPainter
import com.fgostudio.common.view.TodoCardWidget
import com.fgostudio.common.view.TodoCardWidgetRow

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App() {
    val logger = getLogProxy("App")
    var isOpenDialog by remember { mutableStateOf(false) }

    Column {
        TodoCardWidgetRow {
            TodoCardWidget(
                getSvgPainter("end.svg"),
                "Deadline",
                isExpand,
                true,
            ) {
                isOpenDialog = true
            }
            TodoCardWidget(
                getSvgPainter("calendar.svg"),
                "Schedule",
                isExpand,
                true,
            )
            TodoCardWidget(
                getSvgPainter("reminder.svg"),
                "Reminder",
                isExpand,
                true,
            )
            TodoCardWidget(
                getSvgPainter("priority.svg"),
                "Priority",
                isExpand,
                false,
            )
        }

        if (isOpenDialog)
            AlertDialog(
                onDismissRequest = {
                    logger.d("dismiss")
                    isOpenDialog = false
                },
                buttons = {
                    Row(modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
                        Button(
                            onClick = {
                                logger.d("Cancel")
                                isOpenDialog = false
                            }
                        ) {
                            Text("Cancel")
                        }
                        Spacer(Modifier.weight(1f))
                        Button(
                            onClick = {
                                logger.d("confirm")
                                isOpenDialog = false
                            }
                        ) {
                            Text("OK")
                        }
                    }
                },
                title = { Text("I believe I can fly") },
                text = { Text("I believe I can touch the sky") }
            )
    }
}
