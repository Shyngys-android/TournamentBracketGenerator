package com.example.tbg.di.components

import android.app.Application
import com.example.tbg.App
import com.example.tbg.di.contributes_android_injector.activity.ActivityBuildersModule
import com.example.tbg.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
import dagger.android.AndroidInjectionModule

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}