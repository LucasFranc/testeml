package br.com.lucasfranco.testeml.model

data class Installment(
        val installments : Int =  0,
        val installment_rate : Int = 0,
        val discount_rate : Int = 0,
        val recommended_message : String =  "",
        val installment_amount : Int = 0,
        val total_amount : Int = 0
)