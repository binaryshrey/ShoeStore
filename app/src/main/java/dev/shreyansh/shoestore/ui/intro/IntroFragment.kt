package dev.shreyansh.shoestore.ui.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import dev.shreyansh.shoestore.R
import dev.shreyansh.shoestore.databinding.FragmentIntroBinding
import dev.shreyansh.shoestore.viewmodel.ShoeViewModel


class IntroFragment : Fragment() {

    private lateinit var binding: FragmentIntroBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.hide()
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_intro, container, false)
        binding.viewModel = viewModel

        viewModel.getStarted.observe(viewLifecycleOwner) { hasStarted ->
            if (hasStarted) {
                viewModel.onGetStartedComplete()
                findNavController().navigate(R.id.action_introFragment_to_signupFragment)
            }
        }

        return binding.root
    }
}