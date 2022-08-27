package dev.shreyansh.shoestore.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dev.shreyansh.shoestore.R
import dev.shreyansh.shoestore.databinding.FragmentOutroOnboardingBinding
import dev.shreyansh.shoestore.viewmodel.ShoeViewModel


class OutroOnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOutroOnboardingBinding
    val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.title = "Instructions (2/2)"

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_outro_onboarding, container, false)
        binding.outroViewModel = viewModel

        viewModel.outroOnboarding.observe(viewLifecycleOwner) {outroCompleted ->
            if(outroCompleted){
                viewModel.onOutroOnboardingComplete()
                findNavController().navigate(R.id.action_outroOnboardingFragment_to_homeFragment)
            }
        }
        return binding.root

    }
}