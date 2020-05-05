package com.db.otrouber.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.db.otrouber.R
import com.db.otrouber.modelo.DespensaFirebase
import kotlinx.android.synthetic.main.fragment_borrar_todo.*

/**
 * A simple [Fragment] subclass.
 */
class BorrarTodoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_borrar_todo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        delete_button.setOnClickListener {
            val despensaFirebase = DespensaFirebase()
            despensaFirebase.borraTodo()
        }

        update_button.setOnClickListener {
            val despensaFirebase = DespensaFirebase()
            val cantidad = cantidad_update_edittext.text.toString().toInt()
            val id = id_update_edittext.text.toString()
            despensaFirebase.modificaUnItem(id, cantidad)
            val contexto = it.context
            Toast.makeText(contexto,"Actualizaste la cantidad", Toast.LENGTH_LONG).show()
        }
    }
}
