package com.example.focus_jetpack_compose.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomOutlinedTextField(title: String){
	val textFieldValue = rememberSaveable { mutableStateOf("") }
	OutlinedTextField(
		placeholder = { Text(text = title) },
		label = { Text(text = title) },
		modifier = Modifier.padding(vertical = 20.dp),
		value = textFieldValue.value,
		onValueChange = {
			textFieldValue.value = it
		})
}