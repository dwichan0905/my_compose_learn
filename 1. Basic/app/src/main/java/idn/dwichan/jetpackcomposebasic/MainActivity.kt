package idn.dwichan.jetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import idn.dwichan.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    // states
    val expandedState = remember { mutableStateOf(false) } // false is default value
    val expandedHeight = if (expandedState.value) 48.0.dp else 0.0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1F)
                    .padding(bottom = expandedHeight)
            ) {
                Text(text = "Hello, ")
                Text(text = "$name!")
            }

            OutlinedButton(
                colors = buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.onBackground
                ),
                onClick = { expandedState.value = !expandedState.value }
            ) {
                Text(if (expandedState.value) "Show Less" else "Show More")
            }
        }
    }
}

@Composable
private fun MyApp(names: List<String> = listOf("Esmeralda", "Hylos")) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Column {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }
}

@Preview(showBackground = true, name = "Text Preview", widthDp = 320)
@Composable
fun DefaultPreview() {
    JetpackComposeBasicTheme {
        MyApp()
    }
}