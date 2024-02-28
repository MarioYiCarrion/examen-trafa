package pe.edu.idat.ec02_moviles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter :RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImagen: ImageView
        var itemTitle: TextView
        var itemDate: TextView
        var itemDetail: TextView


        init {
            itemImagen = itemView.findViewById(R.id.imgimagen)
            itemTitle = itemView.findViewById(R.id.tvtitulo)
            itemDate = itemView.findViewById(R.id.tvfecha)
            itemDetail = itemView.findViewById(R.id.tvdescripcion)

        }


    }

    override fun onCreateViewHolder( viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_evento,viewGroup, false)
        return  ViewHolder(v)
    }
    val titles = arrayOf("Evento Internacional Felino",
        "Evento Internacional campestre",
        "Evento Internacional de Rock",
        "Evento Internacional de Marinera",
        "Evento Internacional de Salsa",
        "Evento Internacional de Pop",
        "Evento Internacional de Cumbia",
        "Evento Internacional de FolKrore",
        "Evento Internacional de Metal",
        "Evento Internacional de Punk",
        "Evento Internacional de Merengue",
        "Evento Internacional de Vals",)

    val dates = arrayOf("24/08/2024",
        "25/08/2024",
        "26/08/2024",
        "27/08/2024",
        "28/08/2024",
        "29/08/2024",
        "30/08/2024",
        "01/09/2024",
        "02/09/2024",
        "15/10/2024",
        "26/10/2024",
        "24/12/2024")

    val details = arrayOf("super evento",
        "super evento",
        "super evento",
        "super evento",
        "super evento",
        "super evento",
        "super evento",
        "super evento",
        "super evento",
        "super evento",
        "super evento",
        "super evento")

    val images = intArrayOf(R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground)


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDate.text = dates[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImagen.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return  titles.size

    }
}