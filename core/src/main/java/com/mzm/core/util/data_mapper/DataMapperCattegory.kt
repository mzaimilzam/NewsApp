package com.mzm.core.util.data_mapper

import com.mzm.core.data.soruce.local.entity.ArticlesEntity
import com.mzm.core.data.soruce.remote.response.ArticlesItem
import com.mzm.core.domain.model.Articles

/**
 * Created by Muhammad Zaim Milzam on 11/04/2022.
 * linkedin : Muhammad Zaim Milzam
 */
object DataMapperCattegory {

    fun mapResponsetoEntities(input: List<ArticlesItem>): List<ArticlesEntity> {
        val list = ArrayList<ArticlesEntity>()
        input.map {
            val data = ArticlesEntity(
                publishedAt = it.publishedAt,
                author = it.author,
                urlToImage = it.urlToImage,
                description = it.description,
                source = it.source?.name,
                title = it.title.toString(),
                url = it.url,
                content = it.content
            )
            list.add(data)
        }
        return list
    }

    fun mapEntitiestoDomain(it: ArticlesEntity): Articles =
        Articles(
            publishedAt = it.publishedAt,
            author = it.author,
            urlToImage = it.urlToImage,
            description = it.description,
            source = it.source,
            title = it.title,
            url = it.url,
            content = it.content
        )
}