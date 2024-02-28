package pe.edu.idat.ec02_moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.ec02_moviles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnregistrar.setOnClickListener(this)
        binding.btnformulario.setOnClickListener(this)
        binding.btnlistado.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id)
        {
            R.id.btnregistrar -> {
                startActivity(Intent(applicationContext, RegistroActivity::class.java))
            }
            R.id.btnformulario -> {
                startActivity(Intent(applicationContext, FormularioActivity::class.java))
            }
            R.id.btnlistado -> {
                startActivity(Intent(applicationContext, ListadoActivity::class.java))
            }

        }
    }
}