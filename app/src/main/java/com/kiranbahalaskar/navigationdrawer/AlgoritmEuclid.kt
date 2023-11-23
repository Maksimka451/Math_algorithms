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
import com.example.tchmk_2.Functions.ClEd
import com.example.tchmk_2.Functions.CoolEuclid
import java.util.concurrent.atomic.AtomicInteger

@Composable
fun WorkField() {
    var count1 by rememberSaveable { mutableStateOf("") }
    var count2 by rememberSaveable { mutableStateOf("") }
    var result by rememberSaveable { mutableStateOf(0) }
    var koef1 by rememberSaveable { mutableStateOf(0) }
    var koef2 by rememberSaveable { mutableStateOf(0) }
    var cled: ClEd
    var cledResult by rememberSaveable { mutableStateOf("") }
    var x1: AtomicInteger = AtomicInteger()
    var y1: AtomicInteger = AtomicInteger()

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
            text = "Input b: ",
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight.Light
            ),
            modifier = Modifier.padding(start = 8.dp)
        )

        OutlinedTextField(
            value = count2,
            onValueChange = {newText -> count2 = newText},
            label = { Text(text = "Second parametr") },
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MaterialTheme.colors.primary, unfocusedBorderColor = MaterialTheme.colors.primary, disabledBorderColor = MaterialTheme.colors.primary),
            modifier = Modifier.padding(top = 8.dp, start = 4.dp)
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
            value = cledResult,
            onValueChange = {},
            label = { Text(text = "This is your result!") },
            colors = TextFieldDefaults.outlinedTextFieldColors(focusedBorderColor = MaterialTheme.colors.primary, unfocusedBorderColor = MaterialTheme.colors.primary, disabledBorderColor = MaterialTheme.colors.primary),
            modifier = Modifier.padding(top = 8.dp, start = 9.dp)
        )
    }


    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                cled = CoolEuclid(count1.toInt(), count2.toInt(), x1, y1)
                koef1 = cled.x
                koef2 = cled.y
                result = Compute(num1 = count1.toInt(), num2 = count2.toInt())
                cledResult = result.toString() + " = " + koef1.toString() + "*" + count1 + " + " + koef2 + "*" + count2
            }, modifier = Modifier.padding(top = 50.dp)
        )
        {
            Text("Euclid Algoritm")
        }
    }
}

