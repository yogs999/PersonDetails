package com.example.persondetails.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.persondetails.MainApplication
import com.example.persondetails.adapter.UserAdapter
import com.example.persondetails.databinding.FragmentFirstBinding
import com.example.persondetails.viewmodel.UserModelfactory
import com.example.persondetails.viewmodel.UserViewModel

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        val repo = (activity?.applicationContext as MainApplication).userRepo

        userViewModel =
            ViewModelProvider(this, UserModelfactory(repo)).get(UserViewModel::class.java)


        userViewModel.getAll().observe(viewLifecycleOwner, Observer { it ->

            userAdapter = UserAdapter(requireContext(), it)
            binding.userRecycler.adapter = userAdapter
            binding.userRecycler.layoutManager = LinearLayoutManager(context)
            binding.userRecycler.setHasFixedSize(true)
        })

        return binding.root
    }
}

