package com.example.pta.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.pta.SearchActivity
import com.example.pta.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val packageName = "com.tms"
        val packageManager = requireContext().packageManager
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        val intentPlaystore = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))

        binding.membershipButton.setOnClickListener {
            try {
                startActivity(intent)
            } catch (e: Exception) {
                startActivity(intentPlaystore)
            }
        }
            binding.searchButton.setOnClickListener {
                val intent = Intent(getActivity(), SearchActivity::class.java)
                startActivity(intent)
            }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}