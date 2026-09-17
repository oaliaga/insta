package com.oso.myapplication.view.auth.login

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oso.myapplication.R
import com.oso.myapplication.view.core.components.InstaButton
import com.oso.myapplication.view.core.components.Instatex

@Preview
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {

    val uiState: LoginUiState by loginViewModel.uiState.collectAsState()

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Instatex(
                modifier = Modifier.padding(vertical = 22.dp),
                text = stringResource(R.string.login_screen_header)
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "logo"
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Instatex(text = stringResource(R.string.login_screen_textfield_email)) },
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
                modifier = Modifier.fillMaxWidth(),
                label = { Instatex(text = stringResource(R.string.login_screen_textfield_password), color = MaterialTheme.colorScheme
                    .onBackground) },
                shape = RoundedCornerShape(30.dp),
                value = uiState.password,
                onValueChange = {
                    loginViewModel.onPasswordChanged(password = it)
                })
            Spacer(modifier = Modifier.height(10.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                onClick = {},
                enabled = uiState.isLoginEnabled,
                text = stringResource(R.string.login_screen_button_login)
            )
            TextButton(onClick = {}) { Instatex(text = stringResource(R.string.login_screen_text_forgot_password), color = MaterialTheme.colorScheme.onSurfaceVariant) }
            Spacer(modifier = Modifier.weight(1.3f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(), onClick = {}, border = BorderStroke(
                    1.dp, MaterialTheme
                        .colorScheme.primary
                )
            ) {
                Instatex(
                    text
                    = stringResource(R.string.login_screen_button_register), color = MaterialTheme.colorScheme.primary
                )
            }
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta), contentDescription = stringResource(R.string.login_screen_icon_meta), tint =
                    MaterialTheme.colorScheme
                    .onBackground
            )
        }

    }
}