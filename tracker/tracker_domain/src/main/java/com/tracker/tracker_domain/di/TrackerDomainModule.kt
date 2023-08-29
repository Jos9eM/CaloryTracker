package com.tracker.tracker_domain.di

import com.calorieTracker.core.domain.preferences.Preferences
import com.tracker.tracker_domain.repository.TrackerRepository
import com.tracker.tracker_domain.use_cases.CalculateMealNutrients
import com.tracker.tracker_domain.use_cases.DeleteTrackedFood
import com.tracker.tracker_domain.use_cases.GetFoodsForDate
import com.tracker.tracker_domain.use_cases.SearchFood
import com.tracker.tracker_domain.use_cases.TrackFood
import com.tracker.tracker_domain.use_cases.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        preferences: Preferences,
        repository: TrackerRepository
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences = preferences)
        )
    }
}