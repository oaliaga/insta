package com.oso.myapplication.view.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp


@Composable
fun InstaButtonSecundary(
    modifier: Modifier = Modifier,
    onClick:()->Unit,
    title:String,
    border: BorderStroke= BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
    titleColor: Color=MaterialTheme.colorScheme.primary

){
    OutlinedButton (
        modifier = modifier,
        border = border,
        onClick = {onClick()},
    ) {
        Instatex(
            text = title,
            color = titleColor
        )
    }
}