package com.example.myapplication.screens.home

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.database.Topic
import com.example.myapplication.screens.BottomNavigationComponent

@Composable
fun HomeView(viewModel: HomeViewModel, navController: NavController) {
    val topics = viewModel.topics.observeAsState().value
    Scaffold(bottomBar = {
        BottomNavigationComponent(navController = navController)
    }) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(16.dp))
                Text(modifier = Modifier.fillMaxWidth(),text = "Funny Physics App", fontSize = 28.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .padding(10.dp)
            ) {
                items(topics!!) { topic ->
                    TopicItem(topic = topic, navController)
                }
            }

        }

    }
}


@Composable
fun TopicItem(topic: Topic, navController: NavController) {
    val saved = remember {
        mutableStateOf(topic.liked)
    }
    Row(
        Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("Info/${topic.id}")
            }
            .padding(vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {

        Column(
            Modifier
                .padding(horizontal = 12.dp)
                .weight(1f)
        ) {
            Text(
                text = topic.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA7A7A7)
            )
        }
//        IconButton(onClick = {
////            pvm.updateState(book)
//            saved.value = !saved.value
//        }) {
//            Icon(
//                imageVector = Icons.Default.FavoriteBorder,
//                contentDescription = "",
//                tint = if (saved.value) Color(0xFF676F8D) else Color(0xFFC7C5C5)
//            )
//        }
    }
}