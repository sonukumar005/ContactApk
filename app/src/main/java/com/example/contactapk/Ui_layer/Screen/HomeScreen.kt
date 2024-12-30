package com.example.contactapk.Ui_layer.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.contactapk.Ui_layer.ContactAppViewModel

@Composable
fun HomeScreenUI(
    navController: NavHostController,
    viewModel: ContactAppViewModel = hiltViewModel()
) {
    Scaffold() {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(viewModel.state.value.contactList) {
                Card(onClick = {}) {
                    Column() {
                        Text(text = it.name)
                        Text(text = it.phoneNumber)
                        Text(text = it.email)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp ))
            }
        }
    }

}