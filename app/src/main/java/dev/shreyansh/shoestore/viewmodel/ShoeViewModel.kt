package dev.shreyansh.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    private val _getStarted = MutableLiveData<Boolean>()
    val getStarted : LiveData<Boolean>
        get() = _getStarted

    private val _login = MutableLiveData<Boolean>()
    val login : LiveData<Boolean>
        get() = _login

    private val _introOnboarding = MutableLiveData<Boolean>()
    val introOnboarding : LiveData<Boolean>
        get() = _introOnboarding

    init {
        _getStarted.value = false
        _login.value = false
        _introOnboarding.value = false

    }

    fun onGetStarted(){
        _getStarted.value = true
    }

    fun onGetStartedComplete(){
        _getStarted.value = false
    }

    fun onLogin(){
        _login.value = true
    }

    fun onLoginComplete(){
        _login.value = false
    }

    fun onIntroOnboarding(){
        _introOnboarding.value = true
    }

    fun onIntroOnboardingComplete(){
        _introOnboarding.value = false
    }
}