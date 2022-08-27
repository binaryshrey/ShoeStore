package dev.shreyansh.shoestore.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dev.shreyansh.shoestore.R
import dev.shreyansh.shoestore.databinding.FragmentOutroOnboardingBinding


class OutroOnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOutroOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.title = "Instructions (2/2)"

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_outro_onboarding, container, false)
        return binding.root

    }
}