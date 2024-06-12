package com.example.myapplication.screens.info

import android.content.Context
import com.example.myapplication.database.AppDataBase
import com.example.myapplication.database.Topic

class InfoModel(context: Context) {
    val localDB = AppDataBase.getInstance(context)

    fun getItem(id: Int): Topic {
        return localDB.getItemDAO().getData(id)
    }

    fun updateItem(item: Topic) {
        localDB.getItemDAO().updateData(item)
    }
}