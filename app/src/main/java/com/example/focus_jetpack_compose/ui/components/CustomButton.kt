package com.example.focus_jetpack_compose.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.focus_jetpack_compose.util.Direction

@Composable
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