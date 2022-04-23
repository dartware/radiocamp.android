package com.dartware.radiocamp.di

import com.dartware.radiocamp.data.repositories.RadiostationsRepositoryImpl
import com.dartware.radiocamp.domain.repositories.RadiostationsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

	@Binds
	@Singleton
	abstract fun bindRadiostationsRepository(radiostationsRepository: RadiostationsRepositoryImpl): RadiostationsRepository

}