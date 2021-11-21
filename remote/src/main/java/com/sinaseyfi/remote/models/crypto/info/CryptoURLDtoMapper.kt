package com.sinaseyfi.remote.models.crypto.info

import com.sinaseyfi.domain.models.crypto.info.CryptoURLDataModel
import com.sinaseyfi.remote.base.DtoMapper
import javax.inject.Inject

class CryptoURLDtoMapper @Inject constructor(): DtoMapper<CryptoURLDto, CryptoURLDataModel> {
    override fun mapToDataModel(dto: CryptoURLDto?): CryptoURLDataModel =
        CryptoURLDataModel(
            dto!!.website,
            dto.technicalDoc,
            dto.twitter,
            dto.reddit,
            dto.messageBoard,
            dto.announcement,
            dto.chat,
            dto.explorer,
            dto.sourceCode
        )
}