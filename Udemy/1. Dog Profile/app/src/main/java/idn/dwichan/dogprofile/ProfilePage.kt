package idn.dwichan.dogprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

private const val LAYOUT_ID_IMAGE = "image"
private const val LAYOUT_ID_NAME = "name"
private const val LAYOUT_ID_COUNTRY = "country"
private const val LAYOUT_ID_PROFILE_STATS = "profileStats"
private const val LAYOUT_ID_FOLLOW_BUTTON = "followButton"
private const val LAYOUT_ID_MESSAGE_BUTTON = "messageButton"

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
        BoxWithConstraints {
            // orientation config
            val constraints = if (maxWidth < 600.dp) {
                portraitConstraintSet(margin = 16.dp)
            } else {
                landscapeConstraintSet(margin = 16.dp)
            }

            ConstraintLayout(
                constraintSet = constraints,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.husky),
                    contentDescription = "Husky",
                    modifier = Modifier
                        .layoutId(LAYOUT_ID_IMAGE)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color.Red,
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Siberian Husky",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.layoutId(LAYOUT_ID_NAME)
                )
                Text(
                    text = "Germany",
                    modifier = Modifier.layoutId(LAYOUT_ID_COUNTRY)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .layoutId(LAYOUT_ID_PROFILE_STATS)
                        .fillMaxWidth()
                ) {
                    ProfileStats(count = 150, title = "Followers")
                    ProfileStats(count = 120, title = "Following")
                    ProfileStats(count = 10, title = "Posts")
                }

                Button(
                    onClick = {  },
                    modifier = Modifier.layoutId(LAYOUT_ID_FOLLOW_BUTTON)
                ) {
                    Text(text = "Follow user")
                }
                Button(
                    onClick = {  },
                    modifier = Modifier.layoutId(LAYOUT_ID_MESSAGE_BUTTON)
                ) {
                    Text(text = "Message")
                }
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

// portrait layout
private fun portraitConstraintSet(margin: Dp): ConstraintSet =
    ConstraintSet {
        val image = createRefFor(id = LAYOUT_ID_IMAGE)
        val name = createRefFor(id = LAYOUT_ID_NAME)
        val country = createRefFor(id = LAYOUT_ID_COUNTRY)
        val profileStats = createRefFor(id = LAYOUT_ID_PROFILE_STATS)
        val followButton = createRefFor(id = LAYOUT_ID_FOLLOW_BUTTON)
        val messageButton = createRefFor(id = LAYOUT_ID_MESSAGE_BUTTON)

        val guideline = createGuidelineFromTop(fraction = 0.25F)

        constrain(image) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(name) {
            top.linkTo(image.bottom)
            start.linkTo(image.start)
            end.linkTo(image.end)
        }

        constrain(country) {
            top.linkTo(name.bottom)
            start.linkTo(name.start)
            end.linkTo(name.end)
        }

        constrain(profileStats) {
            top.linkTo(country.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(followButton) {
            top.linkTo(profileStats.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(messageButton.start)
            width = Dimension.wrapContent
        }

        constrain(messageButton) {
            top.linkTo(profileStats.bottom, margin = margin)
            start.linkTo(followButton.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
        }
    }

private fun landscapeConstraintSet(margin: Dp): ConstraintSet =
    ConstraintSet {
        val image = createRefFor(id = LAYOUT_ID_IMAGE)
        val name = createRefFor(id = LAYOUT_ID_NAME)
        val country = createRefFor(id = LAYOUT_ID_COUNTRY)
        val profileStats = createRefFor(id = LAYOUT_ID_PROFILE_STATS)
        val followButton = createRefFor(id = LAYOUT_ID_FOLLOW_BUTTON)
        val messageButton = createRefFor(id = LAYOUT_ID_MESSAGE_BUTTON)

        constrain(image) {
            top.linkTo(parent.top, margin = margin)
            start.linkTo(parent.start, margin = margin)
        }

        constrain(name) {
            top.linkTo(image.bottom, margin = margin)
            start.linkTo(parent.start, margin = margin)
        }

        constrain(country) {
            top.linkTo(name.bottom)
            start.linkTo(parent.start, margin = margin)
        }

        constrain(profileStats) {
            top.linkTo(image.top, margin = margin)
            start.linkTo(image.end, margin = 16.dp)
            end.linkTo(parent.end)
        }

        constrain(followButton) {
            top.linkTo(profileStats.bottom)
            start.linkTo(image.end, margin = 16.dp)
            width = Dimension.wrapContent
        }

        constrain(messageButton) {
            top.linkTo(profileStats.bottom)
            start.linkTo(followButton.end, margin = 16.dp)
            width = Dimension.wrapContent
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

@Preview(
    showBackground = true,
    name = "Profile Page Preview - Landscape",
    showSystemUi = true,
    device = Devices.TABLET
)
@Composable
fun ProfilePagePreviewLandscape() {
    ProfilePage()
}