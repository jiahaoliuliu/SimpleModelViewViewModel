package com.jiahaoliuliu.simplemodelviewviewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory

class UserProfileFragment : Fragment() {
    // To use the viewModels() extension function, include "androidx.fragment:fragment-ktx:latest-version"
    // in your app module's build.gradle file
    private val viewModel: UserProfileViewModel by viewModels(
        factoryProducer = {SavedStateViewModelFactory(this)}
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {
            // Update UI
        }
    }
}