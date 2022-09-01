package idn.dwichan.gmailclone.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import idn.dwichan.gmailclone.model.EmailModel
import idn.dwichan.gmailclone.util.mockMailData
import java.util.Random

@Composable
fun MailList(mailList: List<EmailModel>, paddingValues: PaddingValues) {
    Column(modifier = Modifier.padding(paddingValues)) {
        Text(
            text = "Inbox",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(mailList) { item ->
                MailItem(
                    mail = item,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
fun MailItem(mail: EmailModel, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
    ) {
        // Letter Text to replacing an empty user pic
        val random = Random()
        val maxColor = 198 // 256 too bright
        val minColor = 128 // 256 too bright
        val color = Color(
            red = random.nextInt(maxColor - minColor) + minColor,
            green = random.nextInt(maxColor - minColor) + minColor,
            blue = random.nextInt(maxColor - minColor) + minColor,
        )
        Card(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(48.dp)
                .clip(CircleShape),
            backgroundColor = color
        ) {
            Text(
                text = mail.sender[0].toString(),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
            )
        }

        // Item Content
        Column(
            modifier = Modifier.weight(2f)
        ) {
            val textModifier = Modifier
                .fillMaxWidth()
            val isRead = if (!mail.isRead) FontWeight.Bold else FontWeight.Normal
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // sender
                Text(
                    text = mail.sender,
                    modifier = Modifier.fillMaxWidth(.7f),
                    fontSize = 18.sp,
                    fontWeight = isRead,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                // date
                Text(
                    text = mail.time,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // subject and content
                Column(
                    modifier = Modifier.fillMaxWidth(.87f)
                ) {
                    Text(
                        text = mail.title,
                        fontSize = 16.sp,
                        modifier = textModifier,
                        fontWeight = isRead,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = mail.contentMail,
                        modifier = textModifier,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // star button
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .size(64.dp)
                ) {
                    val icon = if (!mail.isStarred)
                        Icons.Outlined.StarOutline
                    else
                        Icons.Filled.Star

                    val tint = if (mail.isStarred)
                        MaterialTheme.colors.primary
                    else
                        Color.Unspecified

                    Icon(
                        imageVector = icon,
                        contentDescription = "Star message",
                        tint = tint
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MailListPreview() {
    MailList(mailList = mockMailData, paddingValues = PaddingValues(0.dp))
}

@Preview(
    showBackground = true
)
@Composable
fun MailItemPreview() {
    MailItem(
        mail = EmailModel(
            id = "abc123",
            sender = "Dwi Candra Permana",
            time = "05/09/2000",
            email = "dwiii@telegroups.com",
            contentMail = "Lorem ipsum dolor sit amet, consecteteur adispicing elit. Lorem ipsum dolor sit amet, consecteteur adispicing elit. Lorem ipsum dolor sit amet, consecteteur adispicing elit. Lorem ipsum dolor sit amet, consecteteur adispicing elit. ",
            title = "Hello from Open World!",
            isRead = false,
            isStarred = true
        )
    )
}