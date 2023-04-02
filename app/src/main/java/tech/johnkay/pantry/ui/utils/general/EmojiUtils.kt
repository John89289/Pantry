package tech.johnkay.pantry.ui.utils.general

import androidx.compose.ui.text.toUpperCase

val String.flagEmoji: String
    get() {
        val uppercaseString = uppercase()
        val base = 0x1F1E6 // A regional indicator
        val firstChar = Character.codePointAt(uppercaseString, 0) - 0x41 + base
        val secondChar = Character.codePointAt(uppercaseString, 1) - 0x41 + base
        return String(Character.toChars(firstChar)) + String(Character.toChars(secondChar))
    }