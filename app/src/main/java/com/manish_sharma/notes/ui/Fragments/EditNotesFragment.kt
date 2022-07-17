package com.manish_sharma.notes.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.manish_sharma.notes.Model.Notess
import com.manish_sharma.notes.R
import com.manish_sharma.notes.ViewModel.NotesViewModel
import com.manish_sharma.notes.databinding.FragmentEditNotesBinding
import java.util.*

class EditNotesFragment : Fragment() {

    var priority: String = "1"
    val viewModel: NotesViewModel by viewModels()
    val Oldnotes by navArgs<EditNotesFragmentArgs>()
    lateinit var binding: FragmentEditNotesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding = FragmentEditNotesBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)

        binding.EditTitle.setText(Oldnotes.data.title)
        binding.EditSubtitle.setText(Oldnotes.data.subTitle)
        binding.EditNotes.setText(Oldnotes.data.notes)
        when (Oldnotes.data.priority) {
            "1" -> {
                priority = "1"
                binding.PriorityGreen.setImageResource(R.drawable.ic_baseline_done_24)
                binding.PriorityRed.setImageResource(0)
                binding.PriorityYellow.setImageResource(0)
            }
            "2" -> {
                priority = "2"
                binding.PriorityYellow.setImageResource(R.drawable.ic_baseline_done_24)
                binding.PriorityRed.setImageResource(0)
                binding.PriorityGreen.setImageResource(0)
            }
            "3" -> {
                priority = "3"
                binding.PriorityRed.setImageResource(R.drawable.ic_baseline_done_24)
                binding.PriorityGreen.setImageResource(0)
                binding.PriorityYellow.setImageResource(0)
            }
        }

        binding.PriorityGreen.setOnClickListener {
            priority = "1"
            binding.PriorityGreen.setImageResource(R.drawable.ic_baseline_done_24)
            binding.PriorityRed.setImageResource(0)
            binding.PriorityYellow.setImageResource(0)
        }
        binding.PriorityYellow.setOnClickListener {
            priority = "2"
            binding.PriorityYellow.setImageResource(R.drawable.ic_baseline_done_24)
            binding.PriorityRed.setImageResource(0)
            binding.PriorityGreen.setImageResource(0)
        }
        binding.PriorityRed.setOnClickListener {
            priority = "3"
            binding.PriorityRed.setImageResource(R.drawable.ic_baseline_done_24)
            binding.PriorityGreen.setImageResource(0)
            binding.PriorityYellow.setImageResource(0)
        }

        binding.btnEditSaveNotes.setOnClickListener {
            updateNote(it)
        }



        return binding.root
    }

    private fun updateNote(it: View?) {
        val title = binding.EditTitle.text.toString()
        val subtitle = binding.EditSubtitle.text.toString()
        val notes = binding.EditNotes.text.toString()
        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMM d,yyyyy ", d.getTime()).toString()

        val data = Notess(
            Oldnotes.data.id,
            title = title,
            subTitle = subtitle,
            notes = notes,
            date = notesDate.toString(),
            priority
        )
        viewModel.updateNotes(data)
        Toast.makeText(requireContext(), "Updated Successfully", Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()
      /*  Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)*/
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_delete, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(requireContext())
            bottomSheetDialog.setContentView(R.layout.dialog_delete)
            bottomSheetDialog.show()
            val btnYes = bottomSheetDialog.findViewById<TextView>(R.id.dialog_yes)
            val btnNo = bottomSheetDialog.findViewById<TextView>(R.id.dialog_no)
            btnNo?.setOnClickListener {
                bottomSheetDialog.dismiss()
            }
            btnYes?.setOnClickListener {
                viewModel.deleteNotes(Oldnotes.data.id!!)
                // Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)
                Toast.makeText(requireContext(), "Successfully Deleted", Toast.LENGTH_SHORT).show()
                bottomSheetDialog.dismiss()
                findNavController().popBackStack()
            }

            bottomSheetDialog.show()
        }
        return super.onOptionsItemSelected(item)
    }


}



