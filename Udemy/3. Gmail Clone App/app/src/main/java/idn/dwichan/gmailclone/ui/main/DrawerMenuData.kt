package idn.dwichan.gmailclone.ui.main

import androidx.annotation.DrawableRes
import idn.dwichan.gmailclone.R

sealed class DrawerMenuData(
    @DrawableRes val icon: Int? = null, // use ImageVector when you uses the material-icons-extended dependency!
    val title: String? = null,
    val isDivider: Boolean = false,
    val isHeader: Boolean = false
) {
    object Separator0: DrawerMenuData(isDivider = true)
    object AllInboxes: DrawerMenuData(
        icon = R.drawable.ic_baseline_all_inbox_24,
        title = "All inboxes"
    )
    object Separator1: DrawerMenuData(isDivider = true)
    object Inbox: DrawerMenuData(
        icon = R.drawable.ic_baseline_inbox_24,
        title = "Inbox"
    )
    object AllLabels: DrawerMenuData(
        title = "ALL LABELS",
        isHeader = true
    )
    object Starred: DrawerMenuData(
        icon = R.drawable.ic_baseline_star_border_24,
        title = "Starred"
    )
    object Unread: DrawerMenuData(
        icon = R.drawable.ic_baseline_mark_email_unread_24,
        title = "Unread"
    )
    object Drafts: DrawerMenuData(
        icon = R.drawable.ic_baseline_drafts_24,
        title = "Drafts"
    )
    object Outbox: DrawerMenuData(
        icon = R.drawable.ic_baseline_arrow_outward_24,
        title = "Outbox"
    )
    object Sent: DrawerMenuData(
        icon = R.drawable.ic_baseline_send_24,
        title = "Sent"
    )
    object Trash: DrawerMenuData(
        icon = R.drawable.ic_outline_delete_24,
        title = "Trash"
    )
    object Spam: DrawerMenuData(
        icon = R.drawable.ic_baseline_warning_24,
        title = "Spam"
    )
    object GoogleApps: DrawerMenuData(
        title = "GOOGLE APPS",
        isHeader = true
    )
    object Calendar: DrawerMenuData(
        icon = R.drawable.ic_baseline_calendar_today_24,
        title = "Calendar"
    )
    object Contacts: DrawerMenuData(
        icon = R.drawable.ic_baseline_mark_email_unread_24,
        title = "Contacts"
    )
    object Separator2: DrawerMenuData(isDivider = true)
    object Settings: DrawerMenuData(
        icon = R.drawable.ic_baseline_settings_24,
        title = "Settings"
    )
    object HelpAndFeedback: DrawerMenuData(
        icon = R.drawable.ic_baseline_help_outline_24,
        title = "Help & feedback"
    )
}
