package com.db.otrouber.fragmentos

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.db.otrouber.R
import com.db.otrouber.modelo.DespensaFirebase
import com.db.otrouber.modelo.Item
import kotlinx.android.synthetic.main.*

class DespensaRecyclerAdapter ( private val list: List<Item>)
    : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: Item = list[position]
        holder.bind(item)
        holder.itemView.setOnLongClickListener {
            val despensaFirebase = DespensaFirebase()
            despensaFirebase.borraUnItem(item.id!!)
            val contexto = it.context
            Toast.makeText(contexto,"Borraste "+ item.descripcion, Toast.LENGTH_LONG).show()
            true
        }

    }

    override fun getItemCount(): Int = list.size
}

class ItemViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.renglon_item, parent, false)) {
    private var cantidadItemTextView: TextView? = null
    private var itemDescripcionTextView: TextView? = null


    init {
        cantidadItemTextView = itemView.findViewById(R.id.item_cantidad)
        itemDescripcionTextView = itemView.findViewById(R.id.item_descipcion)
    }

    fun bind(item: Item) {
        Log.i("Error despensa",item.cantidad.toString() )
        cantidadItemTextView?.text = item.cantidad.toString()
        itemDescripcionTextView?.text = item.descripcion
    }
}