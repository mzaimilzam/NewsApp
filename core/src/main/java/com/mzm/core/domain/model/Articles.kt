package com.mzm.core.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

data class Articles(
    val publishedAt: String? = null,
    val author: String? = null,
    val urlToImage: String? = null,
    val description: String? = null,
    val source: String? = null,
    val title: String,
    val url: String? = null,
    val content: String? = null
)