package com.example.myapplication.screens.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.database.Topic

class FavouritesViewModel(val model: FavouritesModel) {
    private var _items = MutableLiveData(mutableListOf<Topic>())
    val items: LiveData<MutableList<Topic>> = _items

    init {
        getItems()
    }

    private fun getItems() {
        _items.value = model.getLikedItems()
    }
}