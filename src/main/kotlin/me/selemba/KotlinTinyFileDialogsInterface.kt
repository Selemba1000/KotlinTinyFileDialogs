package me.selemba

import com.sun.jna.Library

internal interface KotlinTinyFileDialogsInterface : Library {
    fun tinyfd_beep()

    fun tinyfd_notifyPopup(aTitle: String?, aMessage: String?, aIconType: String): Int

    fun tinyfd_messageBox(
        aTitle: String?,
        aMessage: String?,
        aDialogType: String,
        aIconType: String,
        aDefaultButton: Int
    ) : Int

    fun tinyfd_inputBox(
        aTitle: String?,
        aMessage: String?,
        aDefaultInput: String?
    ) : String?

    fun tinyfd_saveFileDialog(
        aTitle: String?,
        aDefaultPathAndFile: String?,
        aNumOfFilterPatterns: Int,
        aFilterPatterns: Array<String>?,
        aSingleFilterDescription: String?
    ): String?

    fun tinyfd_openFileDialog(
        aTitle: String?,
        aDefaultPathAndFile: String?,
        aNumOfFilterPatterns: Int,
        aFilterPatterns: Array<String>?,
        aSingleFilterDescription: String?,
        aAllowMultipleSelects: Int
    ): String?

    fun tinyfd_selectFolderDialog(aTitle: String?, aDefaultPath: String?): String?

    fun tinyfd_colorChooser(aTitle: String?, aDefaultHexRGB: String?): String?
}