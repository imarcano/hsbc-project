package com.inbergmarcano.mycvapp.di.module

import android.app.Application
import android.provider.SyncStateContract
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.inbergmarcano.mycvapp.base.BaseApp
import com.inbergmarcano.mycvapp.di.scope.PerApplication
import com.inbergmarcano.mycvapp.rest.ResumeEndpoints
import com.inbergmarcano.mycvapp.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RestModule(private var baseApp: BaseApp) {

    @Provides
    @Singleton
    fun providesBaseUrl(): String{
        return Constants.BASE_URL
    }

    @Provides
    @Singleton
    fun providesGson(): Gson{
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideGsonConverter(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideHttpCache(application: BaseApp): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient().newBuilder().cache(cache)
            .addInterceptor(loggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        converter: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(converter)
            .build()
    }

    @Provides
    @Singleton
    fun provideResumeEndpoints(retrofit: Retrofit): ResumeEndpoints {
        return retrofit.create<ResumeEndpoints>(ResumeEndpoints::class.java)
    }
}