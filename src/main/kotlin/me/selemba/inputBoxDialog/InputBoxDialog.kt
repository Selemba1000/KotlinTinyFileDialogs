package me.selemba.inputBoxDialog

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.selemba.KotlinTinyFileDialogs.defaultScope
import me.selemba.KotlinTinyFileDialogs.inst

object InputBoxDialog {
    fun inputBoxDialogSync(
        title: String,
        message: String = "",
        inputBoxType: InputBoxType = InputBoxType.Default
    ) : String? {
        return inst.tinyfd_inputBox(title,message,inputBoxType.value)
    }

    fun inputBoxDialog(
        title: String,
        message: String = "",
        inputBoxType: InputBoxType = InputBoxType.Default,
        callback: (String?) -> Unit,
        scope: CoroutineScope = defaultScope
    ){
        scope.launch {
            callback(inputBoxDialogSync(title, message, inputBoxType))
        }
    }

    fun inputBoxDialog(
        title: String,
        message: String = "",
        inputBoxType: InputBoxType = InputBoxType.Default,
        callback: (String) -> Unit,
        callbackAbort: () -> Unit,
        scope: CoroutineScope = defaultScope
    ){
        scope.launch {
            val tmp = inputBoxDialogSync(title, message, inputBoxType)
            if(tmp.isNullOrBlank()){
                callbackAbort()
            }else{
                callback(tmp)
            }
        }
    }
}