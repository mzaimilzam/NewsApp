package com.mzm.core.data.local.entity

import androidx.room.PrimaryKey

/**
 * Created by Muhammad Zaim Milzam on 08/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
data class CategoryNewsRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val nextPage : Int?,
    val prevPage : Int?,
)
