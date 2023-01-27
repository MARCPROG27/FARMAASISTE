package com.example.appmarte.UI

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.appmarte.ViewModel.MarsViewModel
import com.example.appmarte.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

private lateinit var _binding: FragmentSecondBinding
private val viewModel : MarsViewModel by activityViewModels()
    var idMars: String= ""
    var telefonocontacto: String=""
    var mifarmacia: String=""
    var direccionfarmacia: String=""

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idMars = it.getString("localid","")
        }









    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        return _binding.root




        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }

        viewModel.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                val fechaapertura: String
                val fechacierre: String


//                Glide.with(_binding.ivTerrain)
//                    .load(it.img_Src).centerCrop().into(_binding.ivTerrain)
//                _binding.tvPrice.text= it.price.toString()+" DOLARES"
//                _binding.tvType.text = it.type
//
//                Toast.makeText(context, "${it.price} + ${it.type}", Toast.LENGTH_SHORT).show()


                fechaapertura=it.horaapertura.toString()
                fechacierre=it.horacierre.toString()


                _binding.txtdetallefarmacia.text = it.localnombre.toString()
                _binding.txtdirecciondet.text = it.localdireccion.toString()
                _binding.txthorario.text = " APERTURA: $fechaapertura  CIERRE: $fechacierre"
                _binding.txttelefono.text = it.localtelefono.toString()
                _binding.txtcomunad.text=it.comunanombre.toString()


                //VARIABLES ALMACENARAN DOMICILIO Y NOMBRE FARMACIA

                mifarmacia=it.localnombre.toString()
                direccionfarmacia=it.localdireccion.toString()

                //LATITUD Y LONGITUD DE LA FARMACIA
                val latitud: Double
                val longitud: Double


              latitud = (it.latitud.toDouble())
               longitud = (it.longitud.toDouble())

               _binding.vistaweb.webViewClient = WebViewClient()



               _binding.vistaweb.loadUrl("https://www.google.cl/maps/@$latitud,$longitud,19z")

                _binding.vistaweb.settings.javaScriptEnabled = true

                _binding.vistaweb.settings.setSupportZoom(true)

//                telefonocontacto=it.localtelefono




            }




        })

        _binding.btnatrasf.setOnClickListener{
           // findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
           // findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

            val i = Intent(Intent.ACTION_CALL)
            i.data = Uri.parse("tel: $telefonocontacto ")
            startActivity(i)
        }

       _binding.floatingActionButton.setOnClickListener {
           val email = "promass4000@gmail.com"
           val intentEmail = Intent(Intent.ACTION_SEND, Uri.parse(email))
           intentEmail.type = "plain/text"
           intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Farmacia $mifarmacia DIRECCION: $direccionfarmacia")
           intentEmail.putExtra(Intent.EXTRA_TEXT, "Hola, estoy interesado(a) en recibie en mi correo, ofertas de su farmacia como también despacho de medicamentos a futuro.Gracias desde ya.")
           intentEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf("gesalas@gmail.com"))
           startActivity(Intent.createChooser(intentEmail, "Elige cliente de correo"))
           Toast.makeText(context, "SU MENSAJE FUE ENVIADO A LA FARMACIA RESPECTIVA", Toast.LENGTH_SHORT).show()
       }
//















    }


}