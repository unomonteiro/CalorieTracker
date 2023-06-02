package io.monteirodev.tracker_domain.use_case

import io.monteirodev.tracker_domain.model.TrackableFood
import io.monteirodev.tracker_domain.model.TrackedFood
import io.monteirodev.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {

    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}