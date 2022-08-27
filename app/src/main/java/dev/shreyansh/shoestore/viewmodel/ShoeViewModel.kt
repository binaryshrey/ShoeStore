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

    private val _outroOnboarding = MutableLiveData<Boolean>()
    val outroOnboarding : LiveData<Boolean>
        get() = _outroOnboarding

    init {
        _getStarted.value = false
        _login.value = false
        _introOnboarding.value = false
        _outroOnboarding.value = false

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
    fun onOutroOnboarding(){
        _outroOnboarding.value = true
    }

    fun onOutroOnboardingComplete(){
        _outroOnboarding.value = false
    }
}