package com.oso.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.oso.myapplication.ui.theme.MyApplicationTheme
import com.oso.myapplication.view.auth.register.RegisterScreen
import com.oso.myapplication.view.core.navigation.NavigationWrapper
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                NavigationWrapper()
            }
        }
    }
}