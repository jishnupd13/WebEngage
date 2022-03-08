package com.app.webengage.ui.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.webengage.R
import com.app.webengage.databinding.FragmentRegisterBinding
import com.app.webengage.localdatabaseservice.entities.PersonEntity
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register), View.OnClickListener {

    private val binding: FragmentRegisterBinding by viewBinding()
    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listener = this
        binding.viewModel = viewModel
        observeRegister()
        observePersonLiveData()
        viewModel.fetchPersonList()
    }

    private fun observePersonLiveData(){
        viewModel.fetchPersonListLiveData.observe(viewLifecycleOwner,{
            it.map {
                Timber.e("${it.fName} ${it.email}")
            }
        })
    }

    private fun observeRegister(){
        viewModel.insertPersonLiveData.observe(viewLifecycleOwner,{
            findNavController().navigateUp()
        })
    }

    override fun onClick(view: View?) {

        when (view) {

            binding.imageBack->{
                findNavController().navigateUp()
            }

            binding.btnRegister -> {

                val f_name = binding.editTextFirstName.text.toString()
                val l_name = binding.editTextLastName.text.toString()
                val email = binding.editTextEmail.text.toString()
                val phone = binding.editTextPhoneNumber.text.toString()
                val password = binding.editTextPassword.text.toString()

                Timber.e("hello 9990 ${generateWebEngageId()}")

                viewModel.insertPersonEntity(
                    PersonEntity(
                        fName = f_name,
                        lName = l_name,
                        email = email,
                        phone = phone,
                        password = password,
                        webEngageId = generateWebEngageId()
                    )
                )
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun generateWebEngageId():String{
        val sdf = SimpleDateFormat("yyyyMMddHHmmss")
        return "Web${sdf.format(Date())}"
    }
}