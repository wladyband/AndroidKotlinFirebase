package com.wladimirbr.backbakerourdream.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import com.wladimirbr.backbakerourdream.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wladimirbr.backbakerourdream.presentation.components.DefaultTextField
import com.wladimirbr.backbakerourdream.presentation.screens.auth.login.components.DefaultButton
import com.wladimirbr.backbakerourdream.presentation.screens.auth.register.RegisterModel
import com.wladimirbr.backbakerourdream.presentation.ui.theme.Brown300

@Composable
fun RegisterContent(paddingValues: PaddingValues, vm: RegisterModel = hiltViewModel()) {

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
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(0.6f, 0.6f, 0.6f, 1f)
            })
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.cheese_and_bread),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,

                    ),
                backgroundColor = Color.White.copy(alpha = 0.6f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(30.dp)
                        .verticalScroll(
                            rememberScrollState()
                        )
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 20.dp),
                        text = "Registrar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black

                    )
                    DefaultTextField(
                        Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChange = { text -> vm.onNameInput(text) },
                        label = "Apelido",
                        icon = Icons.Outlined.Person,
                        color = Brown300,
                        keyboardType = KeyboardType.Text
                    )
                    DefaultTextField(
                        Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = { text -> vm.onEmailInput(text) },
                        label = "Email",
                        icon = Icons.Outlined.Email,
                        color = Brown300,
                        keyboardType = KeyboardType.Email
                    )
                    DefaultTextField(
                        Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = { text -> vm.onPasswordInput(text) },
                        label = "Senha",
                        icon = Icons.Outlined.Lock,
                        color = Brown300,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )
                    DefaultTextField(
                        Modifier.fillMaxWidth(),
                        value = state.confirmationPassword,
                        onValueChange = { text -> vm.onConfirmationPassword(text) },
                        label = "Confirma Senha",
                        icon = Icons.Default.Lock,
                        color = Brown300,
                        keyboardType = KeyboardType.Password,
                        hideText = false
                    )
                    DefaultButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        text = "CONFIRMAR",
                        colorText = Color.White,
                        onClick = {
                            vm.validateForm()
                        },
                        colorButton = Brown300,
                    )
                }
            }
        }
    }


}