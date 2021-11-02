package net.nueca.posko.app.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import net.nueca.posko.app.PoskoApplication
import javax.inject.Singleton

/**
 * Created by edwinmartinez on June 20, 2019
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    AndroidModule::class
])
interface AppComponent : AndroidInjector<PoskoApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application?): Builder

        fun build(): AppComponent?
    }
}