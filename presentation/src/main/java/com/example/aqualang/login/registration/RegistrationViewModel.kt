package com.example.aqualang.login.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.User
import com.example.domain.UserInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel(private val userInteractor: UserInteractor) : ViewModel() {

    private val _navigateToLogin = MutableLiveData<Boolean>()
    val navigateToLogin: LiveData<Boolean>
        get() = _navigateToLogin

    private val _showToast = MutableLiveData<Boolean>()
    val showToast: LiveData<Boolean>
        get() = _showToast

    var toastText = ""

    val user = MutableLiveData<User>()
    var password = MutableLiveData<String>()

    private val uiScope = CoroutineScope(Dispatchers.Main)

    fun saveButtonClicked() {
        uiScope.launch {
            val respond = userInteractor.registerUser(user.value!!, password.value!!)
            toastText = respond.description
            _showToast.value = true

            if(respond.status)
                _navigateToLogin.value = true
        }
    }

    fun doneNavigationToLogin() {
        _navigateToLogin.value = null
    }

    fun doneShowingToast(){
        _showToast.value = null
    }
}