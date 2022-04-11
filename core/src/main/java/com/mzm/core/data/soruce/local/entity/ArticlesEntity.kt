package com.mzm.core.data.soruce.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "article_entity")
data class ArticlesEntity(

    @ColumnInfo(name = "publishedAt")
    val publishedAt: String? = null,

    @ColumnInfo(name = "author")
    val author: String? = null,

    @ColumnInfo(name = "urlToImage")
    val urlToImage: String? = null,

    @ColumnInfo(name = "description")
    val description: String? = null,

    @ColumnInfo(name = "source")
    val source: String? = null,

    @PrimaryKey(autoGenerate = false)
    @NotNull
    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "url")
    val url: String? = null,

    @ColumnInfo(name = "content")
    val content: String? = null
)