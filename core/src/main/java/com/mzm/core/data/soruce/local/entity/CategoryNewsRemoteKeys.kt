package com.mzm.core.data.soruce.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Muhammad Zaim Milzam on 08/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
@Entity(tableName = "category_remote_keys")
data class CategoryNewsRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val nextPage : Int?,
    val prevPage : Int?,
)
