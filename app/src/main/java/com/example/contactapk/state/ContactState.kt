package com.example.contactapk.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.contactapk.Data.table.Contact

data class ContactState(
    val contactList: List<Contact> = emptyList(),
    val id: MutableState<Int?> = mutableStateOf(null),
    val name: MutableState<String> = mutableStateOf(""),
    val phoneNumber: MutableState<String> = mutableStateOf(""),
    val email: MutableState<String> = mutableStateOf(""),
    val dob: MutableState<Long?> = mutableStateOf(null),
    val imageUrl: MutableState<ByteArray?> = mutableStateOf(null)
)
