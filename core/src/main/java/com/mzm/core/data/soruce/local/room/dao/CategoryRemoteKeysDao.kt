package com.mzm.core.data.soruce.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mzm.core.data.soruce.local.entity.CategoryNewsRemoteKeys

/**
 * Created by Muhammad Zaim Milzam on 11/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */

@Dao
interface CategoryRemoteKeysDao {

    @Query("SELECT * FROM category_remote_keys WHERE id =  :id ")
    suspend fun getRemoteKeys(id: String) : CategoryNewsRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(categoryNewsRemoteKeys: List<CategoryNewsRemoteKeys>)

    @Query("DELETE FROM category_remote_keys")
    suspend fun deleteAllRemoteKeys()
}