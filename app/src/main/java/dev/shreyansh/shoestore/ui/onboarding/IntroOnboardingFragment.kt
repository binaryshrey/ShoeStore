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
import dev.shreyansh.shoestore.databinding.FragmentIntroOnboardingBinding
import dev.shreyansh.shoestore.viewmodel.ShoeViewModel

class IntroOnboardingFragment : Fragment() {

    private lateinit var binding : FragmentIntroOnboardingBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.title = "Instructions (1/2)"

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_intro_onboarding, container, false)
        binding.introOnboardViewModel = viewModel

        viewModel.introOnboarding.observe(viewLifecycleOwner) {introCompleted ->
            if(introCompleted){
                viewModel.onIntroOnboardingComplete()
                findNavController().navigate(R.id.action_introOnboardingFragment_to_outroOnboardingFragment)
            }
        }

        return binding.root
    }

}