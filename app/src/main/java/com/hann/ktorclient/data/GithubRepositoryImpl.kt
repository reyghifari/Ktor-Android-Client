package com.hann.ktorclient.data

import com.bumptech.glide.load.HttpException
import com.hann.ktorclient.data.network.ApiResponse
import com.hann.ktorclient.data.network.RemoteDataSource
import com.hann.ktorclient.domain.model.User
import com.hann.ktorclient.domain.repository.IGithubRepository
import com.hann.ktorclient.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import java.io.IOException


class GithubRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
) : IGithubRepository {

    override fun getSearchUser(username: String): Flow<Resource<List<User>>> {
        return flow {
           try {
               emit(Resource.Loading())
                when(val listUser = remoteDataSource.getSearchUser(username).first()){
                    is ApiResponse.Success -> {
                        val users = DataMapper.mapResponsesToDomain(listUser.data)
                        emit(Resource.Success(users))
                    }
                    is ApiResponse.Empty -> emit(Resource.Error("User not found"))
                    is ApiResponse.Error -> emit(Resource.Error(listUser.errorMessage))
                }
           }catch (e: HttpException){
               emit(
                   Resource.Error(
                       e.localizedMessage ?: "An unexpected Error Occurred"
                   )
               )
           }catch (e: IOException){
               emit(Resource.Error("Couldn't reach server. Check your internet server"))
           }
        }
    }


}