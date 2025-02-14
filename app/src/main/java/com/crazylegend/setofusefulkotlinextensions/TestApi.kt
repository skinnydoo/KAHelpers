package com.crazylegend.setofusefulkotlinextensions

import com.crazylegend.retrofit.retrofitResult.RetrofitResult
import com.crazylegend.setofusefulkotlinextensions.adapter.TestModel
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by hristijan on 8/26/19 to long live and prosper !
 */
interface TestApi {


    @GET("posts")
    suspend fun getPosts(): RetrofitResult<List<TestModel>>

    companion object {
        const val API = "https://jsonplaceholder.typicode.com/"
    }
}