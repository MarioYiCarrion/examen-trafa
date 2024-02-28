package pe.edu.idat.ec02_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import pe.edu.idat.ec02_moviles.databinding.ActivityListadoCuestionarioBinding

class ListadoCuestionarioActivity : AppCompatActivity() {

    lateinit var binding: ActivityListadoCuestionarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoCuestionarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listaCuestionarios =intent.getSerializableExtra("listaCuestionarios")
                as ArrayList<String>
        val adapter = ArrayAdapter(applicationContext,
            android.R.layout.simple_list_item_1,
            listaCuestionarios)
        binding.lvcuestionarios.adapter = adapter
    }
}