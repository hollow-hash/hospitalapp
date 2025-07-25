package com.example.hospitalapp.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hospitalapp.R
import com.example.hospitalapp.data.AuthViewModel
import com.example.hospitalapp.navigation.ROUTE_REGISTER

@Composable
fun loginScreen(navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var authViewModel: AuthViewModel = viewModel()
    Box(){
        Image(
            painter = painterResource(id = R.drawable.log),
            contentDescription = "login bglog",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxHeight())
    }
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Text(text = "Login Here!",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Black)
                .padding(5.dp))
        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Image Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            contentScale = ContentScale.Fit
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = { Text("Enter Email")},
            placeholder = {Text("Please enter email")},
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email icon") },
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = password,
            onValueChange = {password=it},
            label = { Text("Enter Password")},
            placeholder = {Text("Please enter password")},
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Lock icon") },
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(20.dp))
        val context= LocalContext.current
        Button(onClick = {
            authViewModel.login(
                email=email,
                password=password,
                navController=navController,
                context = context)},
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            modifier = Modifier
                .fillMaxWidth(0.8f))
            { Text("Login", color = Color.White) }
            Text("if not registered, Register here",
                modifier = Modifier.clickable { navController.navigate(ROUTE_REGISTER) })



    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loginScreenPreview(){
    loginScreen(rememberNavController())
}