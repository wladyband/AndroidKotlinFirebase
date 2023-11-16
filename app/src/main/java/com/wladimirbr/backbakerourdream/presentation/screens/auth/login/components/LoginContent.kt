package com.wladimirbr.backbakerourdream.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.CircularProgressIndicator

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.wladimirbr.backbakerourdream.R
import com.wladimirbr.backbakerourdream.domain.model.Response

import com.wladimirbr.backbakerourdream.presentation.components.DefaultTextField
import com.wladimirbr.backbakerourdream.presentation.navigation.screen.AppScreen
import com.wladimirbr.backbakerourdream.presentation.screens.auth.login.LoginViewModel
import com.wladimirbr.backbakerourdream.presentation.ui.theme.Brown300


@Composable
fun LoginContent(
    paddingValues: PaddingValues,
    navHostController: NavHostController,
    vm: LoginViewModel = hiltViewModel()
) {


    val loginFlow = vm.loginFlow.collectAsState()
    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessager) {
        if (vm.errorMessager != "") {
            Toast.makeText(context, vm.errorMessager, Toast.LENGTH_LONG).show()
        }
    }
    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.bakery),
            contentDescription = "imagem de fundo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(0.5f, 0.5f, 0.5f, 1f)
            })
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),

                painter = painterResource(id = R.drawable.cheese_and_bread),
                contentDescription = "Logo"
            )
            Text(
                modifier = Modifier.padding(top = 7.dp),
                text = "PÃO FRESQUINHO",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),

                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp
                ),
                backgroundColor = Color.White.copy(alpha = 0.6f)
            ) {

                (Column(
                    modifier = Modifier
                        .padding(30.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 20.dp),
                        text = "Acessar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    DefaultTextField(
                        Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = { text -> vm.onEmailInput(text) },
                        label = "E-mail",
                        icon = Icons.Default.Email,
                        color = Brown300,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = { text -> vm.onPasswordnput(text) },

                        label = "Senha",
                        icon = Icons.Default.Lock,
                        color = Brown300,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )

                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        text = "LOGIN",
                        colorText = Color.White,
                        onClick = {
                            vm.loginUserAndValidateForm()
                        },
                        colorButton = Brown300,
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Ainda não tem conta?")
                        Text(
                            modifier = Modifier.clickable {
                                navHostController.navigate(route = AppScreen.Register.route)
                            },
                            text = " Criar uma conta",
                            color = Brown300,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    loginFlow.value.let {
                        when (it) {
                            Response.Loading -> {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.fillMaxWidth()
                                )
                                {
                                    CircularProgressIndicator()
                                }
                            }

                            is Response.Success -> {
                                LaunchedEffect(Unit) {
                                    navHostController.navigate(route = AppScreen.Profile.route)
                                }
                            }

                            is Response.Failure -> {
                                val errorMessage = it.exception?.message
                                var errorToShow = if (errorMessage.isNullOrBlank()) {
                                    "Erro desconhecido"
                                } else {
                                    "Email ou senha incorreto"
                                }
                                Toast.makeText(LocalContext.current, errorToShow, Toast.LENGTH_LONG)
                                    .show()
                                errorToShow = ""
                            }

                            else -> {

                            }
                        }
                    }

                })
            }
        }
    }


}