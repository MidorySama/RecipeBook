package com.recipebook.platform.di.component

import com.recipebook.platform.di.module.RepositoryModule
import com.recipebook.platform.di.module.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class,
    RetrofitModule::class])

interface MainComponent {
}