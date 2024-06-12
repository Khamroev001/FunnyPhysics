package com.example.myapplication.screens.favourites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.database.Topic
import com.example.myapplication.screens.BottomNavigationComponent
import com.example.myapplication.screens.home.HomeModel
import com.example.myapplication.screens.home.HomeViewModel
import com.example.myapplication.screens.home.TopicItem

@Composable
fun FavouritesView(viewModel: FavouritesViewModel, navController: NavController) {
    val items = viewModel.items.observeAsState().value
    Scaffold(bottomBar = {
        BottomNavigationComponent(navController = navController)
    }) {
        Column(Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(modifier = Modifier.fillMaxWidth(),text = "Funny Physics App", fontSize = 28.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(16.dp))


            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .padding(10.dp)
            ) {
                items(items!!) { item ->

                    TopicItem(topic = item, navController = navController)

                }
            }
        }

    }
}