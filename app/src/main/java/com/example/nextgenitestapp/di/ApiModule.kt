package com.example.nextgenitestapp.di

import com.example.nextgenitestapp.data.ProductAppService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request().newBuilder().addHeader("Authorization", "Bearer 14028_J8g1GvFLkNOl31pBM3J8enLJKQcFLSJM").build()
                chain.proceed(request)
            }.build())
            .build()
    }

    @Provides
    @Singleton
    fun provideProductsService(retrofit: Retrofit): ProductAppService {
        return retrofit.create(ProductAppService::class.java)
    }
}