package com.manish_sharma.notes.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.manish_sharma.notes.Model.Notess

@Dao
interface NotesDao {
    @Query("SELECT * FROM Notes")
    fun getNotes(): LiveData<List<Notess>>

    @Query("SELECT * FROM Notes WHERE priority=3")
    fun getHighNotes(): LiveData<List<Notess>>

    @Query("SELECT * FROM Notes WHERE priority=2")
    fun getMediumNotes(): LiveData<List<Notess>>

    @Query("SELECT * FROM Notes WHERE priority=1")
    fun getLowNotes(): LiveData<List<Notess>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(notes: Notess)

    @Query("DELETE  FROM Notes WHERE id=:id")
    fun deleteData(id: Int)

    @Update
    fun updatetData(notes: Notess)

}