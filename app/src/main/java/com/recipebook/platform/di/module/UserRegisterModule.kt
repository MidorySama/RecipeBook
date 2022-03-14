package com.recipebook.platform.di.module

import com.recipebook.api.CoreHomeApi
import com.recipebook.repositories.UserRegisterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class UserRegisterModule
{
    @Provides fun userRepositoryProvider(apiService: CoreHomeApi):
            UserRegisterRepository = UserRegisterRepository(apiService)
}

