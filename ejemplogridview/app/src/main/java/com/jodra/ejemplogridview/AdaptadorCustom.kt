package com.jodra.ejemplogridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorCustom(var context: Context, items:ArrayList<Fruta>): BaseAdapter() {
    var items:ArrayList<Fruta>? = null
    init {
        this.items=items
    }
    override fun getCount(): Int {
        return items?.count()!!

    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        var holder:ViewHolder? = null
        if (vista== null){
            vista= LayoutInflater.from(context).inflate(R.layout.templategrid, null)
            holder = ViewHolder(vista)
            vista.tag=holder
        }else{
            holder = vista.tag as? ViewHolder
        }
        val item= items?.get(position) as? Fruta
        holder?.nombre?.text = item?.nombreFruta
        holder?.imagen?.setImageResource(item?.imagenFruta!!)
        return vista!!
    }

    private class ViewHolder(vista:View){
        var nombre:TextView? = null
        var imagen: ImageView? = null

        init{
            nombre = vista.findViewById(R.id.nombre)
            imagen = vista.findViewById(R.id.imagen)
        }
    }

}