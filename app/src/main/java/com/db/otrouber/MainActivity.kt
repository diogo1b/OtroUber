package com.db.otrouber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.db.otrouber.modelo.DespensaFirebase
import com.db.otrouber.modelo.Item

class MainActivity : AppCompatActivity() {
    private val despensaFirebase : DespensaFirebase = DespensaFirebase()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //despensaFirebase.cargaFirebaseDummy()
    }

    fun agregaItem(view: View) {
        despensaFirebase.cargarUnItem( Item("", "Leche Deslactosada", 15));
    }

    fun borraItem( item: Item){

    }

    fun borrarTodos( ){

    }

    fun modificarItem( item: Item){

    }

    fun obtenerTodos( ){

    }

    override fun onResume() {
        super.onResume()
    }
}
