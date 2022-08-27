package dev.shreyansh.shoestore.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dev.shreyansh.shoestore.R
import dev.shreyansh.shoestore.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {

    private lateinit var binding : FragmentSignupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.hide()
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_signup, container, false)
        return binding.root
    }


}