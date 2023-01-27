package com.example.appmarte.Model.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

companion object{

    // SI QUIERE TRABAJAR CON COROUTINES ESTA CLASE QUEDA IGUAL

    private const val BASE_URL = "https://farmanet.minsal.cl/index.php/ws/"



    fun getRetrofit(): MarsApi {
         val retrofit= Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()

    return retrofit.create(MarsApi::class.java)


}

}}