package com.tracker.tracker_domain.use_cases

import com.tracker.tracker_domain.model.TrackedFood
import com.tracker.tracker_domain.repository.TrackerRepository

class DeleteTrackedFood(private val repository: TrackerRepository) {

    suspend operator fun invoke(
        trackedFood: TrackedFood
    ) {
        repository.deleteTrackedFood(trackedFood)
    }
}