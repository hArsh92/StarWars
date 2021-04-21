package com.harsh.starwarstournament.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.harsh.starwarstournament.BuildConfig
import com.harsh.starwarstournament.match.datasource.model.MatchDao
import com.harsh.starwarstournament.match.datasource.model.MatchEntity
import com.harsh.starwarstournament.pointstable.datasource.model.PlayerDao
import com.harsh.starwarstournament.pointstable.datasource.model.PlayerEntity

@Database(
    entities = [PlayerEntity::class, MatchEntity::class],
    version = BuildConfig.DB_VERSION
)
abstract class StarWarsDatabase : RoomDatabase() {

    abstract fun pointsTableDao(): PlayerDao
    abstract fun matchDao(): MatchDao

    companion object {

        @Volatile
        private var INSTANCE: StarWarsDatabase? = null

        fun getInstance(context: Context): StarWarsDatabase =
            INSTANCE.orElse {
                synchronized(this) {
                    INSTANCE.orElse { buildDatabase(context).also { INSTANCE = it } }
                }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StarWarsDatabase::class.java,
                "star_wars.db"
            )
                .createFromAsset("star_wars.db")
                .build()
    }
}

fun <T> T?.orElse(block: () -> T): T = this ?: block()