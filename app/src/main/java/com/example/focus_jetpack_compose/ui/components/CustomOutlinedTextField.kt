package com.example.focus_jetpack_compose.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.focus_jetpack_compose.util.Position

@Composable
fun CustomOutlinedTextField(title : String, position:Position) {
	val focusManager = LocalFocusManager.current
	val textFieldValue = rememberSaveable { mutableStateOf("") }

		OutlinedTextField(
			placeholder = { Text(text = title) },
			singleLine = true,
			label = { Text(text = title) },
			modifier = Modifier.padding(vertical = 20.dp),
			value = textFieldValue.value,
			onValueChange = {
				textFieldValue.value = it
			}, keyboardOptions =if (position==Position.FIRST){
			KeyboardOptions(
				imeAction = ImeAction.Next,
				keyboardType = KeyboardType.Text)
			}else{KeyboardOptions(
				imeAction = ImeAction.Done,
				keyboardType = KeyboardType.Text
			)},
			keyboardActions = if (position==Position.FIRST){KeyboardActions(
				onNext = { focusManager.moveFocus(FocusDirection.Down) }

			)}else{
				KeyboardActions(
					onDone = { focusManager.clearFocus() }

				)
			}
		)



}

