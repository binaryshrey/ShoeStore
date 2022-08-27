package dev.shreyansh.shoestore.ui.login

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
import dev.shreyansh.shoestore.databinding.FragmentLoginBinding
import dev.shreyansh.shoestore.viewmodel.ShoeViewModel


class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.hide()
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)
        binding.loginViewModel = viewModel

        viewModel.getStarted.observe(viewLifecycleOwner) { hasStarted ->
            if (hasStarted) {
                viewModel.onGetStartedComplete()
                findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
            }
        }
        viewModel.login.observe(viewLifecycleOwner) { loggedIn ->
            if (loggedIn) {
                viewModel.onLoginComplete()
                //findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
            }
        }

        return binding.root
        return binding.root
    }

}