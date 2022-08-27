package dev.shreyansh.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeViewModel : ViewModel() {

    private val _getStarted = MutableLiveData<Boolean>()
    val getStarted : LiveData<Boolean>
        get() = _getStarted

    init {
        _getStarted.value = false
    }

    fun onGetStarted(){
        _getStarted.value = true
    }

    fun onGetStartedComplete(){
        _getStarted.value = false
    }
}