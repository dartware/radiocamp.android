package com.dartware.radiocamp.di

import android.app.Application
import com.dartware.radiocamp.data.local.databases.RadiocampDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

	@Provides
	@Singleton
	fun provideRadiocampDatabase(application: Application): RadiocampDatabase = RadiocampDatabase.create(application)

}