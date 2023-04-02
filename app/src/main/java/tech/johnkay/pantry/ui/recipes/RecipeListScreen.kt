@file:OptIn(ExperimentalMaterial3Api::class)

package tech.johnkay.pantry.ui.recipes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import tech.johnkay.pantry.ui.utils.general.flagEmoji

@Composable
fun RecipeListScreen(
    recipeListViewModel: RecipeListViewModel = viewModel()
) {
    val state by recipeListViewModel.state.collectAsState()
    RecipeListContent(state = state, onRecipeSelected = { isSelected, recipe ->
        recipeListViewModel.onRecipeSelected(recipe, isSelected) })
}

@Composable
fun RecipeListContent(state: RecipeListViewModel.State, onRecipeSelected: (Boolean, Recipe) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pantry") },
                navigationIcon = {
                    IconButton(
                        onClick = { /* "Open nav drawer" */ }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Localized description")
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding
            ) {
                items(state.recipes) { recipe ->
                    ListItem(
                        headlineContent = { Text(recipe.data.name) },
                        leadingContent = { Text(recipe.data.region.flagEmoji) },
                        trailingContent = {
                            Checkbox(checked = recipe.isSelected, onCheckedChange = { isSelected ->
                                onRecipeSelected(isSelected, recipe.data)
                            })
                        }
                    )
                    Divider()
                }
            }
        }
    )

}