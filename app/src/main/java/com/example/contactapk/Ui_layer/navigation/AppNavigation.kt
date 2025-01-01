package com.example.contactapk.Ui_layer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ApproachLayoutModifierNode
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.contactapk.Ui_layer.Screen.AddEditScreenUI
import com.example.contactapk.Ui_layer.Screen.HomeScreenUI
import com.example.contactapk.Ui_layer.navigation.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreen){
        composable<HomeScreen>{
            HomeScreenUI(navController)
        }
        composable<AddEditScreen>{
            AddEditScreenUI(navController)

        }
    }
}