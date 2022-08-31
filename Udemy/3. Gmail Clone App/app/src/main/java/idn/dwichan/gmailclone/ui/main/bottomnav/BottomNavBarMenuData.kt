package idn.dwichan.gmailclone.ui.main.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Chat
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.VideoCall
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavBarMenuData(
    val icon: ImageVector,
    val title: String
) {
    object Mail: BottomNavBarMenuData(
        icon = Icons.Outlined.Mail,
        title = "Mail"
    )
    object Chat: BottomNavBarMenuData(
        icon = Icons.Outlined.Chat,
        title = "Chat"
    )
    object Spaces: BottomNavBarMenuData(
        icon = Icons.Outlined.People,
        title = "Spaces"
    )
    object Meet: BottomNavBarMenuData(
        icon = Icons.Outlined.VideoCall,
        title = "Meet"
    )
}