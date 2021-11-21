package com.sinaseyfi.remote.models.crypto.info

import com.google.gson.annotations.SerializedName
import com.sinaseyfi.remote.*
import com.sinaseyfi.remote.base.Dto

data class CryptoInfoDto(
    val details: Map<String, CryptoDetailsDto>
): Dto

data class CryptoDetailsDto(
    @SerializedName(ID)
    val id: Long,
    @SerializedName(URLs)
    val urls: CryptoURLDto,
    @SerializedName(LOGO)
    val logo: String?,
    @SerializedName(NAME)
    val name: String,
    @SerializedName(SYMBOL)
    val symbol: String,
    @SerializedName(SLUG)
    val slug: String,
    @SerializedName(DESCRIPTION)
    val description: String,
    @SerializedName(DATE_ADDED)
    val dateAdded: String,
    @SerializedName(TAGS)
    val tags: List<String>,
    @SerializedName(CATEGORY)
    val category: String
): Dto

data class CryptoURLDto(
    @SerializedName(WEBSITE)
    val website: List<String>?,
    @SerializedName(TECHNICAL_DOC)
    val technicalDoc: List<String>?,
    @SerializedName(TWITTER)
    val twitter: List<String>?,
    @SerializedName(REDDIT)
    val reddit: List<String>?,
    @SerializedName(MESSAGE_BOARD)
    val messageBoard: List<String>?,
    @SerializedName(ANNOUNCEMENT)
    val announcement: List<String>?,
    @SerializedName(CHAT)
    val chat: List<String>?,
    @SerializedName(EXPLORER)
    val explorer: List<String>?,
    @SerializedName(SOURCE_CODE)
    val sourceCode: List<String>?
): Dto