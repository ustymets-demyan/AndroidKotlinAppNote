package com.example.androidkotlinappnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.androidkotlinappnote.database.NoteDatabase
import com.example.androidkotlinappnote.repository.NoteRepository
import com.example.androidkotlinappnote.viewmodel.NoteViewModel
import com.example.androidkotlinappnote.viewmodel.NoteViewModelFactory
import java.util.*

class MainActivity : AppCompatActivity (){

    lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.elevation = 0f
        setupViewModel()

    }


    private fun setupViewModel()
    {
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory = NoteViewModelFactory(application, noteRepository)
        noteViewModel = ViewModelProvider(this , viewModelProviderFactory)[NoteViewModel::class.java]
    }
}