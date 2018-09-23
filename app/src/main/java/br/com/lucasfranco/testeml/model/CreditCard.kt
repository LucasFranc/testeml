package br.com.lucasfranco.testeml.model

data class CreditCard(
        val id : String = "",
        val name : String  =  "",
        val payment_type_id : String = "",
        val status : Boolean = true,
        val thumbnail : String = ""
)