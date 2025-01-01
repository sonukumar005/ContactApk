package com.example.contactapk.Ui_layer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactapk.Data.table.Contact
import com.example.contactapk.repo.Repo
import com.example.contactapk.state.ContactState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ContactAppViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {
    val contactList =
        repo.getAllContacts().stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

   private val _state = MutableStateFlow(ContactState())

    val state = combine(contactList, _state) { contactList, state ->
        state.copy(
            contactList = contactList
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactState())


    fun upsertContact() {
        viewModelScope.launch {
            repo.upsertContact(
                Contact(
                    name = state.value.name.value,
                    phoneNumber = state.value.phoneNumber.value,
                    email = state.value.email.value
                )
            )
        }
    }


}