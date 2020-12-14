package com.example.parqueadero.di.modules

import com.example.parqueadero.MainActivity
import com.example.parqueadero.presenters.TestPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TestModule(var activity: MainActivity) {

    @Provides
    @Singleton
    fun  providePresenters():TestPresenter {
        return TestPresenter(this.activity)
    }
}