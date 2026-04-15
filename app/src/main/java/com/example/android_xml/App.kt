package com.example.android_xml

import android.app.Application
import com.example.android_xml.di.calculatorModule
import com.example.android_xml.di.listModule
import com.example.android_xml.di.weatherModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(
                weatherModule,
                calculatorModule,
                listModule
            )
        }
    }
}