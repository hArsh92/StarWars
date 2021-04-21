package com.harsh.starwarstournament.di

import android.content.Context
import com.harsh.starwarstournament.datasource.StarWarsDatabase
import com.harsh.starwarstournament.match.datasource.model.MatchDao
import com.harsh.starwarstournament.pointstable.datasource.model.PlayerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseDiModule {

    @Singleton
    @Provides
    fun provideStarWarsDB(
        @ApplicationContext app: Context
    ): StarWarsDatabase {
        return StarWarsDatabase.getInstance(app)
    }

    @Singleton
    @Provides
    fun providePlayerDao(
        db: StarWarsDatabase
    ): PlayerDao {
        return db.pointsTableDao()
    }

    @Singleton
    @Provides
    fun provideMatchDao(
        db: StarWarsDatabase
    ): MatchDao {
        return db.matchDao()
    }
}
