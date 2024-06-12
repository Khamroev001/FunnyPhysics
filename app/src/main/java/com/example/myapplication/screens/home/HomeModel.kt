package com.example.myapplication.screens.home

import android.content.Context
import com.example.myapplication.database.AppDataBase
import com.example.myapplication.database.Topic

class HomeModel(val context: Context) {
    val localDB = AppDataBase.getInstance(context)

    fun isFirstRun(): Boolean {
        val sharedPreferences = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val isFirstRun = sharedPreferences.getBoolean("is_first_run", true)
        if (isFirstRun) sharedPreferences.edit().putBoolean("is_first_run", false).apply()
        return isFirstRun
    }

    fun getItems(): MutableList<Topic> {
        return localDB.getItemDAO().getAllData()
    }

    fun addItem(topic: Topic) {
        localDB.getItemDAO().insertData(topic)
    }
}