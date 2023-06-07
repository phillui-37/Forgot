import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.fgostudio.common.App


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
