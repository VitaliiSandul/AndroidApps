package com.example.dz_20210407_room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("select * from user")
    fun getAll() : List<User>

    @Query("select * from user where uid in (:userIds)")
    fun loadAllByIds(userIds: IntArray) : List<User>

    @Query("select * from user where first_name like :firstName and " +
            "last_name like :lastName limit 1")
    fun findByName(firstName: String, lastName: String) : User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

}