package com.dartware.radiocamp.data.repositories

import android.app.Application
import com.dartware.radiocamp.R
import com.dartware.radiocamp.core.Resource
import com.dartware.radiocamp.data.local.databases.RadiocampDatabase
import com.dartware.radiocamp.data.mappers.toRadiostation
import com.dartware.radiocamp.domain.models.Radiostation
import com.dartware.radiocamp.domain.repositories.RadiostationsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RadiostationsRepositoryImpl @Inject constructor(
	database: RadiocampDatabase,
	private val application: Application
) : RadiostationsRepository {

	private val dao = database.radiostationsDao

	override fun getAll(): Flow<Resource<List<Radiostation>>> {
		return flow {

			emit(Resource.Loading(true))

			val radiostations = try {
				dao.getAll()
			} catch (exception: Exception) {

				exception.printStackTrace()
				emit(Resource.Error(application.getString(R.string.radiostations_list_loading_error)))

				null

			}

			emit(Resource.Loading(false))

			radiostations?.let {
				emit(Resource.Success(radiostations.map { it.toRadiostation() }))
			}

		}
	}

}