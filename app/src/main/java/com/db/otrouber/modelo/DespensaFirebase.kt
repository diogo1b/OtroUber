package com.db.otrouber.modelo

import android.util.Log
import com.google.firebase.database.*

class DespensaFirebase {

    private lateinit var database: DatabaseReference
    private var mutableList: MutableList<Item> = mutableListOf<Item>()

    constructor() {
        database = FirebaseDatabase.getInstance().reference;
        database.child("despensa").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                mutableList.clear()
                val data = dataSnapshot!!.children
                data.forEach {
                    val item = it.getValue(Item::class.java)
                    mutableList.add(item!!)
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    fun cargaFirebaseDummy() {
        var items: List<Item> = mutableListOf(
            Item("", "Leche", 15),
            Item("", "Pan", 1),
            Item("", "Pasta", 15),
            Item("", "Arroz", 3),
            Item("", "Frijo", 5)
        )

        items.forEach{
            val key = database.child("despensa").push().key;
            it.id = key
            database.child("despensa").child(key!!).setValue(it)
        }
    }

    fun cargarUnItem(item: Item):Item{
        val key = database.child("despensa").push().key
        item.id = key!!
        database.child("despensa").child(key!!).setValue(item)

        return item

    }

    fun borraUnItem( key: String){
        database.child("despensa").child(key!!).removeValue();
    }

    fun borraTodo(){
        database.child("despensa").removeValue()
    }

    fun modificaUnItem( key: String , cantidad : Int){
        database.child("despensa").child(key!!).child("cantidad").setValue(cantidad)
    }

    fun obtenTodos( ){
        mutableList.forEach {
            Log.i("Data", it.descripcion )
        }
    }
}