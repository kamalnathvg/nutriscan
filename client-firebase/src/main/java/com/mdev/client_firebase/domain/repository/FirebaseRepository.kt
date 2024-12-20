package com.mdev.client_firebase.domain.repository

import com.google.firebase.auth.AuthResult
import com.mdev.client_firebase.data.remote.dto.AnalyticsData
import com.mdev.client_firebase.data.remote.dto.AppUser
import com.mdev.client_firebase.data.remote.dto.ProductDetailsDto
import com.mdev.common.utils.Resource
import com.mdev.openfoodfacts_client.domain.model.ProductDetails
import kotlinx.coroutines.flow.StateFlow

interface FirebaseRepository {
    suspend fun getCurrentUserDetails(): AppUser?
    suspend fun registerUserByEmailAndPassword(email: String, password: String): AuthResult
    suspend fun loginUserByEmailAndPassword(email: String, password: String): AuthResult
    suspend fun createUserDetails(appUser: AppUser)
    suspend fun logout()
    suspend fun getSearchHistory(): StateFlow<List<ProductDetailsDto>>
    suspend fun getAnalyticsData(): StateFlow<AnalyticsData>
    suspend fun addItemToSearchHistory(product: ProductDetailsDto)
    suspend fun isUserLoggedIn(): Boolean
    suspend fun addProductToSearchHistory(productDetails: ProductDetails)
    suspend fun getSearchHistoryWithDetails(): StateFlow<List<ProductDetails>>
    suspend fun updateUserDetails(appUser: AppUser): Resource<Unit>
}