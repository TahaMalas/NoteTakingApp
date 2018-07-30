package com.tahamalas.notetakingapp.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.tahamalas.notetakingapp.base.IBaseView
import com.tahamalas.notetakingapp.datalayer.db.AppDao
import com.tahamalas.notetakingapp.datalayer.db.AppDatabase
import com.tahamalas.notetakingapp.datalayer.db.AppRepository
import com.tahamalas.notetakingapp.datalayer.db.DbHelper
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
@Suppress("unused")
object ApplicationModule {
    /**
     * Provides the Context
     * @param baseView the IBaseView used to provides the context
     * @return the Context to be provided
     */
    @Provides
    @JvmStatic
    internal fun provideContext(baseView: IBaseView): Context {
        return baseView.getContext()
    }

    /**
     * Provides the Application Context
     * @param context Context in which the application is running
     * @return the Application Context to be provided
     */
    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }

    @Provides
    @Singleton
    @Named("dbName")
    fun provideDbName(): String {
        return "NoteRoomDB"
    }

    @Provides
    @Singleton
    fun provideAppDao(appDatabase: AppDatabase): AppDao {
        return appDatabase.appDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context, @Named("dbName") dbName: String): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).build()
    }

    @Provides
    @Singleton
    fun provideAppRepository(appDao: AppDao): DbHelper {
        return AppRepository(appDao)
    }
}