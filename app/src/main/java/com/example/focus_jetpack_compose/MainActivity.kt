package com.example.focus_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.focus_jetpack_compose.ui.components.CustomButton
import com.example.focus_jetpack_compose.ui.components.CustomOutlinedTextField
import com.example.focus_jetpack_compose.ui.theme.Focus_Jetpack_ComposeTheme
import com.example.focus_jetpack_compose.util.Direction
import com.example.focus_jetpack_compose.util.Position

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
                            CustomOutlinedTextField("Field 1", Position.FIRST )
                        }
                        item {
                            CustomOutlinedTextField("Field 2",Position.SECOND)
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




