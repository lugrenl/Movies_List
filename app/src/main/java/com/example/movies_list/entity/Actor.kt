package com.example.movies_list.entity

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Actor(
    val name: String,
    @param:DrawableRes val photo: Int
) : Parcelable