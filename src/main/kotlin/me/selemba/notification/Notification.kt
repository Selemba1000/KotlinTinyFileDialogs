package me.selemba.notification

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import me.selemba.KotlinTinyFileDialogs.defaultScope
import me.selemba.KotlinTinyFileDialogs.inst

object Notification {
    fun notifySync(title: String, message: String = "", icon: NotificationIcon = NotificationIcon.Info) {
        inst.tinyfd_notifyPopup(title, message, icon.value)
    }

    fun notify(title: String, message: String = "", icon: NotificationIcon = NotificationIcon.Info, scope: CoroutineScope = defaultScope){
        scope.launch {
            notifySync(title, message, icon)
        }
    }
}