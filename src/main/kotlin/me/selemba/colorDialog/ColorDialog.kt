package me.selemba.colorDialog

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.selemba.KotlinTinyFileDialogs
import me.selemba.KotlinTinyFileDialogs.defaultScope
import me.selemba.KotlinTinyFileDialogs.inst

object ColorDialog {
    fun colorDialogSync(title: String, startColor: DialogColor? = null): DialogColor? {
        val col = inst.tinyfd_colorChooser(title, startColor?.toHex())
        if (col.isNullOrBlank()) return null
        return DialogColor.fromHex(col)
    }

    fun colorDialog(title: String, startColor: DialogColor? = null, callback: (DialogColor?) -> Unit, scope: CoroutineScope = defaultScope){
        scope.launch {
            callback(colorDialogSync(title,startColor))
        }
    }

    fun colorDialog(title: String, startColor: DialogColor? = null, callback: (DialogColor) -> Unit, callbackAbort: () -> Unit, scope: CoroutineScope = defaultScope){
        scope.launch {
            val tmp = inst.tinyfd_colorChooser(title, startColor?.toHex())
            if (tmp.isNullOrBlank()){
                callbackAbort()
            }else{
                callback(DialogColor.fromHex(tmp))
            }
        }
    }
}