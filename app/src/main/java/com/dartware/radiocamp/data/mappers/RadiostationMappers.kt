package com.dartware.radiocamp.data.mappers

import com.dartware.radiocamp.data.local.models.RadiostationEntity
import com.dartware.radiocamp.domain.models.Radiostation

fun RadiostationEntity.toRadiostation(): Radiostation {
	return Radiostation(
		id = id,
		title = title,
		streamURL = streamURL
	)
}

fun Radiostation.toRadiostationEntity(): RadiostationEntity {
	return RadiostationEntity(
		id = id,
		title = title,
		streamURL = streamURL
	)
}