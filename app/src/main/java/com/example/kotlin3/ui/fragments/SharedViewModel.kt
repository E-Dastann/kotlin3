package com.example.kotlin3.ui.fragments

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _listState = MutableLiveData<ArrayList<String>>()
    var listState : LiveData<ArrayList<String>>  = _listState

    fun putImage(list : ArrayList<String>){
        _listState.postValue(list)
    }
}