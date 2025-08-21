
////It is a simple navigation of 3 screen
//package com.example.day_10
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.ui.Modifier
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.day_10.ui.theme.Day_10Theme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Day_10Theme {
//                Scaffold { innerPadding ->
//                    Surface(modifier = Modifier.padding(innerPadding)) {
//                        MyApp()
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun MyApp() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "first") {
//
//        composable("first") {
//            FirstScreen(
//                navigateToSecond = { navController.navigate("second") }
//            )
//        }
//
//        composable("second") {
//            SecondScreen(
//                navigateToFirst = { navController.navigate("first") },
//                navigateToThird = { navController.navigate("third") }
//            )
//        }
//
//        composable("third") {
//            ThirdScreen(
//                navigateToFirstScreen = { navController.navigate("first") }
//            )
//        }
//    }
//}
////================================================
////it is for screen 1 and 2

//package com.example.day_10
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.key
//import androidx.compose.ui.Modifier
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.day_10.ui.theme.Day_10Theme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            Day_10Theme {
//                Scaffold { innerPadding ->
//                    Surface(modifier = Modifier.padding(innerPadding)) {
//                        MyApp()
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun MyApp() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "first") {
//
//        composable("first") {
//            FirstScreen { name ->
//                navController.navigate("second/$name")
//            }
//
//        }
//
//        composable("second/{name}") {
//            val name = it.arguments?.getString("name") ?: "no name "
//            SecondScreen(name) {
//                navController.navigate("first");
////                navController.navigate("third")
//            }
//        }
//
//
//    }
//}



//Now we create a 3 screen navigation
package com.example.day_10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.day_10.ui.theme.Day_10Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Day_10Theme {
                Scaffold { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        MyApp()
                    }
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "first") {

        // Screen 1 -> Name input
        composable("first") {
            FirstScreen { name ->
                navController.navigate("second/$name")
            }
        }

        // Screen 2 -> Age input
        composable(
            route = "second/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            SecondScreen(name) { age ->
                navController.navigate("third/$name/$age")
            }
        }

        // Screen 3 -> Show name + age
        composable(
            route = "third/{name}/{age}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("age") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val age = backStackEntry.arguments?.getString("age") ?: ""
            ThirdScreen(name, age)

        }
    }
}
