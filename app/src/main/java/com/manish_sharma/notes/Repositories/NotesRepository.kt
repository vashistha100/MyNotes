package com.manish_sharma.notes.Repositories

import androidx.lifecycle.LiveData
import com.manish_sharma.notes.Dao.NotesDao
import com.manish_sharma.notes.Model.Notess

class NotesRepository(val dao: NotesDao) {
    fun getAllnotes():LiveData<List<Notess>>{
        return dao.getNotes()
    }
    fun getHighNotes():LiveData<List<Notess>>{
        return dao.getHighNotes()
    }
    fun getMediumNotes():LiveData<List<Notess>>{
        return dao.getMediumNotes()
    }
    fun getLowNotes():LiveData<List<Notess>> = dao.getLowNotes()
    fun insertNotes(notess: Notess){
        dao.insertData(notess)
    }
    fun deleteNotes(id:Int){
        dao.deleteData(id)
    }
    fun updateNotes(notess: Notess){
        dao.updatetData( notess)
    }
}