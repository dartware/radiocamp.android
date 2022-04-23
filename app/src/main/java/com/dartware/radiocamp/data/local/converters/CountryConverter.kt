package com.dartware.radiocamp.data.local.converters

import androidx.room.TypeConverter
import com.dartware.radiocamp.domain.models.Country

class CountryConverter {

	@TypeConverter
	fun fromCountry(country: Country): String = country.name

	@TypeConverter
	fun toCountry(country: String): Country = Country.valueOf(country)

}