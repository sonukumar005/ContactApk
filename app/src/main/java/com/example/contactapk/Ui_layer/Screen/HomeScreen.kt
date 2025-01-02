package com.example.contactapk.Ui_layer.Screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.contactapk.Data.table.Contact
import com.example.contactapk.Ui_layer.ContactAppViewModel
import com.example.contactapk.Ui_layer.navigation.AddEditScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenUI(
    navController: NavHostController,
    viewModel: ContactAppViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(AddEditScreen)
                }
            ) { Icon(Icons.Filled.Add, contentDescription = null) }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(state.value.contactList) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 9.dp)
                        .combinedClickable(
                            onClick = {
                                // navController.navigate(AddEditScreen)
                            },
                            onLongClick = {
                                viewModel.state.value.name.value = it.name
                                viewModel.state.value.phoneNumber.value = it.phoneNumber
                                viewModel.state.value.email.value = it.email
                                viewModel.state.value.dob.value = it.dob
                                viewModel.state.value.imageUrl.value = it.imageUrl
                                viewModel.state.value.id.value = it.id
                                navController.navigate(AddEditScreen)

                            }
                        )
                ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(9.dp)
                        ) {
                            Text(text = it.name)
                            Text(text = it.phoneNumber)
                            Text(text = it.email)
                        }


                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}