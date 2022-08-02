package com.example.cinemapp.data.utils

interface ResponseListener<T> {

    fun onResponse(response: RepositoryResponse<T>)

    fun onError(error: RepositoryError)

}