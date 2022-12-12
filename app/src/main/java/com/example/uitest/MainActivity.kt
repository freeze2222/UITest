package com.example.uitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.example.uitest.ui.theme.UITestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UITestTheme {
                MainUi()
            }
        }
    }
}

@Composable
fun MainUi() {
    var text by remember {
        mutableStateOf("")
    }
    var result by remember {
        mutableStateOf("")
    }
    Column {
        TextField(value = text, onValueChange = {
            text = it
        }, modifier = Modifier.semantics {
            contentDescription = "my_input"
        })
        Button(onClick = {
            if (text.isNotEmpty()) {
                result = "hi $text"
            } else {
                result = "No one is here"
            }
        }, modifier = Modifier.semantics {
            contentDescription = "my_button"
        }) {
            Text("Say hi!")
        }
        Text(text = result, modifier = Modifier.semantics {contentDescription = "my_result"})
    }
}