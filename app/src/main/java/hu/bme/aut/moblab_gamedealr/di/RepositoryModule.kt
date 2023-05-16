package hu.bme.aut.moblab_gamedealr.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import hu.bme.aut.moblab_gamedealr.network.GamedealRService
import hu.bme.aut.moblab_gamedealr.persistence.MyDealsDao
import hu.bme.aut.moblab_gamedealr.persistence.StoreInfoDao
import hu.bme.aut.moblab_gamedealr.ui.games.GamesRepository

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideGamesRepository(
        gamedealRService: GamedealRService,
        myDealsDao: MyDealsDao,
        storeInfoDao: StoreInfoDao
    ): GamesRepository {
        return GamesRepository(gamedealRService, myDealsDao, storeInfoDao)
    }
}