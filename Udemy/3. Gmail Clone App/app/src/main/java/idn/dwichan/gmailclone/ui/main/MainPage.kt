package idn.dwichan.gmailclone.ui.main

import android.annotation.SuppressLint
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import idn.dwichan.gmailclone.ui.component.HomeAppBar
import idn.dwichan.gmailclone.ui.main.drawer.MainDrawerMenu
import idn.dwichan.gmailclone.ui.theme.GmailCloneTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainPage() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeAppBar(scaffoldState, coroutineScope) },
        drawerContent = { MainDrawerMenu(scrollState) },
        bottomBar = { MainBottomNavBar() }
    ) {

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