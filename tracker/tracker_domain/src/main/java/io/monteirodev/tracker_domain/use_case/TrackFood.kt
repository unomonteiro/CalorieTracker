package io.monteirodev.tracker_domain.use_case

import io.monteirodev.tracker_domain.model.MealType
import io.monteirodev.tracker_domain.model.TrackableFood
import io.monteirodev.tracker_domain.model.TrackedFood
import io.monteirodev.tracker_domain.repository.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class TrackFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        food: TrackableFood,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            with(food) {
                TrackedFood(
                    name = name,
                    carbs = ((carbsPer100g / 100f) * amount).roundToInt(),
                    protein = ((proteinPer100g / 100f) * amount).roundToInt(),
                    fat = ((fatPer100g / 100f) * amount).roundToInt(),
                    calories = ((caloriesPer100g / 100f) * amount).roundToInt(),
                    imageUrl = imageUrl,
                    mealType = mealType,
                    amount = amount,
                    date = date
                )
            }
        )
    }
}