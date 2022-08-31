package idn.dwichan.gmailclone.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import idn.dwichan.gmailclone.model.EmailModel

@Composable
fun MailList() {

}

@Composable
fun MailItem(mail: EmailModel, modifier: Modifier = Modifier) {
    Row() {
        // Letter Text to replacing an empty user pic
        Card(
            modifier = modifier
                .padding(end = 8.dp)
                .size(48.dp)
                .clip(CircleShape),
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Text(
                text = mail.sender[0].toString(),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(8.dp)
            )
        }

        // Item Content
        Column(
            modifier = modifier.weight(2f)
        ) {
            Text(
                text = mail.sender,
                fontSize = 18.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MailItemPreview() {
    MailItem(
        mail = EmailModel(
            id = "abc123",
            sender = "Dwi Candra Permana",
            time = "05/09/2000",
            email = "dwiii@telegroups.com",
            contentMail = "Lorem ipsum dolor sit amet, consecteteur adispicing elit.",
            title = "Hello from Open World!"
        )
    )
}