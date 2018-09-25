package br.com.lucasfranco.testeml.model

data class Transaction(
        var amount : String = "",
        var selectedCC : CreditCard = CreditCard(),
        var selectedCI : CardIssuer = CardIssuer(),
        var selectedInstallment : Installment = Installment()
)