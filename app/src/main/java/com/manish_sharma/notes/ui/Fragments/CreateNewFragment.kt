package com.manish_sharma.notes.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.manish_sharma.notes.Model.Notess
import com.manish_sharma.notes.R
import com.manish_sharma.notes.ViewModel.NotesViewModel
import com.manish_sharma.notes.databinding.FragmentCreateNewBinding

import java.util.*

// TODO: Rename parameter arguments, choose names that match

class CreateNewFragment : Fragment() {

    lateinit var binding: FragmentCreateNewBinding
    var priority:String="1"
    val viewModel:NotesViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNewBinding.inflate(layoutInflater, container, false)
        binding.PriorityGreen.setImageResource(R.drawable.ic_baseline_done_24)

     binding.btnSaveNotes.setOnClickListener {
         createNotes(it)
     }
       binding.PriorityGreen.setOnClickListener {
           priority="1"
           binding.PriorityGreen.setImageResource(R.drawable.ic_baseline_done_24)
           binding.PriorityRed.setImageResource(0)
           binding.PriorityYellow.setImageResource(0)
       }
        binding.PriorityYellow.setOnClickListener {
            priority="2"
            binding.PriorityYellow.setImageResource(R.drawable.ic_baseline_done_24)
            binding.PriorityRed.setImageResource(0)
            binding.PriorityGreen.setImageResource(0)
        }
        binding.PriorityRed.setOnClickListener {
            priority="3"
            binding.PriorityRed.setImageResource(R.drawable.ic_baseline_done_24)
            binding.PriorityGreen.setImageResource(0)
            binding.PriorityYellow.setImageResource(0)
        }

        return binding.root
    }

    private fun createNotes(it: View?) {
            val title=binding.edittitle.text.toString()
            val subtitle=binding.EditSubtitle.text.toString()
           val notes = binding.EditNotes.text.toString()
        val d = Date()
        val notesDate: CharSequence= DateFormat.format("MMM d,yyyyy ",d.getTime()).toString()

        val data =Notess(null, title = title, subTitle = subtitle,notes=notes, date = notesDate.toString(),  priority)
        viewModel.addNotes(data)
        Toast.makeText(requireContext(), " Note added", Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
       /* Navigation.findNavController(it!!).navigate(R.id.action_createNewFragment2_to_homeFragment)*/
    }


}