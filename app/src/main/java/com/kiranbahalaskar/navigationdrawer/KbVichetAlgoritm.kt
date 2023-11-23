package com.example.tchmk_2

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tchmk_2.Functions.vichetKb
import com.example.tchmk_2.Functions.vichetKv
import java.util.*

@Composable
fun KbVichetAlgoritm() {
    var count1 by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Input a: ",
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            OutlinedTextField(
                value = count1,
                onValueChange = {newText -> count1 = newText},
                label = { Text(text = "First parametr") },
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MaterialTheme.colors.primary, unfocusedBorderColor = MaterialTheme.colors.primary, disabledBorderColor = MaterialTheme.colors.primary),
                modifier = Modifier
                    .padding(start = 4.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Result: ",
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Light
                ),
                modifier = Modifier.padding(start = 8.dp)
            )

            OutlinedTextField(
                value = result,
                onValueChange = {},
                label = { Text(text = "This is your result!") },
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MaterialTheme.colors.primary, unfocusedBorderColor = MaterialTheme.colors.primary, disabledBorderColor = MaterialTheme.colors.primary),
                modifier = Modifier.padding(top = 8.dp, start = 14.dp)
            )
        }

        Button(
            onClick = {
                result = vichetKb(count1.toInt()).toString()
            }, modifier = Modifier.padding(top = 50.dp)
        )
        {
            Text("Кубический вычет")
        }

    }
}