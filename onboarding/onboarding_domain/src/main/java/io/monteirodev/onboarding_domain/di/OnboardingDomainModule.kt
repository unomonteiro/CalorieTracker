package io.monteirodev.onboarding_domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import io.monteirodev.onboarding_domain.use_case.ValidateNutrients

@Module
@InstallIn(ViewModelComponent::class)
object OnboardingDomainModule {

    @Provides
    @ViewModelScoped
    fun providesValidateNutrientsUseCase(): ValidateNutrients {
        return ValidateNutrients()
    }
}