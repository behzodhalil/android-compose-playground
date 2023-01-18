package uz.behzoddev.a06_jetnotes_sample

import android.app.Application
import uz.behzoddev.a06_jetnotes_sample.di.DependencyInjector

/**
 * Application class responsible for initializing the dependency injector.
 */

class JetNotesApplication : Application() {

    lateinit var dependencyInjector: DependencyInjector

    override fun onCreate() {
        super.onCreate()
        initDependencyInjector()
    }

    private fun initDependencyInjector() {
        dependencyInjector = DependencyInjector(this)
    }
}