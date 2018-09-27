package br.com.lucasfranco.testeml.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

            fun getClient(): Retrofit {

                val builder = OkHttpClient.Builder()

                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                builder.addInterceptor(loggingInterceptor)

                return Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(builder.build()).build()
            }
        }

}