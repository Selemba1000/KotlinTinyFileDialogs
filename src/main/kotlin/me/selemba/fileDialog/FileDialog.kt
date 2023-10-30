package me.selemba.fileDialog

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.selemba.KotlinTinyFileDialogs.defaultScope
import me.selemba.KotlinTinyFileDialogs.inst
import java.io.File

object FileDialog {
    fun fileSaveDialogSync(
        title: String,
        startPath: File? = null,
        filePattern: FilePattern = FilePattern(),
        filePatternDescription: String? = null
    ): File? {
        val file = inst.tinyfd_saveFileDialog(
            title,
            startPath?.path,
            filePattern.regex.size,
            filePattern.regex.map { it }.toTypedArray(),
            filePatternDescription
        )
        if (file.isNullOrBlank()) return null
        return File(file)
    }

    fun fileSaveDialog(
        title: String,
        startPath: File? = null,
        filePattern: FilePattern = FilePattern(),
        filePatternDescription: String? = null,
        callback: (File?) -> Unit,
        scope: CoroutineScope = defaultScope
    ){
        scope.launch {
            callback(fileSaveDialogSync(title, startPath, filePattern, filePatternDescription))
        }
    }

    fun fileSaveDialog(
        title: String,
        startPath: File? = null,
        filePattern: FilePattern = FilePattern(),
        filePatternDescription: String? = null,
        callback: (File) -> Unit,
        callbackAbort: () -> Unit,
        scope: CoroutineScope = defaultScope
    ){
        scope.launch {
            val file = inst.tinyfd_saveFileDialog(
                title,
                startPath?.path,
                filePattern.regex.size,
                filePattern.regex.map { it }.toTypedArray(),
                filePatternDescription
            )
            if (file.isNullOrBlank()) callbackAbort()
            else callback(File(file))
        }
    }

    fun fileOpenDialogSingleSync(
        title: String,
        startPath: File? = null,
        filePattern: FilePattern = FilePattern(),
        filePatternDescription: String? = null
    ): File? {
        val file = inst.tinyfd_openFileDialog(
            title,
            startPath?.path,
            filePattern.regex.size,
            filePattern.regex.map { it }.toTypedArray(),
            filePatternDescription,
            0
        )
        if (file.isNullOrBlank()) return null
        return File(file)
    }

    fun fileOpenDialogSingle(
        title: String,
        startPath: File? = null,
        filePattern: FilePattern = FilePattern(),
        filePatternDescription: String? = null,
        callback: (File?) -> Unit,
        scope: CoroutineScope = defaultScope
    ){
        scope.launch{
            callback(fileOpenDialogSingleSync(title, startPath, filePattern, filePatternDescription))
        }
    }

    fun fileOpenDialogSingle(
        title: String,
        startPath: File? = null,
        filePattern: FilePattern = FilePattern(),
        filePatternDescription: String? = null,
        callback: (File) -> Unit,
        callbackAbort: () -> Unit,
        scope: CoroutineScope = defaultScope
    ){
        scope.launch{
            val file = inst.tinyfd_openFileDialog(
                title,
                startPath?.path,
                filePattern.regex.size,
                filePattern.regex.map { it }.toTypedArray(),
                filePatternDescription,
                0
            )
            if (file.isNullOrBlank()) callbackAbort()
            else callback(File(file))
        }
    }

    fun fileOpenDialogMultiSync(
        title: String,
        startPath: File? = null,
        filePattern: FilePattern = FilePattern(),
        filePatternDescription: String? = null
    ): List<File>? {
        val filestr = inst.tinyfd_openFileDialog(
            title,
            startPath?.path,
            filePattern.regex.size,
            filePattern.regex.map { it }.toTypedArray(),
            filePatternDescription,
            1
        )
        if (filestr.isNullOrBlank()) return null
        val files = filestr.split("|")
        return files.map { File(it) }
    }

    fun fileOpenDialogMulti(
        title: String,
        startPath: File? = null,
        filePattern: FilePattern = FilePattern(),
        filePatternDescription: String? = null,
        callback: (List<File>?) -> Unit,
        scope: CoroutineScope = defaultScope
    ){
        scope.launch {
            callback(fileOpenDialogMultiSync(title, startPath, filePattern, filePatternDescription))
        }
    }

    fun fileOpenDialogMulti(
        title: String,
        startPath: File? = null,
        filePattern: FilePattern = FilePattern(),
        filePatternDescription: String? = null,
        callback: (List<File>) -> Unit,
        callbackAbort: () -> Unit,
        scope: CoroutineScope = defaultScope
    ){
        scope.launch {
            val filestr = inst.tinyfd_openFileDialog(
                title,
                startPath?.path,
                filePattern.regex.size,
                filePattern.regex.map { it }.toTypedArray(),
                filePatternDescription,
                1
            )
            if (filestr.isNullOrBlank()) callbackAbort()
            else{
                val files = filestr.split("|")
                callback(files.map { File(it) })
            }
        }
    }

    fun directoryOpenDialogSync(title: String, startPath: File? = null): File? {
        val dir = inst.tinyfd_selectFolderDialog(title, startPath?.path)
        if (dir.isNullOrBlank()) return null
        return File(dir)
    }

    fun directoryOpenDialog(title: String, startPath: File? = null, callback: (File?) -> Unit, scope: CoroutineScope = defaultScope){
        scope.launch {
            callback(directoryOpenDialogSync(title, startPath))
        }
    }

    fun directoryOpenDialogSync(title: String, startPath: File? = null, callback: (File) -> Unit, callbackAbort: () -> Unit, scope: CoroutineScope = defaultScope) {
        scope.launch {
            val dir = inst.tinyfd_selectFolderDialog(title, startPath?.path)
            if (dir.isNullOrBlank()) callbackAbort()
            else callback(File(dir))
        }
    }
}