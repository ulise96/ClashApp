package com.aptivist.clashapp.data.remote

import com.aptivist.clashapp.data.remote.models.AllCardsResponse
import com.aptivist.clashapp.data.remote.models.ProfileResponse
import com.aptivist.clashapp.domain.repositories.RoyalAPIRepository

class RoyalRepositoryImpl(
    private val royalAPI: ClashRoyaleAPI
): RoyalAPIRepository {
    override suspend fun fetchAllCards(): AllCardsResponse {
        return royalAPI.getAllCards()
    }

    override suspend fun fetchPlayerInfo(tag: String): ProfileResponse {
        return royalAPI.getPlayerInfo(tag)
    }
}