package io.monteirodev.tracker_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.monteirodev.core.domain.preferences.Preferences
import io.monteirodev.tracker_domain.repository.TrackerRepository
import io.monteirodev.tracker_domain.use_case.CalculateMealNutrients
import io.monteirodev.tracker_domain.use_case.DeleteTrackedFood
import io.monteirodev.tracker_domain.use_case.GetFoodsForDate
import io.monteirodev.tracker_domain.use_case.SearchFood
import io.monteirodev.tracker_domain.use_case.TrackFood
import io.monteirodev.tracker_domain.use_case.TrackerUseCases

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}