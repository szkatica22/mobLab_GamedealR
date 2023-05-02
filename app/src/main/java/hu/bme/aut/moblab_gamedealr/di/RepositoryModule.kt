package hu.bme.aut.moblab_gamedealr.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import hu.bme.aut.moblab_gamedealr.ui.games.GamesRepository

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideGamesRepository(
//        gamedealRService: GamedealRService,
//        gamedealRDao: GamedealRDao
    ): GamesRepository {
        return GamesRepository(/*gamedealRService, gamedealRDao*/)
    }
}