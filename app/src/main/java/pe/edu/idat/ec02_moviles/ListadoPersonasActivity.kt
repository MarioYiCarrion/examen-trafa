package pe.edu.idat.ec02_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.ec02_moviles.databinding.ActivityListadoPersonasBinding

class ListadoPersonasActivity : AppCompatActivity() {

    lateinit var binding:ActivityListadoPersonasBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        val intent = intent

        super.onCreate(savedInstanceState)
        binding =ActivityListadoPersonasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvElementos.layoutManager=LinearLayoutManager(applicationContext)
        binding.rvElementos.adapter=AdapterItem(intent.getSerializableExtra("listadoPersonas") as ArrayList<String>)

    }

}