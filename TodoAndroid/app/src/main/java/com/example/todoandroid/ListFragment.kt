package com.example.todoandroid

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Layout
import android.util.Log.i
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoandroid.adapter.TarefaAdapter
import com.example.todoandroid.databinding.FragmentListBinding
import com.example.todoandroid.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ListFragment : Fragment() {


    private lateinit var binding: FragmentListBinding


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)


        val adapter = TarefaAdapter()
        binding.RecyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.RecyclerTarefa.adapter = adapter
        binding.RecyclerTarefa.setHasFixedSize(true)



        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        binding.RecyclerTarefa

        return binding.root

    }
}