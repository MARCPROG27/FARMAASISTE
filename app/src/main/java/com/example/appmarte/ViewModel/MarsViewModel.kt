package com.example.appmarte.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.appmarte.Local.MarsDatabase
import com.example.appmarte.Model.Remote.MarsRealState
import com.example.appmarte.Model.Remote.MarsRepository
import kotlinx.coroutines.launch


class MarsViewModel (application: Application): AndroidViewModel(application){
    ////////// PARTEN 1//////////////////////////////////////
    private val repository : MarsRepository



    //PARTE 2
    lateinit var liveDatafromInternet : LiveData<List<MarsRealState>>

    // para mostrar lo que se esta recibiendo
    val allTask : LiveData<List<MarsRealState>>



    init{
        val MarsDao = MarsDatabase.getDataBase(application).getMarsDao()
        repository = MarsRepository(MarsDao)
        // PARTE 1

        // PARTE 2

        viewModelScope.launch {
            // PARTE 1
            //    liveDatafromInternet = repository.fetchDataMars
            // PARTE 2
            repository.fetchDataFromInternetCoroutines()
        }
        allTask= repository.listAllTask
        liveDatafromInternet = repository.dataFromInternet

    }

    // funcion para selecccionar
    // guardarmos la selecciona en una mutableLiveData
    private var selectedMarsTerrain: MutableLiveData<MarsRealState> = MutableLiveData()

    // Ocupamos una función  y tomamos la posiciona seleccionada
    fun selected(mars :MarsRealState){
        selectedMarsTerrain.value = mars
    }

    fun selectedItem(): LiveData<MarsRealState> = selectedMarsTerrain


    // funciones para insertar

    fun insertTask ( task : MarsRealState)= viewModelScope.launch {
        repository.insertTask(task)
    }

    fun updateTask ( task : MarsRealState)= viewModelScope.launch {
        repository.updateTask(task)
    }


//    fun getTaskById(id:Int): LiveData<MarsRealState>{
//        return  repository.getTaskById(id)
//    }


}