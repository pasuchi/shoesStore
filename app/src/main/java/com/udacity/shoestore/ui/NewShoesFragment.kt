package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentNewShoesBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoesViewModel
import kotlinx.android.synthetic.main.fragment_new_shoes.*

class NewShoesFragment : Fragment() {
    val shoesViewmodel: ShoesViewModel by activityViewModels()
    private lateinit var binding: FragmentNewShoesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_shoes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_save.setOnClickListener {
            shoesViewmodel.insertShoesData(
                Shoe(
                    edt_name_shoes.text.toString(),
                    edt_shoes_size.text.toString().toDoubleOrNull() ?: 0.0,
                    edt_company.text.toString(),
                    edt_description.text.toString()
                )
            )
            Navigation.findNavController(it).navigate(R.id.action_popback_shoesListFragment)
        }
        btn_cancel.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_popback_shoesListFragment)

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewShoesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}