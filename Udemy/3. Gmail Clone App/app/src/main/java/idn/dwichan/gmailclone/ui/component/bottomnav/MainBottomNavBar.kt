package idn.dwichan.gmailclone.ui.main

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import idn.dwichan.gmailclone.ui.component.bottomnav.BottomNavBarMenuData
import idn.dwichan.gmailclone.ui.theme.GmailCloneTheme

@Composable
fun MainBottomNavBar() {
    val menuItems = listOf(
        BottomNavBarMenuData.Mail,
        BottomNavBarMenuData.Chat,
        BottomNavBarMenuData.Spaces,
        BottomNavBarMenuData.Meet
    )

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        menuItems.forEach { item ->
            BottomNavigationItem(
                selected = false,
                onClick = {  },
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) }
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MainBottomNavBarPreview() {
    GmailCloneTheme {
        MainBottomNavBar()
    }
}