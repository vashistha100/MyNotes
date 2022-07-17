package com.manish_sharma.notes.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.manish_sharma.notes.R
import com.manish_sharma.notes.ViewModel.NotesViewModel
import com.manish_sharma.notes.databinding.FragmentHomeBinding
import com.manish_sharma.notes.ui.Adapter.NotesAdapter


class HomeFragment : Fragment() {


    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel.getNotes().observe(viewLifecycleOwner, { notesList ->
            val staggeredGridLayoutManager=StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            binding.rcAllNotes.layoutManager=staggeredGridLayoutManager
            binding.rcAllNotes.adapter=NotesAdapter(requireContext(),notesList)
            }
            )
        binding.filterHigh.setOnClickListener {
            viewModel.getHighNotes().observe(viewLifecycleOwner, { notesList ->
                val staggeredGridLayoutManager=StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
                binding.rcAllNotes.layoutManager=staggeredGridLayoutManager
                binding.rcAllNotes.adapter=NotesAdapter(requireContext(),notesList)
            }
            )
        }

        binding.filterLow.setOnClickListener {
            viewModel.getLowNotes().observe(viewLifecycleOwner, { notesList ->
                val staggeredGridLayoutManager=StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
                binding.rcAllNotes.layoutManager=staggeredGridLayoutManager
                binding.rcAllNotes.adapter=NotesAdapter(requireContext(),notesList)
            }
            )
        }

        binding.filterMedium.setOnClickListener {
            viewModel.getMediumNotes().observe(viewLifecycleOwner, { notesList ->
                val staggeredGridLayoutManager=StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
                binding.rcAllNotes.layoutManager=staggeredGridLayoutManager
                binding.rcAllNotes.adapter=NotesAdapter(requireContext(),notesList)
            }
            )
        }
        binding.filterAllNotes.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner, { notesList ->
                val staggeredGridLayoutManager=StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
                binding.rcAllNotes.layoutManager=staggeredGridLayoutManager
                binding.rcAllNotes.adapter=NotesAdapter(requireContext(),notesList)
            }
            )
        }











            binding.btnAddNotes.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_homeFragment_to_createNewFragment2)

            }



            return binding.root

        }}



