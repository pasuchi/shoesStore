package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel :ViewModel(){
    private val _shoesData = MutableLiveData<MutableList<Shoe?>>()
    val shoesData: LiveData<MutableList<Shoe?>>
        get() = _shoesData


    fun insertShoesData(shoes:Shoe?){
        if (_shoesData.value.isNullOrEmpty()){
            _shoesData.value = mutableListOf()
        }
        _shoesData.value?.add(shoes)
    }

}