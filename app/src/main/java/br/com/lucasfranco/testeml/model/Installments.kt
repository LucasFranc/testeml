package br.com.lucasfranco.testeml.model

data class Installments(
        val payment_method_id : String = "",
        val payment_type_id : String = "",
        val issuer : CardIssuer,
        val payer_costs: List<Installment> = ArrayList()
)