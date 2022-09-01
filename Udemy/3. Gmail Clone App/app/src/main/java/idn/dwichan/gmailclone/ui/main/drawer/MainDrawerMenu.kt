package idn.dwichan.gmailclone.ui.main.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import idn.dwichan.gmailclone.ui.theme.GmailCloneTheme

@Composable
fun MainDrawerMenu(scrollState: ScrollState) {
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

    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        Text(
            text = "Gmail",
            color = Color.Red,
            modifier = Modifier.padding(start = 18.dp, top = 18.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        menuList.forEach { item ->
            when {
                item.isDivider -> {
                    // line divider
                    Divider(modifier = Modifier.padding(vertical = 16.dp))
                }
                item.isHeader -> {
                    Text(
                        text = item.title!!,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
                else -> {
                    MainDrawerItem(item = item)
                }
            }
        }
    }
}

@Composable
fun MainDrawerItem(item: DrawerMenuData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(8.dp)
            .clickable {  }
    ) {
        Image(
            painter = painterResource(id = item.icon!!),
            contentDescription = item.title,
            modifier = Modifier.weight(.5f)
        )
        Text(
            text = item.title!!,
            modifier = Modifier
                .weight(2f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainDrawerMenuPreview() {
    GmailCloneTheme {
        MainDrawerMenu(rememberScrollState())
    }
}