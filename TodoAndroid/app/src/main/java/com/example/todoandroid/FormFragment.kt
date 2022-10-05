package com.example.todoandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.todoandroid.databinding.FragmentListBinding
import com.example.todoandroid.model.Categoria

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FormFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FormFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        mainViewModel.listCategoria()

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
           response -> Log.d("Requisicao", response.body().toString())
            spinnerCategoria(response.body())
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_formFragment_to_listFragment2)
        }

        return binding.root
    }

     fun spinnerCategoria(listCategoria: List<Categoria>?){
         if (listCategoria != null ){
             binding.spinnerCategoria.adapter =
                 ArrayAdapter(
                     requireContext(),
                     androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                     listCategoria


                 )
         }
     }
    }

