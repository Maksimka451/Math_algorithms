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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun EylerAlgoritm() {
    var count1 by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Input n: ",
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
                value = result.toString(),
                onValueChange = {},
                label = { Text(text = "This is your result!") },
                colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MaterialTheme.colors.primary, unfocusedBorderColor = MaterialTheme.colors.primary, disabledBorderColor = MaterialTheme.colors.primary),
                modifier = Modifier.padding(top = 8.dp, start = 9.dp)
            )
        }

        Button(
            onClick = {
                      result = Eyler(count1.toInt())
            }, modifier = Modifier.padding(top = 50.dp)
        )
        {
            Text("Eyler Function")
        }
    }
}

