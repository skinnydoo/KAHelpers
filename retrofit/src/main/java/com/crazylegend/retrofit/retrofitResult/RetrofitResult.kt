package com.crazylegend.retrofit.retrofitResult

import okhttp3.ResponseBody


/**
 * Created by CrazyLegenD on 2/8/19 to long live and prosper !
 */
sealed class RetrofitResult<out T> {


    data class Success<T>(val value: T) : RetrofitResult<T>() {
        val isValueAListAndNullOrEmpty get() = value is List<*> && value.isNullOrEmpty()
        val isValueAListAndNotNullOrEmpty get() = value is List<*> && !value.isNullOrEmpty()
    } // handle UI changes when everything is loaded

    object Loading : RetrofitResult<Nothing>() // handle loading state
    data class Error(val throwable: Throwable) : RetrofitResult<Nothing>() //this one gets thrown when there's an error on your side or an error we throw from http
    data class ApiError(val responseCode: Int, val errorBody: ResponseBody?) : RetrofitResult<Nothing>() //whenever the api throws an error
    object Idle : RetrofitResult<Nothing>()
}

