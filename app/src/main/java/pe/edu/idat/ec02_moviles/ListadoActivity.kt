package pe.edu.idat.ec02_moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.ec02_moviles.databinding.ActivityListadoBinding


class ListadoActivity : AppCompatActivity() {
    lateinit var binding: ActivityListadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvevento.layoutManager =LinearLayoutManager(applicationContext)
        binding.rvevento.adapter = AdapterItem(listaEventos())

    }

    private fun listaEventos(): List<String> {
        return listOf(
            "Conferencia de Tecnología Global - La conferencia anual de tecnología más grande del mundo. - 20 de marzo de 2024",
            "Festival de Cine de Cannes - Uno de los festivales de cine más prestigiosos del mundo. - 12 de mayo de 2024",
            "Juegos Olímpicos de Verano - La competición deportiva internacional más grande. - 24 de julio de 2024",
            "Exposición Internacional de Automóviles - Muestra de las últimas innovaciones en la industria automotriz. - 8 de septiembre de 2024",
            "Semana de la Moda de París - Presentación de las últimas tendencias de moda. - 15 de octubre de 2024",
            "Foro Económico Mundial - Encuentro anual de líderes mundiales y empresarios. - 21 de enero de 2024",
            "Cumbre del G20 - Reunión de líderes de las principales economías mundiales. - 5 de febrero de 2024",
            "Feria Internacional del Libro - Celebración de la literatura y la cultura mundial. - 18 de abril de 2024",
            "Maratón de Nueva York - Una de las maratones más grandes y populares del mundo. - 3 de noviembre de 2024",
            "Festival de Música de Coachella - Gran festival de música y arte en California. - 10 de abril de 2024",
            "Copa Mundial de Fútbol - El torneo internacional más importante del fútbol. - 20 de junio de 2024",
            "Conferencia Mundial sobre Cambio Climático - Discusión global sobre el cambio climático y medidas de mitigación. - 7 de diciembre de 2024"
        )
    }
}
