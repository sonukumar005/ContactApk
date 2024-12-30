package com.example.contactapk.Ui_layer.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.contactapk.Ui_layer.ContactAppViewModel
import com.example.contactapk.Ui_layer.navigation.HomeScreen


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AddEditScreenUI(navController: NavHostController, viewModel: ContactAppViewModel = hiltViewModel()) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = viewModel.state.value.name.value, onValueChange = {
            viewModel.state.value.name.value = it
        }, placeholder = {Text(text = "Name")})
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = viewModel.state.value.phoneNumber.value, onValueChange = {
            viewModel.state.value.phoneNumber.value = it
        }, placeholder = {Text(text = "Phone Number")})
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = viewModel.state.value.email.value, onValueChange = {
            viewModel.state.value.email.value = it
        },placeholder = {Text(text = "Email")})
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {viewModel.upsertContact()
        navController.navigateUp()}) {
            Text(text = "Save Contact")
        }
        }
    }
