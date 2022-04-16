package com.dartware.radiocamp.di

import com.dartware.radiocamp.data.repositories.RadiostationsRepositoryImpl
import com.dartware.radiocamp.domain.repositories.RadiostationsRepository
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
	fun provodeRadiostationsRepository(): RadiostationsRepository {
		return RadiostationsRepositoryImpl()
	}

}