package me.selemba.messageBoxDialog

enum class MessageBoxButton(val value: (DialogType) -> Int) {
    OK({
        if (it == DialogType.OK || it == DialogType.OKCancel) {
            1
        } else throw InvalidButtonException(OK, it)
    }),
    Cancel({
        if (it == DialogType.OKCancel || it == DialogType.YesNoCancel) {
            0
        } else throw InvalidButtonException(Cancel, it)
    }),
    Yes({
        if (it == DialogType.YesNo || it == DialogType.YesNoCancel) {
            1
        } else throw InvalidButtonException(Yes, it)
    }),
    No({
        when (it) {
            DialogType.YesNo -> 0
            DialogType.YesNoCancel -> 2
            else -> throw InvalidButtonException(No, it)
        }
    })
}

internal fun parseMessageBoxButton(dialogType: DialogType, button: Int): MessageBoxButton {
    when (dialogType) {
        DialogType.OK -> return MessageBoxButton.OK
        DialogType.OKCancel -> return when (button) {
            0 -> MessageBoxButton.Cancel
            1 -> MessageBoxButton.OK
            else -> throw InvalidButtonResponseCodeException(
                button,
                dialogType
            )
        }

        DialogType.YesNo -> return when (button) {
            0 -> MessageBoxButton.No
            1 -> MessageBoxButton.Yes
            else -> throw InvalidButtonResponseCodeException(button, dialogType)
        }

        DialogType.YesNoCancel -> return when (button) {
            0 -> MessageBoxButton.Cancel
            1 -> MessageBoxButton.Yes
            2 -> MessageBoxButton.No
            else -> throw InvalidButtonResponseCodeException(button, dialogType)
        }
    }
}

final class InvalidButtonResponseCodeException(val buttonCode: Int, val dialogType: DialogType) : Exception() {
    override val message: String = "The buttoncode $buttonCode is not available in dialogtype $dialogType."
}

final class InvalidButtonException(val button: MessageBoxButton, val dialogType: DialogType) : Exception() {
    override val message: String = "The button $button is not available in dialogtype $dialogType."
}