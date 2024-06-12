package com.example.myapplication.screens.favourites

import android.content.Context
import com.example.myapplication.database.AppDataBase
import com.example.myapplication.database.Topic

class FavouritesModel(context: Context) {
    val localDB = AppDataBase.getInstance(context)

    fun getLikedItems(): MutableList<Topic> {
        return localDB.getItemDAO().getLikedData()
    }
}