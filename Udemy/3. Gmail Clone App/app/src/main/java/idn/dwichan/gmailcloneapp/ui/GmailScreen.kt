package idn.dwichan.gmailcloneapp.ui

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import idn.dwichan.gmailcloneapp.ui.component.HomeAppBar
import idn.dwichan.gmailcloneapp.ui.theme.GmailCloneAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GmailScreen() {
    // default Material3 UI Layout such as topAppBar, botomAppBar, etc...
    Scaffold(
        topBar = { HomeAppBar() }
    ) {

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Gmail App Clone UI"
)
@Composable
fun GmailScreenPreview() {
    GmailCloneAppTheme {
        GmailScreen()
    }
}