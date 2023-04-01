package tech.johnkay.pantry.ui.recipes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable

data class Recipe(val name: String)

val recipes = listOf(
    Recipe("Chickpea & Broccoli Curry"),
    Recipe("Broccoli Pasta"),
    Recipe("Tofu noodles"),
    Recipe("Pizza & salad")
)

@Composable
fun RecipeListScreen() {
    LazyColumn {
        items(recipes) {recipe ->
            ListItem(
                headlineContent = { Text(recipe.name) },
                leadingContent = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Localized description",
                    )
                }
            )
            Divider()
        }
    }
}