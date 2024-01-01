import me.selemba.beep.Beep
import kotlin.test.Test
import me.selemba.fileDialog.FileDialog
import me.selemba.inputBoxDialog.InputBoxDialog
import me.selemba.messageBoxDialog.DialogType
import me.selemba.messageBoxDialog.MessageBoxButton
import me.selemba.messageBoxDialog.MessageBoxDialog
import java.io.File
import javax.management.Notification

class LoadTest {
    @Test
     fun saveDialog() {
         FileDialog.fileSaveDialogSync("Test", File("~/"))
     }

    @Test
    fun openDialog() {
        FileDialog.fileOpenDialogSingleSync("Test")
    }

    @Test
    fun messageBox(){
        MessageBoxDialog.messageBoxDialogSync("Cool Title", "Test Message", defaultButton = MessageBoxButton.OK)
    }

    @Test
    fun notification(){
        me.selemba.notification.Notification().notifySync("Hello World")
    }

    @Test
    fun inputBox(){
        InputBoxDialog.inputBoxDialogSync("Test", "test")
    }
}