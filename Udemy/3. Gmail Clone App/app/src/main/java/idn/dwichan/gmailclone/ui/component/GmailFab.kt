package idn.dwichan.gmailclone.ui.component

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable

@Composable
fun GmailFab() {
    FloatingActionButton(
        onClick = {  },
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Icon(imageVector = Icons.Default.Edit, contentDescription = "")
    }
}