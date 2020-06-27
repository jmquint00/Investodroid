package com.manu.investodroid.network

import com.manu.investodroid.model.Stock
import com.manu.investodroid.model.StockDetail
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

fun createInvestodroidService() : IInvestodroidService {

    val okHttpClient = OkHttpClient
        .Builder()
        .build()

    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://financialmodelingprep.com/api/v3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    return retrofit.create(IInvestodroidService::class.java)
}
interface IInvestodroidService {

    @GET("stock/list")
    fun fetchStockList() : Call<Stock>

    @GET("company/profile/{name}")
    fun fetchStockDetails(
        @Path("name")
        name :String
    ) : Call<StockDetail>

}