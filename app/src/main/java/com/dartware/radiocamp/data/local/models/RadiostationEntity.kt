package com.dartware.radiocamp.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "radiostations")
data class RadiostationEntity(
	val title: String,
	val streamURL: String,
	@PrimaryKey val id: Int? = null
)