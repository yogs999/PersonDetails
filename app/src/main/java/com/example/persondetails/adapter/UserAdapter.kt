package com.example.persondetails.adapter


import android.content.Context

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.persondetails.databinding.UserTitleBinding
import com.example.persondetails.fragments.FirstFragmentDirections
import com.example.persondetails.model.UserDataItem


class UserAdapter(val context: Context, val Info : List<UserDataItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(var binding: UserTitleBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(UserTitleBinding.inflate(LayoutInflater.from(context), parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resultdata = Info[position]

        holder.binding.getTitle.text = resultdata.title
        holder.binding.Detailsget.setOnClickListener {
            val newResult = FirstFragmentDirections.actionFirstFragmentToSecondFragment(resultdata)
            Navigation.findNavController(it).navigate(newResult)
        }
    }
    override fun getItemCount(): Int {
        return Info.size
    }
}