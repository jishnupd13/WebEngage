package com.app.webengage.ui.home

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.webengage.R
import com.app.webengage.databinding.FragmentHomeBinding
import com.app.webengage.preferences.PreferenceHandler
import com.webengage.sdk.android.Analytics
import com.webengage.sdk.android.User
import com.webengage.sdk.android.WebEngage
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by viewModels()
    private var weUser: User? = null
    private var weAnalytics: Analytics? = null
    private var firstName = ""
    private var lastName = ""
    private var email = ""


    @Inject
    lateinit var preferenceHandler: PreferenceHandler

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        weUser = WebEngage.get().user()
        observePersonById()
        viewModel.fetchPersonByWebEngageId(preferenceHandler.webEngageId)

        weAnalytics = WebEngage.get().analytics()
        binding.textClickEventUser.setOnClickListener {
            val addedToCartAttributes: MutableMap<String, Any> = HashMap()
            addedToCartAttributes["First Name"] = firstName
            addedToCartAttributes["Last Name"] = lastName
            addedToCartAttributes["Email"] = email
            weAnalytics?.track("ClickPersonEvent", addedToCartAttributes)
        }

        binding.textLogOut.setOnClickListener {
            weUser?.logout()
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())
        }
    }

    private fun observePersonById() {
        viewModel.fetchPersonByWebEngageIdLiveData.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                firstName = it[0].fName
                lastName = it[0].lName
                email = it[0].email
                if (!preferenceHandler.userDetailsInitialized) {
                    weUser?.setFirstName(it[0].fName)
                    weUser?.setLastName(it[0].lName)
                    weUser?.setEmail(it[0].email)
                    preferenceHandler.userDetailsInitialized = true
                }
            }
        })
    }
}