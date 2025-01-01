package com.example.contactapk.Ui_layer.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
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
import java.nio.file.WatchEvent


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AddEditScreenUI(
    navController: NavHostController,
    viewModel: ContactAppViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = viewModel.state.value.name.value,
            onValueChange = {
                viewModel.state.value.name.value = it
            },
            placeholder = { Text(text = "Name") },
            label = { Text(text = "Name") },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = viewModel.state.value.phoneNumber.value,
            onValueChange = {
                viewModel.state.value.phoneNumber.value = it
            },
            placeholder = { Text(text = "Phone Number") },
            label = { Text(text = "Phone Number") },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = viewModel.state.value.email.value,
            onValueChange = {
                viewModel.state.value.email.value = it
            },
            placeholder = { Text(text = "Email") },
            label = { Text(text = "Email") },
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            viewModel.upsertContact()
            navController.navigateUp()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
           elevation = ButtonDefaults.elevatedButtonElevation(
               defaultElevation = 10.dp,
               pressedElevation = 20.dp
           )
            ) {
            Text(text = "Save Contact")
        }
    }
}
