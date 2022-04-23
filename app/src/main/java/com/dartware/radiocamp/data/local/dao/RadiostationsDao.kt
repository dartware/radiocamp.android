package com.dartware.radiocamp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dartware.radiocamp.data.local.models.RadiostationEntity

@Dao
interface RadiostationsDao {

	@Query("SELECT * FROM radiostations")
	suspend fun getAll(): List<RadiostationEntity>

	@Query("SELECT * FROM radiostations WHERE id=:id")
	suspend fun get(id: Int): RadiostationEntity

	@Insert
	suspend fun add(radiostation: RadiostationEntity)

	@Insert
	suspend fun addRange(radiostations: List<RadiostationEntity>)

	@Query("DELETE FROM radiostations")
	suspend fun clear()

}