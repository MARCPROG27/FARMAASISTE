package com.example.appmarte.Model.Remote

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

// inclye los verbos de solicitud
interface MarsApi {

    @GET("getLocales")
    fun fetchMarsData(): Call<List<MarsRealState>> // vieja confiable


    //PARTE 2 CON COROUTINES

   @GET("getLocales")
   suspend fun fetchMarsDataCoroutines(): Response<List<MarsRealState>> // nueva forma

}