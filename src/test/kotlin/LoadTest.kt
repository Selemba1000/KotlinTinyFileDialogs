import kotlin.test.Test
import me.selemba.fileDialog.FileDialog
import java.io.File

class LoadTest {
    @Test
     fun saveDialog() {
         FileDialog.fileSaveDialog("Test", File("~/"),callback = {})
     }

    @Test
    fun openDialog() {
        FileDialog.fileOpenDialogSingleSync("Test")
    }
}