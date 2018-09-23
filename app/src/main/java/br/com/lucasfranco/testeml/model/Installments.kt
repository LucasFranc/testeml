package br.com.lucasfranco.testeml.model

data class Installments(
        val payment_method_id : String = "",
        val payment_type_id : String = "",
        val payer_costs: List<Installments> = ArrayList()
)