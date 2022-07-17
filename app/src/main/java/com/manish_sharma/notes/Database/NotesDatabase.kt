package com.manish_sharma.notes.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.manish_sharma.notes.Dao.NotesDao
import com.manish_sharma.notes.Model.Notess
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import java.security.AccessControlContext
@Database(entities = [Notess::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun myNotesDao(): NotesDao

    companion object {
        @Volatile
        var INSTANCE :NotesDatabase?=null

        fun getDatabaseInstance(context: Context):NotesDatabase{
            var tempInstace= INSTANCE
            if(tempInstace!=null){
                     return tempInstace
            }
          kotlin.synchronized(this){
              val roomDatabaseInstance = Room.databaseBuilder(context,NotesDatabase::class.java,"Notes").allowMainThreadQueries().build()
              INSTANCE = roomDatabaseInstance
              return return roomDatabaseInstance
          }
        }
    }

}