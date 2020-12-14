package com.example.parqueadero.di.component

import com.example.parqueadero.MainActivity
import com.example.parqueadero.di.modules.TestModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestModule::class])
public interface TestComponent {
    fun inject(mainActivity: MainActivity)
}