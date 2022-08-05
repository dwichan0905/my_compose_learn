package idn.dwichan.gmailcloneapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import idn.dwichan.gmailcloneapp.ui.theme.GmailCloneAppTheme

@Composable
fun GmailScreen() {

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