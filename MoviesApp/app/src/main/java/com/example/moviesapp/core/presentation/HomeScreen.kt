package com.example.moviesapp.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Mic
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.moviesapp.presentation.MovieListUiEvent
import com.example.moviesapp.presentation.MovieListViewModel
import com.example.moviesapp.presentation.componentes.MovieItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val movieListViewModel = hiltViewModel<MovieListViewModel>()
    val movieListState by movieListViewModel.movieListState.collectAsState()

    Scaffold(
        bottomBar = { BottomNavigationBar() },
        containerColor = Color(0xFF1C1C1C) // Dark background color
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Bạn muốn xem gì?",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = movieListState.searchQuery,
                onValueChange = { movieListViewModel.onEvent(MovieListUiEvent.Search(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                placeholder = { Text(text = "Tìm kiếm phim...", color = Color.Gray) },
                shape = RoundedCornerShape(30.dp),
                leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = "Search Icon", tint = Color.Gray) },
                trailingIcon = { Icon(Icons.Rounded.Mic, contentDescription = "Mic Icon", tint = Color.Gray) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFF333333),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.White
                )
            )

            if (movieListState.searchList.isNotEmpty()) {
                Text(
                    text = "Search Results",
                    color = Color(0xFFFFC107),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(movieListState.searchList) { movie ->
                        MovieItem(movie = movie, navHostController = navController)
                    }
                }
            } else {
                Text(
                    text = "Popular",
                    color = Color(0xFFFFC107),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                if (movieListState.popularMovieList.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(32.dp),
                        contentAlignment = Alignment.Center
                    ) { CircularProgressIndicator() }
                } else {
                    LazyRow(modifier = Modifier.fillMaxWidth()) {
                        items(movieListState.popularMovieList) { movie ->
                            MovieItem(movie = movie, navHostController = navController)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Upcoming",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
                if (movieListState.upcomingMovieList.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(32.dp),
                        contentAlignment = Alignment.Center
                    ) { CircularProgressIndicator() }
                } else {
                    LazyRow(modifier = Modifier.fillMaxWidth()) {
                        items(movieListState.upcomingMovieList) { movie ->
                            MovieItem(movie = movie, navHostController = navController)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        BottomNavItem("Khám phá", Icons.Rounded.Explore),
        BottomNavItem("Yêu thích", Icons.Outlined.FavoriteBorder),
        BottomNavItem("Trang chủ", Icons.Outlined.Home),
        BottomNavItem("Giỏ hàng", Icons.Outlined.ShoppingCart)
    )
    val selectedIndex = rememberSaveable { mutableIntStateOf(2) }

    NavigationBar(
        containerColor = Color(0xFF252525)
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex.intValue == index,
                onClick = { selectedIndex.intValue = index },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                    )
                },
                label = { Text(text = item.title, fontSize = 12.sp) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color(0xFF252525)
                )
            )
        }
    }
}

data class BottomNavItem(
    val title: String,
    val icon: ImageVector
)