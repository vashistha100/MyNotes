package com.manish_sharma.notes.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.manish_sharma.notes.Database.NotesDatabase
import com.manish_sharma.notes.Model.Notess
import com.manish_sharma.notes.Repositories.NotesRepository

class NotesViewModel(application: Application):AndroidViewModel(application) {
    val repository:NotesRepository
    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository= NotesRepository(dao)
    }
    fun addNotes(notes:Notess){
        repository.insertNotes(notes)
    }
    fun getNotes():LiveData<List<Notess>> = repository.getAllnotes()
    fun getHighNotes():LiveData<List<Notess>>{
        return repository.getHighNotes()
    }
    fun getMediumNotes():LiveData<List<Notess>>{
        return repository.getMediumNotes()
    }
    fun getLowNotes():LiveData<List<Notess>> = repository.getLowNotes()
    fun deleteNotes(id:Int){
        repository.deleteNotes(id)
    }
    fun updateNotes(notes: Notess){
        repository.updateNotes(notes)
    }

}