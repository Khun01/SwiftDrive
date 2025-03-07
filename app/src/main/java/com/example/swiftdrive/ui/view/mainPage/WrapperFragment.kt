package com.example.swiftdrive.ui.view.mainPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.swiftdrive.R
import com.example.swiftdrive.databinding.FragmentWrapperBinding

class WrapperFragment : Fragment() {
    private lateinit var binding: FragmentWrapperBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWrapperBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment = childFragmentManager.findFragmentById(R.id.mainFragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id){
                R.id.twoFactorAuthPageFragment, R.id.twoFactoAuthOtpFragment, R.id.twoFactorAuthCompletedFragment -> {
                    binding.bottomNavigationView.visibility = View.GONE
                    binding.v1.visibility = View.GONE
                    binding.toolbar.visibility = View.GONE
                }
                R.id.profilePageFragment -> {
                    binding.bottomNavigationView.visibility = View.VISIBLE
                    binding.toolbar.visibility = View.GONE
                    binding.v1.visibility = View.GONE
                }else -> {
                    binding.bottomNavigationView.visibility = View.VISIBLE
                    binding.toolbar.visibility = View.VISIBLE
                    binding.v1.visibility = View.VISIBLE
                }
            }
        }
    }
}