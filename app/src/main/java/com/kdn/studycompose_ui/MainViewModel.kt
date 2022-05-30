package com.kdn.studycompose_ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val textFieldState = MutableLiveData("")

    fun onTextChange(newText : String) {
        textFieldState.value = newText
    }
}