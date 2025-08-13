package com.example.hospitalapp.ui.theme.screens.dashboard

import android.content.Intent
import android.inputmethodservice.Keyboard.Row
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import com.example.hospitalapp.R
import com.example.hospitalapp.data.AuthViewModel
import com.example.hospitalapp.navigation.ROUTE_ADD_PATIENT
import com.example.hospitalapp.navigation.ROUTE_LOGIN
import com.example.hospitalapp.navigation.ROUTE_VIEW_PATIENT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    val selectedItem = remember { mutableStateOf(1) }
    val authViewModel: AuthViewModel = viewModel()
    val context = LocalContext.current
    val showLogoutDialog = remember { mutableStateOf(false) }
    Scaffold(bottomBar = {

        NavigationBar(containerColor = Color.Gray) {
            NavigationBarItem(
                selected = selectedItem.value == 0,
                onClick = {},
                icon = { Icon(Icons.Filled.Share, contentDescription = "share") },
                label = { Text(text = "Share") },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Black

                )
            )

            NavigationBarItem(
                selected = selectedItem.value == 1,
                onClick = {
                    val intent = Intent(Intent.ACTION_DIAL).apply{
                        data = Uri.parse("tel:0715953435")
                    }
                    context.startActivity(intent)
                },
                icon = { Icon(Icons.Filled.Phone, contentDescription = "phone") },
                label = { Text(text = "Phone") },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Black)
            )
            NavigationBarItem(
                selected = selectedItem.value == 2,
                onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:info@emobilis.edu")
                        putExtra(Intent.EXTRA_SUBJECT,"Inquiry")
                        putExtra(Intent.EXTRA_TEXT,"How do i open a bank account")
                    }
                    context.startActivity(intent)
                },
                icon = { Icon(Icons.Filled.Email, contentDescription = "email") },
                label = { Text(text = "Email") },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Black)
            )
        }
    })
    { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Image(
                painter = painterResource(id = R.drawable.bgdash),
                contentDescription = "background image",
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBar(
                title = { Text(text = "Sanchacho Hospital", fontWeight = FontWeight.Bold, color = Color.LightGray) },

                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Person, contentDescription = "Person")
                    }
                    IconButton(onClick = {showLogoutDialog.value = true}) {
                        Icon(Icons.Filled.AccountCircle, contentDescription = "Logout")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Unspecified,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                )

            )
            Spacer(modifier = Modifier.height(10.dp))

            Column (verticalArrangement = Arrangement.Center,
                modifier = Modifier.height(400.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {

                Row(
                    modifier = Modifier.wrapContentWidth(),


                    ) {
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable { navController.navigate(ROUTE_ADD_PATIENT) },
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.cardElevation(50.dp),
                        colors = CardDefaults.cardColors(Color.LightGray),


                        ) {
                        Box(
                            modifier = Modifier
                                .height(100.dp)
                                .padding(12.dp),
                            contentAlignment = Alignment.Center,


                            ) {
                            Column {
                                Icon(
                                    Icons.Default.Person,
                                    contentDescription = "Patients",
                                    modifier = Modifier.size(30.dp)
                                        .align(Alignment.CenterHorizontally),
                                    tint = Color.Black,)
                                Text(
                                    text = "Add Patients",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Default,
                                    fontStyle = FontStyle.Normal,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }

                    }

                    Spacer(modifier = Modifier.width(20.dp))
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .height(100.dp)
                            .clickable { navController.navigate(ROUTE_VIEW_PATIENT) },
                        shape = RoundedCornerShape(20.dp),
                        elevation = CardDefaults.cardElevation(50.dp),
                        colors = CardDefaults.cardColors(Color.LightGray),

                        ) {
                        Box(
                            modifier = Modifier
                                .height(100.dp)
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column {
                                Icon(
                                    Icons.Default.AccountCircle,
                                    contentDescription = "Patients",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(30.dp)
                                        .align(Alignment.CenterHorizontally),
                                )
                                Text(
                                    text = "View Patients",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Default,
                                    fontStyle = FontStyle.Normal,
                                    color = Color.Black,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }
                }
            }

        }
        if(showLogoutDialog.value){
            AlertDialog(
                onDismissRequest = { showLogoutDialog.value = false },
                title = {Text(text = "LogOut")},
                text = { Text("Are you sure you want to logout?")},
                confirmButton = {
                    TextButton(
                        onClick = {
                        showLogoutDialog.value = false
                        authViewModel.logout(context, navController)
                    }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {showLogoutDialog.value = false}
                    ) {
                        Text("No")
                    }
                }
            )
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())
}

