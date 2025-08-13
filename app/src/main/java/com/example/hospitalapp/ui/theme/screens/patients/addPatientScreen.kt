package com.example.hospitalapp.ui.theme.screens.patients

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.hospitalapp.R
import com.example.hospitalapp.data.PatientViewModel
import com.example.hospitalapp.navigation.ROUTE_DASHBOARD

@Composable
fun AddPatientScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var nationality by remember { mutableStateOf("") }
    var phonenumber by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var diagnosis by remember { mutableStateOf("") }
    val imageUri = rememberSaveable() { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
        uri: Uri? ->uri?.let { imageUri.value=it }
        }
    val patientViewModel:PatientViewModel = viewModel()
    val context= LocalContext.current

    Box(){
        Image(painter = painterResource(id = R.drawable.btt),
            contentDescription = "register background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxHeight())
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ) {

        Text(
            text = "ADD NEW PATIENT ",
            fontSize = 25.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            color = Color.Red,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        Card (
            shape = CircleShape,
            modifier = Modifier.padding(10.dp).size(200.dp)){
                AsyncImage(
                    model = imageUri.value ?: R.drawable.ic_persons,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(200.dp).clickable{ launcher.launch("image/*")})


            }
        Text(text = "Upload picture here", fontSize = 17.sp, color = Color.Red)
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter Patient's Name") },
            textStyle = TextStyle(color = Color.White),
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Person icon") },

            placeholder = { Text("Please Enter Patient Name") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Enter Patient's Gender") },
            textStyle = TextStyle(color = Color.White),
            placeholder = { Text("Please Enter Patient Gender") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        OutlinedTextField(
            value = nationality,
            onValueChange = { nationality = it },
            label = { Text("Enter Patient's Nationality") },
            textStyle = TextStyle(color = Color.White),
            placeholder = { Text("Please Enter Patient's Nationality") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        OutlinedTextField(
            value = phonenumber,
            onValueChange = { phonenumber = it },
            label = { Text("Enter Patient's Phone /number") },
            textStyle = TextStyle(color = Color.White),
            placeholder = { Text("Please Enter Patient's Phone Number") },
            modifier = Modifier.fillMaxWidth(0.8f))

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Enter Patient's Age") },
            textStyle = TextStyle(color = Color.White),
            placeholder = { Text("Please Enter Patient's Age") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        OutlinedTextField(
            value = diagnosis,
            onValueChange = { diagnosis = it },
            label = { Text("Diagnosis") },
            textStyle = TextStyle(color = Color.White),
            placeholder = { Text("Diagnosis") },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(150.dp),
            singleLine = false
        )
        Row( modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Button(onClick = {
                navController.navigate(ROUTE_DASHBOARD)

                 },
                colors = ButtonDefaults.buttonColors(Color.DarkGray))
            { Text(text = "GO BACK",
                color = Color.White)}

            Button(onClick = {
                patientViewModel.uploadPatient(imageUri.value,
                    name,
                    gender,
                    nationality,
                    phonenumber,
                    age,
                    diagnosis,
                    navController,
                    context)
            },
                colors = ButtonDefaults.buttonColors(Color.Gray))
            { Text(text = "SAVE PATIENT",
                color = Color.Black)}
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddPatientScreenPreview(){
    AddPatientScreen(rememberNavController())
}