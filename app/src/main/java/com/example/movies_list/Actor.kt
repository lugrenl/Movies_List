package com.example.movies_list

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Actor(
    val name: String,
    @DrawableRes val photo: Int
) : Parcelable
