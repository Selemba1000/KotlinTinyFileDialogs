package me.selemba.messageBoxDialog

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.selemba.KotlinTinyFileDialogs.defaultScope
import me.selemba.KotlinTinyFileDialogs.inst

object MessageBoxDialog {
    fun messageBoxDialogSync(
        title: String,
        message: String = "",
        dialogType: DialogType = DialogType.OK,
        icon: MessageBoxIcon = MessageBoxIcon.Question,
        defaultButton: MessageBoxButton?
    ) : MessageBoxButton {
        val button = inst.tinyfd_messageBox(title,message,dialogType.value,icon.value,defaultButton?.value?.invoke(dialogType)?:0)
        return parseMessageBoxButton(dialogType,button)
    }

    fun messageBoxDialog(
        title: String,
        message: String = "",
        dialogType: DialogType = DialogType.OK,
        icon: MessageBoxIcon = MessageBoxIcon.Question,
        defaultButton: MessageBoxButton?,
        callback: (MessageBoxButton) -> Unit,
        scope: CoroutineScope = defaultScope
    ){
        scope.launch {
            callback(messageBoxDialogSync(title, message, dialogType, icon, defaultButton))
        }
    }
}