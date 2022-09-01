package idn.dwichan.gmailclone.ui.component

import androidx.compose.foundation.ScrollState
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable

@Composable
fun GmailFab(scrollState: ScrollState) {
    if (scrollState.value <= 100) {
        ExtendedFloatingActionButton(
            icon = { Icon(imageVector = Icons.Default.Edit, contentDescription = "") },
            text = { Text(text = "Compose") },
            onClick = {  },
            backgroundColor = MaterialTheme.colors.surface
        )
    } else {
        FloatingActionButton(
            onClick = {  },
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "")
        }
    }
}