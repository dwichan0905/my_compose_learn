package idn.dwichan.dogprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 100.dp,
                bottom = 100.dp,
                start = 16.dp,
                end = 16.dp
            )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // ConstraintLayout IDs
            val (
                image,
                name,
                country,
                profileStats,
                followButton,
                messageButton
            ) = createRefs()

            val guideline = createGuidelineFromTop(fraction = 0.25F)

            Image(
                painter = painterResource(id = R.drawable.husky),
                contentDescription = "Husky",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Red,
                        shape = CircleShape
                    )
                    .constrainAs(image) {
                        top.linkTo(guideline)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Siberian Husky",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(name) {
                        top.linkTo(image.bottom)
                        start.linkTo(image.start)
                        end.linkTo(image.end)
                    }
            )
            Text(
                text = "Germany",
                modifier = Modifier
                    .constrainAs(country) {
                        top.linkTo(name.bottom)
                        start.linkTo(name.start)
                        end.linkTo(name.end)
                    }
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(profileStats) {
                        top.linkTo(country.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                ProfileStats(count = 150, title = "Followers")
                ProfileStats(count = 120, title = "Following")
                ProfileStats(count = 10, title = "Posts")
            }

            Button(
                onClick = {  },
                modifier = Modifier
                    .constrainAs(followButton) {
                        top.linkTo(profileStats.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(messageButton.start)
                        width = Dimension.wrapContent
                    }
            ) {
                Text(text = "Follow user")
            }
            Button(
                onClick = {  },
                modifier = Modifier
                    .constrainAs(messageButton) {
                        top.linkTo(profileStats.bottom, margin = 16.dp)
                        start.linkTo(followButton.end)
                        end.linkTo(parent.end)
                        width = Dimension.wrapContent
                    }
            ) {
                Text(text = "Message")
            }
        }
    }
}

@Composable
fun ProfileStats(count: Int, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count.toString(), fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

@Preview(
    showBackground = true,
    name = "Profile Page Preview",
    showSystemUi = true
)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}