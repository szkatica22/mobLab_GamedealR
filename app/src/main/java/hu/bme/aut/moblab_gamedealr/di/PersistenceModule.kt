package hu.bme.aut.moblab_gamedealr.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.moblab_gamedealr.R
import hu.bme.aut.moblab_gamedealr.persistence.AppDatabase
import hu.bme.aut.moblab_gamedealr.persistence.MyDealsDao
import hu.bme.aut.moblab_gamedealr.persistence.StoreInfoDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            application.getString(R.string.database)
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideMayDealsDao(appDatabase: AppDatabase): MyDealsDao {
        return appDatabase.myDealsDao()
    }
    @Provides
    @Singleton
    fun provideStoreInfoDao(appDatabase: AppDatabase): StoreInfoDao {
        return appDatabase.storeInfoDao()
    }
}