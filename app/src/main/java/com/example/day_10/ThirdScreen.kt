////It is a simple navigation of 3 screen

//package com.example.day_10
//
//import android.R.attr.name
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//
//@Composable
//fun ThirdScreen(navigateToFirstScreen: () -> Unit) {
//    val name = remember { mutableStateOf(" ") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Hello from Third Screen", fontSize = 24.sp)
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = name.value,
//            onValueChange = { name.value = it }
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = { navigateToFirstScreen() }) {
//            Text("Go to First Screen")
//        }
//    }
//}


//--------------------------------------------------
//Now we create a 3 screen navigation
package com.example.day_10

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThirdScreen(name: String, age: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🎉 Welcome!", fontSize = 28.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Your Name: $name", fontSize = 22.sp)
        Text("Your Age: $age", fontSize = 22.sp)
    }
}
