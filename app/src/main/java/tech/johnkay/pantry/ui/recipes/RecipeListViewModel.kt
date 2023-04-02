package tech.johnkay.pantry.ui.recipes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import tech.johnkay.pantry.ui.utils.general.Selectable

data class Recipe(val name: String, val region: String)

val recipes = listOf(
    Recipe("Chickpea & Broccoli Curry", "in"),
    Recipe("Broccoli Pasta", "it"),
    Recipe("Tofu noodles", "cn"),
    Recipe("Pizza & salad", "it")
)

class RecipeListViewModel: ViewModel() {

    data class State(val recipes: List<Selectable<Recipe>>)

    val state = MutableStateFlow(State(recipes.map { Selectable(false, it) }))

    fun onRecipeSelected(recipe: Recipe, isSelected: Boolean) {
        state.update { oldState ->
            oldState.copy(recipes = oldState.recipes.map { if ((it.data == recipe)) it.copy(isSelected = isSelected) else it })
        }
    }
}