package com.example.hospitalapp.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hospitalapp.R

@Composable
fun DashboardScreen(navController: NavController){
    Box(){
        Image(painter = painterResource(id = R.drawable.bgdash),
            contentDescription = "register background",
            contentScale = ContentScale.FillBounds)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally){


        Text(text = "Dashboard",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp))

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())
}
