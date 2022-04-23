package com.dartware.radiocamp.core

sealed class Resource<Type>(
	val data: Type? = null,
	val message: String? = null
) {
	class Success<Type>(data: Type?) : Resource<Type>(data)
	class Error<Type>(message: String, data: Type? = null) : Resource<Type>(data, message)
	class Loading<Type>(val isLoading: Boolean = true) : Resource<Type>(null)
}
