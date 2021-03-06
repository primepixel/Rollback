package io.aethibo.data.datasource

import io.aethibo.data.utils.Resource
import io.aethibo.domain.mapped.ProductItem
import io.aethibo.domain.mapped.UserItem
import io.aethibo.domain.request.AddProductRequest
import io.aethibo.domain.request.UserRequest
import io.aethibo.domain.response.LoginResponse

interface MainRemoteDataSource {
    // Auth
    suspend fun loginUser(user: UserRequest): Resource<LoginResponse>

    // User handler
    suspend fun getUsers(): Resource<List<UserItem>>
    suspend fun getUser(id: String): Resource<UserItem>

    // Categories handler
    suspend fun getCategories(): Resource<List<String>>

    // Product handler
    suspend fun getProducts(): Resource<List<ProductItem>>
    suspend fun getProduct(id: Int): Resource<ProductItem>
    suspend fun addProduct(data: AddProductRequest): Resource<ProductItem>
    suspend fun deleteProduct(id: Int): Resource<Boolean>
}