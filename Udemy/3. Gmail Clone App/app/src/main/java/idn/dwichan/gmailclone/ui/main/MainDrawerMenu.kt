package idn.dwichan.gmailclone.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import idn.dwichan.gmailclone.ui.theme.GmailCloneTheme

@Composable
fun MainDrawerMenu() {
    val menuList = listOf(
        DrawerMenuData.Separator,
        DrawerMenuData.AllInboxes,
        DrawerMenuData.Separator,
        DrawerMenuData.Inbox,

        DrawerMenuData.AllLabels,
        DrawerMenuData.Starred,
        DrawerMenuData.Unread,
        DrawerMenuData.Drafts,
        DrawerMenuData.Outbox,
        DrawerMenuData.Sent,
        DrawerMenuData.Trash,
        DrawerMenuData.Spam,

        DrawerMenuData.GoogleApps,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,

        DrawerMenuData.Separator,
        DrawerMenuData.Settings,
        DrawerMenuData.HelpAndFeedback
    )

    Column {
        Text(
            text = "Gmail",
            color = Color.Red,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainDrawerMenuPreview() {
    GmailCloneTheme {
        MainDrawerMenu()
    }
}