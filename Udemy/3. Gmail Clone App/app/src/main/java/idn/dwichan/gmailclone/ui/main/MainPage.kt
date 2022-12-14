package idn.dwichan.gmailclone.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import idn.dwichan.gmailclone.ui.component.GmailFab
import idn.dwichan.gmailclone.ui.component.HomeAppBar
import idn.dwichan.gmailclone.ui.component.drawer.MainDrawerMenu
import idn.dwichan.gmailclone.ui.theme.GmailCloneTheme
import idn.dwichan.gmailclone.util.AssetReader

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainPage() {
    val context = LocalContext.current

    val scaffoldState = rememberScaffoldState()
    val scaffoldScrollState = rememberScrollState()

    val coroutineScope = rememberCoroutineScope()
    val drawerScrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState, coroutineScope) },
        drawerContent = { MainDrawerMenu(drawerScrollState) },
        bottomBar = { MainBottomNavBar() },
        floatingActionButton = { GmailFab(scaffoldScrollState) }
    ) {
        val mailList = AssetReader.getEmails(context)
        MailList(
            mailList = mailList,
            paddingValues = it,
            scrollState = scaffoldScrollState
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MainPagePreview() {
    GmailCloneTheme {
        MainPage()
    }
}