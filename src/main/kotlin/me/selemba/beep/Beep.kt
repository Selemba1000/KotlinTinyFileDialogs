package me.selemba.beep

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.selemba.KotlinTinyFileDialogs
import me.selemba.KotlinTinyFileDialogs.defaultScope

object Beep {
    fun beepSync() {
        KotlinTinyFileDialogs.inst.tinyfd_beep()
    }

    fun beep(scope: CoroutineScope = defaultScope){
        scope.launch {
            beepSync()
        }
    }
}