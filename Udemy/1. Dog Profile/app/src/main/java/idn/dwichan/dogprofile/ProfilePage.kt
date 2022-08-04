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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
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
                    ),
                contentScale = ContentScale.Crop
            )
            Text(text = "Siberian Husky")
            Text(text = "Germany")
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ProfileStats(count = 150, title = "Followers")
                ProfileStats(count = 120, title = "Following")
                ProfileStats(count = 10, title = "Posts")
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Button(onClick = {  }) {
                    Text(text = "Follow user")
                }
                Button(onClick = {  }) {
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

@Preview(
    showBackground = true,
    name = "Profile Page Preview",
    showSystemUi = true
)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}