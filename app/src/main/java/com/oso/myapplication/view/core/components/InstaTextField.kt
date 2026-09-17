package com.oso.myapplication.view.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.oso.myapplication.R

@Composable
fun InstaTextField (
    value: String,
    label:String = "",
    onValueChange:(String)->Unit,
    modifier: Modifier = Modifier,
    shape: Shape= MaterialTheme.shapes.large
    ){
    OutlinedTextField(
        modifier = modifier,
        label = { Instatex(text = label) },
        shape = shape,
        value = value,
        onValueChange = {onValueChange(it)}
    )
}