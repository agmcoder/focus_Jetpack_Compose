package com.example.focus_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import com.example.focus_jetpack_compose.ui.theme.Focus_Jetpack_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Focus_Jetpack_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    LazyColumn(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        item {
                            CustomOutlinedTextField("Field 1")
                        }
                        item {
                            CustomOutlinedTextField("Field 2")
                        }
                        item {
                            CustomButton(Direction.UP)
                            CustomButton(Direction.DOWN)
                        }
                    }


                }
            }
        }
    }
}

@Composable
fun CustomOutlinedTextField(title: String){
    val textFieldValue = rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        placeholder = {Text(text = title)},
        label = {Text(text = title)},
        modifier = Modifier.padding(vertical = 20.dp),
        value = textFieldValue.value,
        onValueChange = {
            textFieldValue.value = it
        })
}
@androidx.compose.runtime.Composable
fun CustomButton(direction: Direction) {
    val focusManager = LocalFocusManager.current
    Button(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .padding(vertical = 10.dp),
        onClick = {
            if (direction == Direction.UP) {
                focusManager.moveFocus(FocusDirection.Up)

            } else {
                focusManager.moveFocus(FocusDirection.Down)

            }

        }


    ) {
        if (direction == Direction.UP)
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowUp,
                "",
                modifier = Modifier.fillMaxSize()
            )
        else
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                "",
                modifier = Modifier.fillMaxSize()

            )
    }

}

enum class Direction {
    UP,
    DOWN
}