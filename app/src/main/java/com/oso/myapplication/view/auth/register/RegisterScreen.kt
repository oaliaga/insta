package com.oso.myapplication.view.auth.register


import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oso.myapplication.R
import com.oso.myapplication.view.core.components.InstaButton
import com.oso.myapplication.view.core.components.InstaButtonSecundary
import com.oso.myapplication.view.core.components.InstaTextField
import com.oso.myapplication.view.core.components.Instatex


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = viewModel()){

    val uiState: RegisterUiState by registerViewModel.uiState.collectAsStateWithLifecycle()

    val title:String
    val subtitle: String
    val label:String
    val changeModeTitle:String
    when(uiState.isPhoneMode){
        true->{
            title=stringResource(R.string.register_screen_title_phone)
            subtitle=stringResource(R.string.register_screen_subtitle_phone)
            label=stringResource(R.string.register_screen_textfield_register_phone)
            changeModeTitle=stringResource(R.string.register_screen_button_email)
        }
        false->{
            title=stringResource(R.string.register_screen_title_email)
            subtitle=stringResource(R.string.register_screen_subtitle_email)
            label=stringResource(R.string.register_screen_textfield_register_email)
            changeModeTitle=stringResource(R.string.register_screen_button_phone)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
                title = {},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            )
        }
    ){paddingValues->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            AnimatedContent(title) { animatedTitle->
                Instatex(
                    text= animatedTitle,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(Modifier.height(4.dp))
            Instatex(
                text= subtitle,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(16.dp))

            InstaTextField(
                modifier = Modifier.fillMaxWidth(),
                value=uiState.value,
                onValueChange = {registerViewModel.onRegisterChanged(it)},
                label = label
            )
            Spacer(Modifier.height(4.dp))
            Instatex(
                text= stringResource(R.string.register_screen_body),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(12.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                enabled = uiState.isRegisterEnabled,
                text = stringResource(R.string.register_screen_button_next)
            )
            Spacer(Modifier.height(4.dp))
            InstaButtonSecundary(
                modifier = Modifier.fillMaxWidth(),
                onClick = {registerViewModel.onChangeMode()},
                title = changeModeTitle,
                titleColor = MaterialTheme.colorScheme.primary,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
            )
            Spacer(Modifier.weight(1f))
            Instatex(
                modifier = Modifier.padding(4.dp) ,
                text=stringResource(R.string.register_screen_text_find_my_account),
                color=MaterialTheme.colorScheme.primary
            )
        }
    }

}