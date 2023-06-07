package com.example.persondetails.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.persondetails.model.UserDataItem


@Dao
interface UserDao {

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun InsertUser(userItem:List<UserDataItem>)

    @Query("select * from UserDemo")
    fun GetAll() : LiveData<List<UserDataItem>>

}