package com.mzm.core.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "sources_entity")
data class Sources(

	@ColumnInfo(name = "country")
	val country: String? = null,

	@ColumnInfo(name ="name")
	val name: String? = null,

	@ColumnInfo(name ="description")
	val description: String? = null,

	@ColumnInfo(name ="language")
	val language: String? = null,

	@PrimaryKey
	@NotNull
	@ColumnInfo(name ="id")
	val id: String,

	@ColumnInfo(name ="category")
	val category: String? = null,

	@ColumnInfo(name ="url")
	val url: String? = null
)