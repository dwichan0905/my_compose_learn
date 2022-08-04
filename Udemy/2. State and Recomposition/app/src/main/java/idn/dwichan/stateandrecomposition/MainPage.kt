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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import idn.dwichan.stateandrecomposition.ui.theme.StateAndRecompositionTheme

/**
 * Catatan:
 * [var name = ""] -> nggak punya state, dia hanya variabel biasa yang nggak bisa muncul ke UI
 * [var name by remember { ... }] -> ada state, tapi nggak bertahan klo ada perubahan konfigurasi (orientasi, dark mode, dkk)
 * [var name by rememberSaveable { ... }] -> ada state, mampu bertahan saat ada perubahan konfigurasi
 *
 * Recomposition: Elemen compose akan dijalankan ulang untuk meng-update komposisi ketika data berubah
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    var name = ""
    var nameWithState by rememberSaveable {
        mutableStateOf("")
    } // biar muncul ke UI, setiap variabel harus punya state... ini yang bisa dipake buat "output data" dari suatu komponen
    var nameValueInField by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Hello $name (no state)")
        Text(text = "Hello $nameValueInField (remember (stateless))")
        Text(text = "Hello $nameWithState (rememberSaveable (stateful))")
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = nameValueInField, // default value
            onValueChange = {
                nameValueInField = it
            },
            label = {
                Text(text = "Text to display")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                name = nameValueInField
                nameWithState = nameValueInField
            }
        ) {
            Text(text = "Display")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Display the name and try to change the system configuration e.g. dark mode or orientation to see the differences")
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