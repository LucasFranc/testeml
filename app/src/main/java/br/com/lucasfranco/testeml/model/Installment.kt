package br.com.lucasfranco.testeml.model

data class Installment(
        val installments : Float =  0F,
        val installment_rate : Float = 0F,
        val discount_rate : Float = 0F,
        val recommended_message : String =  "",
        val installment_amount : Float = 0F,
        val total_amount : Float = 0F
)