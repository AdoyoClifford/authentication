@file:OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)

package com.example.emergencysystem.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.emergencysystem.Items
import com.example.emergencysystem.R
import com.example.emergencysystem.createDataList

@Composable
fun DashBoard(navController: NavController) {
   Column (modifier = Modifier.padding(16.dp)){
      TopBar()
       Text1()
       Layout(navController)
   }

}
@Composable
fun Text1() {
    Text(
        text = "What do you need?",
        style = MaterialTheme.typography.h4,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun Grids1(data: Items){
    Card(
        backgroundColor = Color(0xffe6f2ff),
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .aspectRatio(1f), elevation = 16.dp) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = data.image),
                contentDescription = data.text,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = data.text, fontWeight = FontWeight.Bold)
            }
        }
    }
}


@Composable
fun Layout(navController: NavController){
    val list = createDataList()
    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
            items(list.size) { index ->
                Grids1(data = list[index])
            }
        })

}
@Composable
fun TopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.Top) {
        IconButton(
            onClick = {},
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "search",
                modifier = Modifier.size(50.dp)
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bell),
                contentDescription = "notification",
                modifier = Modifier.size(50.dp),
                tint = Color(0xffffcc00)
            )
        }
    }
}


