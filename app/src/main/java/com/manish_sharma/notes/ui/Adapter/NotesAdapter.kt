package com.manish_sharma.notes.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.manish_sharma.notes.Model.Notess
import com.manish_sharma.notes.R
import com.manish_sharma.notes.databinding.ItemNotesBinding
import com.manish_sharma.notes.ui.Fragments.HomeFragmentDirections

class NotesAdapter(val requireContext: Context, val notesList: List<Notess>) :RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {
    class notesViewHolder(val binding: ItemNotesBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
return notesViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val position = notesList[position]
    holder.binding.NotesTitle.text=position.title
        holder.binding.NotesSubtitle.text=position.subTitle
        holder.binding.Notesdate.text=position.date

        when(position.priority){
            "1"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.green_dot_shape)
            }
            "2"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.yellow_dot_shape)
            }
            "3"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.red_dot_shape)
            }
        }

        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(position)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {

        return notesList.size

    }
}