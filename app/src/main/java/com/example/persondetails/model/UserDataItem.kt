package com.example.persondetails.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "UserDemo")
@Parcelize
data class UserDataItem(
    var body: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String
) : Parcelable