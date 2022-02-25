package com.recipebook.platform.di.module

import com.recipebook.api.CoreHomeApi
import com.recipebook.repositories.RecipeBookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule
{
    @Provides
    fun productRepositoryProvider(apiService: CoreHomeApi):
            RecipeBookRepository = RecipeBookRepository(apiService)

}