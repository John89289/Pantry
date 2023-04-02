package tech.johnkay.pantry.ui.utils.general

data class Selectable<T>(
    val isSelected: Boolean,
    val data: T
)