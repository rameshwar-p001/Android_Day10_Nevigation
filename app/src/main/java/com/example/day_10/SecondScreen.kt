////It is a simple navigation of 3 screen

//package com.example.day_10
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun SecondScreen(navigateToFirst: () -> Unit, navigateToThird: () -> Unit) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Hello from Second Screen", fontSize = 24.sp)
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = { navigateToFirst() }) {
//            Text("Go to First Screen")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = { navigateToThird() }) {
//            Text("Go to Third Screen")
//        }
//    }
//}
//


//=================================
//It for screen 1 and Screen 2
//package com.example.day_10
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun SecondScreen( name: String,navigateToFirst: (String) -> Unit) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Hello from Second Screen", fontSize = 24.sp)
//        Text("WellCome $name", fontSize = 24.sp)
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                navigateToFirst(name)
//            })
//        {
//            Text("Go to First Screen")
//        }
//
//    }
//}



//------------------------------------
//Now we create a 3 screen navigation
package com.example.day_10

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name: String, onNext: (String) -> Unit) {
    var age by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello $name, enter your Age", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onNext(age) }) {
            Text("Next")
        }
    }
}
