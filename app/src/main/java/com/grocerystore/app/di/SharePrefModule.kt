package com.grocerystore.app.di

import android.content.Context
import android.content.SharedPreferences
import com.grocerystore.app.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharePrefModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            context.getString(R.string.sync_status_pref_name),
            Context.MODE_PRIVATE
        )
}
