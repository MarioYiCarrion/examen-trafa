package pe.edu.idat.ec02_moviles.util

import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import pe.edu.idat.ec02_moviles.R

object AppMensaje {

    fun enviarMensaje(vista: View,mensaje:String,tipo: TipoMensaje){
        val snackbar = Snackbar.make(vista,mensaje,Snackbar.LENGTH_LONG)

            when(tipo){
                TipoMensaje.ERROR-> snackbar.setBackgroundTint(ContextCompat.getColor(MiApp.instancia,R.color.error))
                TipoMensaje.ADVERTENCIA-> snackbar.setBackgroundTint(ContextCompat.getColor(MiApp.instancia,R.color.advertencia))
                TipoMensaje.CORRECTO-> snackbar.setBackgroundTint(ContextCompat.getColor(MiApp.instancia,R.color.correcto))
                TipoMensaje.INFORMACION-> snackbar.setBackgroundTint(ContextCompat.getColor(MiApp.instancia,R.color.informacion))
            }

        snackbar.show()
    }

}