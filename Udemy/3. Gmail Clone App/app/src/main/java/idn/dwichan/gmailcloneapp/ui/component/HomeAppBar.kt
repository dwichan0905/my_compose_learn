package idn.dwichan.gmailcloneapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import idn.dwichan.gmailcloneapp.R

@Composable
fun HomeAppBar() {
    Box(
        modifier = Modifier
            .padding(16.dp)
    ) {
       ElevatedCard(
           shape = RoundedCornerShape(24.dp),
           elevation = CardDefaults.elevatedCardElevation(6.dp),
           modifier = Modifier
               .requiredHeight(48.dp),
           colors = CardDefaults.cardColors(Color.White)
       ) {
           Row(
               verticalAlignment = Alignment.CenterVertically,
               modifier = Modifier
                   .fillMaxSize()
                   .padding(8.dp)
           ) {
               Icon(
                   painter = rememberVectorPainter(image = Icons.Default.Menu),
                   contentDescription = "Menu",
                   modifier = Modifier
                       .padding(PaddingValues(start = 8.dp, end = 8.dp))
               )
               Text(
                   text = "Search in Inbox",
                   modifier = Modifier
                       .weight(2.0F)
               )
               Image(
                   painter = painterResource(id = R.drawable.user_profile),
                   contentDescription = "User Profile",
                   modifier = Modifier
                       .size(32.dp)
                       .clip(CircleShape)
                       .background(color = Color.Gray)
               )
           }
       }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeAppBarPreview() {
    HomeAppBar()
}