package pe.edu.idat.ec02_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.ec02_moviles.databinding.ActivityListadoCuestionarioBinding
import pe.edu.idat.ec02_moviles.databinding.ActivityListadoPersonasBinding

class ListadoCuestionarioActivity : AppCompatActivity() {

    lateinit var binding:ActivityListadoCuestionarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        val intent = intent

        super.onCreate(savedInstanceState)
        binding = ActivityListadoCuestionarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvcuestionario.layoutManager= LinearLayoutManager(applicationContext)
        binding.rvcuestionario.adapter=AdapterItem(intent.getSerializableExtra("listarCuestionario") as ArrayList<String>)
    }
}