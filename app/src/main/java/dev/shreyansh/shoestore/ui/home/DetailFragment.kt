package dev.shreyansh.shoestore.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dev.shreyansh.shoestore.R
import dev.shreyansh.shoestore.databinding.FragmentDetailBinding
import dev.shreyansh.shoestore.viewmodel.ShoeViewModel

class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private val viewModel : ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)
        binding.detailViewModel = viewModel
        viewModel.submitShoe.observe(viewLifecycleOwner) {addedShoe ->
            if(addedShoe){
                viewModel.onSubmitShoeComplete()
                findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
            }
        }
        return binding.root
    }

}