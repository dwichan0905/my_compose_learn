package idn.dwichan.dogprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfilePage() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.husky),
            contentDescription = "Husky"
        )
        Text(
            text = "Siberian Husky"
        )
        Text(
            text = "Germany"
        )
    }
}

@Preview(
    showBackground = true,
    name = "Profile Page Preview"
)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}