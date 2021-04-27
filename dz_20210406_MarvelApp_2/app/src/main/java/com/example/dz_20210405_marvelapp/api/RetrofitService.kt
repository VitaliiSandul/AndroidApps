package com.example.dz_20210405_marvelapp.api

import com.example.dz_20210405_marvelapp.models.Comic
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {
    private val BASE_URL = "https://gateway.marvel.com/v1/public/"

    val gsonCharacterDeserializer = GsonBuilder()
            .registerTypeAdapter(object : TypeToken<SizeAndArrayCharacters>(){}.type,
                CharacterDeserializer()
            )
            .create()

    val gsonComicDeserializer = GsonBuilder()
        .registerTypeAdapter(object : TypeToken<ArrayList<Comic>>(){}.type,
            ComicDeserializer()
        )
        .create()

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                    OkHttpClient.Builder()
                            .addInterceptor { chain ->
                                val url = chain
                                        .request()
                                        .url()
                                        .newBuilder()
                                        .addQueryParameter("apikey", "${MarvelApiConfig.publicKey}")
                                        .addQueryParameter("hash", "${MarvelApiConfig.hash}")
                                        .addQueryParameter("ts", "${MarvelApiConfig.ts}")
                                        .build()
                                chain.proceed(chain.request().newBuilder().url(url).build())
                            }
                            .build()
            )
            .addConverterFactory(GsonConverterFactory.create(gsonCharacterDeserializer))
            .build()

    private val retrofitComic: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val url = chain
                        .request()
                        .url()
                        .newBuilder()
                        .addQueryParameter("apikey", "${MarvelApiConfig.publicKey}")
                        .addQueryParameter("hash", "${MarvelApiConfig.hash}")
                        .addQueryParameter("ts", "${MarvelApiConfig.ts}")
                        .build()
                    chain.proceed(chain.request().newBuilder().url(url).build())
                }
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create(gsonComicDeserializer))
        .build()


    fun getInstance() : MarvelApi? {
        return retrofit.create(MarvelApi::class.java)
    }

    fun getInstanceComic() : MarvelApi? {
        return retrofitComic.create(MarvelApi::class.java)
    }
}