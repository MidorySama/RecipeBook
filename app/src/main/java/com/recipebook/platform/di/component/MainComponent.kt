package com.recipebook.platform.di.component

import com.recipebook.platform.di.module.RepositoryModule
import com.recipebook.platform.di.module.RetrofitModule
import com.recipebook.platform.di.module.UserRegisterModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class,
    RetrofitModule::class,
    UserRegisterModule::class])

interface MainComponent {
}