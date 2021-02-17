package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructorBinding
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.ViewShoesBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoesViewModel
import kotlinx.android.synthetic.main.fragment_shoes_list.*
import kotlinx.android.synthetic.main.view_shoes.view.*


class ShoesListFragment : Fragment() {
    val shoesViewmodel: ShoesViewModel by activityViewModels()

    lateinit var binding: FragmentShoesListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoes_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_newShoesFragment)
        }
        shoesViewmodel.shoesData.observe(viewLifecycleOwner, Observer {
            it.forEach {
                addView(it)
            }
        })
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoesListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    private fun addView(shoes:Shoe?){
        val myLayout: LinearLayout = lnShoesView
        val view = DataBindingUtil.inflate<ViewShoesBinding>(layoutInflater,R.layout.view_shoes,myLayout,false)
        view.root.setLayoutParams(
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
        )
        view.root.apply {
            tvCompany.text = shoes?.company
            tvNameShoes.text = shoes?.name
            tvSize.text = shoes?.size.toString()
            tvDescription.text = shoes?.description
        }

        myLayout.addView(view.root)
    }
}