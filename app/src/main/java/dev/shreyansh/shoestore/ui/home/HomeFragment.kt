package dev.shreyansh.shoestore.ui.home

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import dev.shreyansh.shoestore.R
import dev.shreyansh.shoestore.databinding.FragmentHomeBinding
import dev.shreyansh.shoestore.viewmodel.ShoeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe Store"

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.homeViewModel = viewModel
        viewModel.addShoe.observe(viewLifecycleOwner) {addedShoe ->
            if (addedShoe){
                viewModel.onAddShoeComplete()

            }
        }
        setHasOptionsMenu(true)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about -> Toast.makeText(context,"About", Toast.LENGTH_SHORT).show()
            R.id.logout -> Toast.makeText(context,"Log out", Toast.LENGTH_SHORT).show()

        }
        return super.onOptionsItemSelected(item)
    }
}