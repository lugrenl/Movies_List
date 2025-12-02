package com.example.movies_list

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    @DrawableRes val poster: Int,
    val ageLimit: String,
    val rating: Float,
    val genre: String,
    val title: String,
    val description: String,
    val actors: List<Actor>
) : Parcelable