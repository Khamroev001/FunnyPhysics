package com.example.myapplication.screens.info

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.screens.BottomNavigationComponent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")@Composable
fun InfoView(viewModel: InfoViewModel, navController: NavController) {
    val item by viewModel.item.observeAsState()
    Scaffold(bottomBar = {
        BottomNavigationComponent(navController = navController)
    }) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(it)
                .padding(10.dp)
        ) {

            Row( Modifier.fillMaxWidth().padding(10.dp), Arrangement.SpaceBetween) {
                Text(item!!.name, fontSize = 26.sp, fontWeight = FontWeight.Bold)
            }
            IconButton(onClick = {
                viewModel.onClick()
                viewModel.updateItem()
            }) {
                if (item!!.liked) Icon(Icons.Default.Favorite, contentDescription = null)
                else Icon(Icons.Default.FavoriteBorder, contentDescription = null)
            }
          
            
            Divider(thickness = 2.dp, modifier = Modifier.padding(vertical = 10.dp))
            Text(modifier = Modifier.padding(5.dp), text =  item!!.description, fontSize = 16.sp)
        }
    }
}