package me.selemba.fileDialog

open class FilePattern(vararg val regex: String) {
    companion object {
        val AudioFiles = FilePattern("*.ogg", "*.mp3", "*.wav")
    }
}