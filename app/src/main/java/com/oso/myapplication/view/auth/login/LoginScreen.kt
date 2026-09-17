package com.oso.myapplication.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oso.myapplication.R

@Preview
@Composable
fun LoginScreen(loginViewModel: LoginViewModel= viewModel()) {

 //   var email: String by remember { mutableStateOf("") }
//    var password: String by remember { mutableStateOf("") }

    val uiState: LoginUiState by loginViewModel.uiState.collectAsState()

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(modifier = Modifier.padding(vertical = 22.dp), text = "Español (España)", color = Color.Gray)
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "logo"
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Usuario, correo electrónico o móvil") },
                shape = RoundedCornerShape(
                    30
                        .dp
                ),
                value =
                    uiState.email,
                onValueChange =
                    { loginViewModel.onEmailChanged(it) })
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(), label = { Text(text = "Contraseña") }, shape = RoundedCornerShape(30.dp),
                value = uiState.password, onValueChange = {
                    loginViewModel.onPasswordChanged(password = it)
                })
            Spacer(modifier = Modifier.height(10.dp))
            Button(modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = {},
                enabled = uiState.isLoginEnabled
                ) {
                Text(modifier = Modifier.padding(vertical = 4.dp), text = "Iniciar sesión")
            }
            TextButton(onClick = {}) { Text(text = "Has olvidado la contraseña?") }
            Spacer(modifier = Modifier.weight(1.3f))
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) { Text(text = "Crear cuenta nueva") }
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta), contentDescription = "meta", tint = Color.Gray
            )
        }

    }
}