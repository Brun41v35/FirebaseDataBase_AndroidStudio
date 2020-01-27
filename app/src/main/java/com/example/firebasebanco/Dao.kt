package com.example.firebasebanco

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class Dao {

    //Pegando uma instancia do Banco de Dados
    var dataBase = Firebase.getDataBase()

    fun getBanco(callback: (FirebaseBanco?) -> Unit) {
        dataBase.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {}

            override fun onDataChange(p0: DataSnapshot) {
                for (data: DataSnapshot in p0.children){
                    val firebaseBanco = data.getValue(FirebaseBanco::class.java)
                    callback(firebaseBanco)
                }
            }
        })
    }

    fun salvarInformacoes(firebaseBanco: FirebaseBanco) {
        dataBase.child("FirebaseBanco").setValue(firebaseBanco)
    }
}