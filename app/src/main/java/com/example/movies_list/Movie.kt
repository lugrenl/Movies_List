package com.example.movies_list

import android.os.Parcel
import android.os.Parcelable

class Movie : Parcelable {
    // Геттеры
    val id: Int
    @JvmField
    val poster: Int
    @JvmField
    val ageLimit: String?
    @JvmField
    val rating: Float
    @JvmField
    val genre: String?
    @JvmField
    val title: String?

    constructor(
        id: Int,
        poster: Int,
        ageLimit: String?,
        rating: Float,
        genre: String?,
        title: String?
    ) {
        this.id = id
        this.poster = poster
        this.ageLimit = ageLimit
        this.rating = rating
        this.genre = genre
        this.title = title
    }

    constructor(`in`: Parcel) {
        id = `in`.readInt()
        poster = `in`.readInt()
        ageLimit = `in`.readString()
        rating = `in`.readFloat()
        genre = `in`.readString()
        title = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeInt(poster)
        dest.writeString(ageLimit)
        dest.writeFloat(rating)
        dest.writeString(genre)
        dest.writeString(title)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Movie?> = object : Parcelable.Creator<Movie?> {
            override fun createFromParcel(`in`: Parcel): Movie {
                return Movie(`in`)
            }

            override fun newArray(size: Int): Array<Movie?> {
                return arrayOfNulls(size)
            }
        }
    }
}