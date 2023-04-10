package io.monteirodev.calorietracker.navigation

import androidx.navigation.NavController
import io.monteirodev.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}