package uz.behzoddev.a06_jetnotes_sample.di

import android.content.Context
import androidx.room.Room
import uz.behzoddev.a06_jetnotes_sample.data.local.core.AppDatabase
import uz.behzoddev.a06_jetnotes_sample.data.repository.DefaultRepository
import uz.behzoddev.a06_jetnotes_sample.data.repository.Repository

/**
 * Provides dependencies across the app.
 */
class DependencyInjector(applicationContext: Context) {

    val repository: Repository by lazy { provideRepository(database) }

    private val database: AppDatabase by lazy { provideDatabase(applicationContext) }


    private fun provideDatabase(applicationContext: Context): AppDatabase =
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()

    private fun provideRepository(database: AppDatabase): Repository {
        val noteDao = database.noteDao()
        val colorDao = database.colorDao()

        return DefaultRepository(noteDao, colorDao)
    }
}