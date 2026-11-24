package com.grocerystore.app.utilities

import com.grocerystore.app.BuildConfig

object SupabaseHelper {

    fun buildImageUrl(imageKey: String): String {
        val storageUrl = "${BuildConfig.SUPABASE_URL}/storage/v1/object/public"
        return "$storageUrl/$imageKey"
    }

}