package com.yasinsenel.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.yasinsenel.movieapp.MovieRow
import com.yasinsenel.movieapp.navigation.MovieScreens

@Composable
fun HomeScreen(navController : NavController){
    Scaffold(topBar ={
        TopAppBar(backgroundColor = Color.Magenta,
            elevation = 5.dp) {
            Text(text = "Movies")
        }
    },){
        MainContent(modifier = Modifier.padding(it),navController = navController)
    }

}

@Composable
fun MainContent(modifier: Modifier,navController: NavController,movieList: List<String> = listOf(
    "Avatar",
    "Harry Potter",
    "LOTR"
)){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(movieList){
                MovieRow(movie = it){myMovie->
                    println(myMovie)
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$myMovie")
                }
            }
        }
    }
}