package com.example.composeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composeapp.ui.theme.Purple40

@Composable
fun GymApp() {
    val vm: GymViewModel = viewModel()

    LazyColumn(Modifier.padding(8.dp)) {
        items(vm.state) {
            GymItem(it) {
                vm.toggleFavoriteState(it)

            }
        }
    }
}

@Composable
fun GymItem(gym: Gym, onClick: (Int) -> Unit) {
    val icon = if (gym.isFavorite) {
        Icons.Filled.Favorite
    } else {
        Icons.Filled.FavoriteBorder
    }

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ), modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            DefaultIcon(
                icon = Icons.Filled.Place,
                Modifier.weight(0.15f),
                contentDescription = "Place Icon"
            )
            GymDetails(gym, Modifier.weight(0.70f))
            DefaultIcon(
                icon = icon,
                Modifier.weight(0.15f),
                contentDescription = "Favourite Icon"
            ) {
                onClick(gym.id)
            }
        }
    }
}

@Composable
fun DefaultIcon(
    icon: ImageVector,
    modifier: Modifier,
    contentDescription: String,
    onClick: () -> Unit = {}
) {

    Image(
        imageVector = icon,
        contentDescription = contentDescription,
        colorFilter = ColorFilter.tint(Color.DarkGray),
        modifier = modifier
            .padding(8.dp)
            .clickable {
                onClick()
            }
    )
}

@Composable
fun GymDetails(gym: Gym, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = gym.name, style = MaterialTheme.typography.titleLarge, color = Purple40)
        Text(text = gym.details, style = MaterialTheme.typography.bodyMedium)
    }

}
