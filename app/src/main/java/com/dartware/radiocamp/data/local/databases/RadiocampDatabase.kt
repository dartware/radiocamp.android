package com.dartware.radiocamp.data.local.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dartware.radiocamp.data.local.dao.RadiostationsDao
import com.dartware.radiocamp.data.local.models.RadiostationEntity

@Database(
	entities = [
		RadiostationEntity::class
	],
	version = 1
)
abstract class RadiocampDatabase : RoomDatabase() {

	abstract val radiostationsDao: RadiostationsDao

	companion object {

		private const val DATABASE_NAME = "radiocampdb.db"

		fun create(context: Context): RadiocampDatabase {
			return Room.databaseBuilder(
				context,
				RadiocampDatabase::class.java,
				DATABASE_NAME
			).build()
		}

	}

}