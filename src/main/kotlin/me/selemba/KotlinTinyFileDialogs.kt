package me.selemba

import com.sun.jna.Native
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


internal object KotlinTinyFileDialogs {

    internal val inst: KotlinTinyFileDialogsInterface =
        Native.loadLibrary("tinyfiledialogs", KotlinTinyFileDialogsInterface::class.java)

    internal val defaultScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
}