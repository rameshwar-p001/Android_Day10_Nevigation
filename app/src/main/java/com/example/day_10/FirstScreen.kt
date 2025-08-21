////It is a simple navigation of 3 screen

//package com.example.day_10
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun FirstScreen(navigateToSecond: () -> Unit) {
//    val name = remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Hello from First Screen", fontSize = 24.sp)
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = name.value,
//            onValueChange = { name.value = it }
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = { navigateToSecond() }) {
//            Text("Go to Second Screen")
//        }
//    }
//}


//=============================================================
//It is for screen 1 nad 2 only
//package com.example.day_10
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun FirstScreen(navigateToSecond: (String) -> Unit) {
//    val name = remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Hello from First Screen", fontSize = 24.sp)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = name.value,
//            onValueChange = { name.value = it }
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick =
//            {
//                navigateToSecond(name.value)
//            }) {
//            Text("Go to Second Screen")
//        }
//    }
//}

//-----------------------------------------------
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
fun FirstScreen(onNext: (String) -> Unit) {
    var name by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Enter your Name", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onNext(name) }) {
            Text(" Next")
        }
    }
}
