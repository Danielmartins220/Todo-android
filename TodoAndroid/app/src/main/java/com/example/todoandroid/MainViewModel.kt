package com.example.todoandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoandroid.api.Repository
import com.example.todoandroid.model.Categoria
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel(){


    private val _myCategoriaRespose =
        MutableLiveData<Response<List<Categoria>>>()

        val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
            _myCategoriaRespose

        init {
            //listCategoria()
        }


        fun listCategoria(){
            viewModelScope.launch {
                try{

                    val response = repository.listCategoria()
                    _myCategoriaRespose.value = response


                }catch (e: Exception){
                    Log.d("Erro", e.message.toString())
                }
            }
        }
}


