package com.db.otrouber.fragmentos

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.db.otrouber.R
import com.db.otrouber.modelo.DespensaFirebase
import com.db.otrouber.modelo.Item
import kotlinx.android.synthetic.main.fragment_alta.*
import kotlinx.android.synthetic.main.renglon_item.*

/**
 * A simple [Fragment] subclass.
 */
class AltaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alta, container, false)
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        send_button.setOnClickListener {
            val despensaFirebase = DespensaFirebase()
            val item = Item()
            item.id = ""
            item.cantidad = cantidad_edittext.text.toString().toInt()
            item.descripcion = description_edittext.text.toString()
            despensaFirebase.cargarUnItem(item)
            val contexto = it.context
            Toast.makeText(contexto,"Creaste:" + item.cantidad + " de: " + item.descripcion, Toast.LENGTH_LONG).show()
            context!!.hideKeyboard(it)
        }
    }
}
