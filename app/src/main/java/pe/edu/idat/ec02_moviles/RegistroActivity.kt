package pe.edu.idat.ec02_moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import pe.edu.idat.ec02_moviles.databinding.ActivityRegistroBinding
import pe.edu.idat.ec02_moviles.util.AppMensaje
import pe.edu.idat.ec02_moviles.util.TipoMensaje

class RegistroActivity : AppCompatActivity(),View.OnClickListener{

    lateinit var binding: ActivityRegistroBinding
    private val listaPersonas =ArrayList<String>()
    private val listaCualidades =ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistroAcceder.setOnClickListener(this)
        binding.btnRegistroListar.setOnClickListener(this)

        binding.cbOtro.setOnClickListener(this)
        binding.cbPuntual.setOnClickListener(this)
        binding.cbRespetuoso.setOnClickListener(this)
        binding.cbResponsable.setOnClickListener(this)
    }
    fun validarDatosPersonales():Boolean{
        var respuesta=true

        if(binding.tvNombre.text.toString().trim().isEmpty()||
            binding.tvApellido.text.toString().trim().isEmpty()||
            binding.tvDni.text.toString().trim().isEmpty()||
            binding.tvCelular.text.toString().trim().isEmpty()||
            binding.tvEmail.text.toString().trim().isEmpty()
        )
            respuesta=false

        return respuesta
    }

    fun validarEstadoCivil():Boolean{
        var respuesta=true

        if (binding.rgEstadoCivil.checkedRadioButtonId==-1)
            respuesta=false

        return respuesta
    }

    fun validarCualidades():Boolean{
        var respuesta=false

        if(binding.cbOtro.isChecked || binding.cbPuntual.isChecked || binding.cbRespetuoso.isChecked || binding.cbResponsable.isChecked)
            respuesta=true

        return respuesta
    }

    fun validarFormulario():Boolean{
        var respuesta=false
        var mensaje=""

        if(!validarDatosPersonales()) mensaje="Verificar que se haya ingresado el nombre, apellido, dni, celular o email"
        else if(!validarCualidades()) mensaje="Verificar que se haya ingresado las cualidades"
        else if(!validarEstadoCivil()) mensaje="Verificar que se haya ingresado el estado civil"
        else respuesta=true

        if(!respuesta) AppMensaje.enviarMensaje(binding.root,mensaje,TipoMensaje.ERROR)

        return respuesta
    }

    private fun irListarPersonas() {
        var intentListadoPersonas =Intent(applicationContext,ListadoPersonasActivity::class.java)
            .apply { putExtra("listadoPersonas",listaPersonas) }

        startActivity(intentListadoPersonas)
    }

    private fun registrarPersona() {
        if(validarFormulario()){
            var infoPersona =   binding.tvNombre.text.toString() + " " +
                    binding.tvApellido.text.toString() + " " +
                    binding.tvDni.text.toString() + " " +
                    binding.tvCelular.text.toString() + " " +
                    binding.tvEmail.text.toString() + " " +
                    obtenerCualidades() + " " +
                    obtenerEstadoCivil()

            listaPersonas.add(infoPersona)
            AppMensaje.enviarMensaje(binding.root,"Persona agregada",TipoMensaje.CORRECTO)
        }

    }

    fun agregarQuitarCualidades(v: View){
        val checkbox= v as CheckBox
        if (checkbox.isChecked)
        //if(checkbox.id==binding.cbOtro.id){
            if(checkbox.id==R.id.cbOtro){
                //listaCualidades.add(checkbox.text.toString())
                listaCualidades.add(binding.tvCualidad.text.toString())
            }
            else listaCualidades.add(checkbox.text.toString())
        else
        //if(checkbox.id==binding.cbOtro.id){
            if(checkbox.id==R.id.cbOtro){
                //listaCualidades.add(checkbox.text.toString())
                listaCualidades.remove(binding.tvCualidad.text.toString())
                binding.tvCualidad.setText("")
            }
        listaCualidades.remove(checkbox.text.toString())
    }

    fun obtenerCualidades():String{
        var resultado=""
        for(cualidad in listaCualidades){
            resultado +="$cualidad -"
        }
        return resultado
    }

    fun obtenerEstadoCivil():String{
        var resultado=""
        if(binding.rgEstadoCivil.checkedRadioButtonId.equals(R.id.rbCasado)){
            resultado=binding.rbCasado.text.toString()
        }else if(binding.rgEstadoCivil.checkedRadioButtonId.equals(R.id.rbSoltero)){
            resultado=binding.rbSoltero.text.toString()
        }else if(binding.rgEstadoCivil.checkedRadioButtonId.equals(R.id.rbViudo)){
            resultado=binding.rbViudo.text.toString()
        }else if(binding.rgEstadoCivil.checkedRadioButtonId.equals(R.id.rbDivorciado)){
            resultado=binding.rbDivorciado.text.toString()
        }
        return resultado
    }
    override fun onClick(v: View?) {
        if (v!! is CheckBox){
            agregarQuitarCualidades(v!!)
        }
        else
            when(v!!.id){
                //binding.btnRegistroAcceder.id->registrarPersona()
                //binding.btnRegistroListar.id->irListarPersonas()
                R.id.btnRegistroAcceder->registrarPersona()
                R.id.btnRegistroListar->irListarPersonas()
            }
    }

}