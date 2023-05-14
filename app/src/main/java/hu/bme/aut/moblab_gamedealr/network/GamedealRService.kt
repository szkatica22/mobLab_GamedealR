package hu.bme.aut.moblab_gamedealr.network

import hu.bme.aut.moblab_gamedealr.model.Deal
import hu.bme.aut.moblab_gamedealr.model.Game
import hu.bme.aut.moblab_gamedealr.model.Store
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GamedealRService {

    @GET("games")
    fun searchGames(@Query("title") title: String): Call<List<Game>>

    @GET("stores")
    fun getStores(): Call<List<Store>>

    @GET("deals")
    fun getDeals(@Query("title") title: String): Call<List<Deal>>
}