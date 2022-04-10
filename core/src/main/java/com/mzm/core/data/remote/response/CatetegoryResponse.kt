package com.mzm.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class CatetegoryResponse(

    @field:SerializedName("totalResults")
    val totalResults: Int? = null,

    @field:SerializedName("articles")
    val articles: List<ArticlesItem?>? = emptyList(),

    @field:SerializedName("status")
    val status: String? = null
)