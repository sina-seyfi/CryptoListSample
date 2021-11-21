package com.sinaseyfi.domain.models.crypto.info

import com.sinaseyfi.domain.base.DataModel

data class CryptoInfoDataModel(
    val details: Map<String, CryptoDetailsDataModel>
): DataModel

data class CryptoDetailsDataModel(
    val id: Long,
    val urls: CryptoURLDataModel,
    val logo: String?,
    val name: String,
    val symbol: String,
    val slug: String,
    val description: String,
    val dateAdded: String,
    val tags: List<String>,
    val category: String
): DataModel

data class CryptoURLDataModel(
    val website: List<String>?,
    val technicalDoc: List<String>?,
    val twitter: List<String>?,
    val reddit: List<String>?,
    val messageBoard: List<String>?,
    val announcement: List<String>?,
    val chat: List<String>?,
    val explorer: List<String>?,
    val sourceCode: List<String>?
): DataModel