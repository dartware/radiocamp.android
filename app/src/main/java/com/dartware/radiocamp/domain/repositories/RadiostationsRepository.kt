package com.dartware.radiocamp.domain.repositories

import com.dartware.radiocamp.core.Resource
import com.dartware.radiocamp.domain.models.Radiostation
import kotlinx.coroutines.flow.Flow

interface RadiostationsRepository {
	fun getAll(): Flow<Resource<List<Radiostation>>>
}