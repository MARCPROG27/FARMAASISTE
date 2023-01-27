package com.example.appmarte.Model.Remote

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



// SI QUIERE TRABAJAR CON COROUTINES ESTA CLASE QUEDA IGUAL
@Entity(tableName = "mars_table")
data class MarsRealState (

    @SerializedName("local_id")
    @PrimaryKey
    val localid: String,
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("local_nombre")
    val localnombre: String,
    @SerializedName("comuna_nombre")
    val comunanombre: String,
    @SerializedName("localidad_nombre")
    val localidadnombre: String,
    @SerializedName("local_direccion")
    val localdireccion: String,
    @SerializedName("funcionamiento_hora_apertura")
    val horaapertura: String,
    @SerializedName("funcionamiento_hora_cierre")
    val horacierre: String,
    @SerializedName("local_telefono")
    val localtelefono: String,
    @SerializedName("local_lat")
    val latitud: String,
    @SerializedName("local_lng")
    val longitud: String,
    @SerializedName("funcionamiento_dia")
    val funcionamientodia: String,
    @SerializedName("fk_region")
    val fkregion: String,
    @SerializedName("fk_comuna")
    val fkcomuna: String,
    @SerializedName("fk_localidad")
    val fklocalidad: String


    //============================================

//    @SerializedName("id")
//@PrimaryKey
//val id: Int,
//@SerializedName("name")
//val name: String,
//@SerializedName("price")
//val price: String






)