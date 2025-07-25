package com.example.hospitalapp.ui.theme.screens.register

import android.widget.TextView
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hospitalapp.R
import com.example.hospitalapp.data.AuthViewModel
import com.example.hospitalapp.navigation.ROUTE_LOGIN

@Composable
fun registerScreen(navController: NavController){
    var username by remember { mutableStateOf("") }
    var fullname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var authViewModel: AuthViewModel = viewModel()

    Box(){
        Image(painter = painterResource(id = R.drawable.background),
            contentDescription = "register background",
            contentScale = ContentScale.FillBounds)
    }
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally){

        Text(text = "Register Here!",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()

                .padding(5.dp))
        Spacer(modifier = Modifier.height(1.dp))
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Image Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            contentScale = ContentScale.Fit)

        OutlinedTextField(
            value = username,
            onValueChange = {username=it},
            label = { Text("Enter Username") },
            textStyle = TextStyle(color = Color.White),
            placeholder = { Text("Please Enter Username") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person icon") },
            modifier = Modifier.fillMaxWidth(0.8f))

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = fullname,
            onValueChange = {fullname=it},
            label = { Text("Enter Fullname") },
            textStyle = TextStyle(color = Color.White),
            placeholder = { Text("Please Enter Fullname") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person icon") },
            modifier = Modifier.fillMaxWidth(0.8f))

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = { Text("Enter Email")},
            textStyle = TextStyle(color = Color.White),
            placeholder = {Text("Please enter email")},
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email icon") },
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = password,
            onValueChange = {password=it},
            label = { Text("Enter Password")},
            placeholder = {Text("Please enter password")},
            textStyle = TextStyle(color = Color.White),
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Lock icon") },
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = confirmPassword,
            onValueChange = {confirmPassword=it},
            label = { Text("Confirm Password")},
            textStyle = TextStyle(color = Color.White),
            placeholder = {Text("Please confirm password")},
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Lock icon") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))

        Spacer(modifier = Modifier.height(20.dp))
        val context= LocalContext.current
        Button(onClick = {
            authViewModel.signup(
                username = username,
                fullname = fullname,
                email=email,
                password=password,
                confirmPassword=confirmPassword,
                navController = navController,
                context = context)
        },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            modifier = Modifier.fillMaxWidth(0.8f))
            { Text("Register", color = Color.White) }

        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "If already registered, Login here", color = Color.Red,
            modifier = Modifier.clickable { navController.navigate(ROUTE_LOGIN) }
            )





    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun registerScreenPreview(){
    registerScreen(rememberNavController())
}