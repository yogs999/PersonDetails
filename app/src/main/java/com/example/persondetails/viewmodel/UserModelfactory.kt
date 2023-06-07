package com.example.persondetails.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.persondetails.repository.UserRepo

class UserModelfactory(private val userRepo: UserRepo): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(userRepo) as T


   }
}