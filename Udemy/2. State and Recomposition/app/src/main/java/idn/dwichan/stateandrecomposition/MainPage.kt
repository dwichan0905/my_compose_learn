package idn.dwichan.stateandrecomposition

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import idn.dwichan.stateandrecomposition.ui.theme.StateAndRecompositionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Hello")
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = {
                Text(text = "Text to display")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { }
        ) {
            Text(text = "Display")
        }
    }
}

@Preview(
    showBackground = true,
    name = "Main App Preview",
    device = Devices.NEXUS_5,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    StateAndRecompositionTheme {
        MainPage()
    }
}