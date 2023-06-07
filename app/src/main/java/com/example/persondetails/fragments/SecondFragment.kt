package com.example.persondetails.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.persondetails.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    lateinit var binding: FragmentSecondBinding
    private val args : SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)


        binding.Userid.text = args.Data.id.toString()
        binding.userTitle.text = args.Data.title
        binding.userbody.text = args.Data.body


        binding.openWhatswep.setOnClickListener {
            val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
            startActivity(intent)
            Toast.makeText(context, "WhatsApp Launched.", Toast.LENGTH_SHORT).show()
        }

        fun onAccessibilityEvent(event: AccessibilityEvent) {
            if (event.packageName == "com.whatsapp") {
                val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                startActivity(intent)
                Toast.makeText(context, "WhatsApp Launched.", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }
    }