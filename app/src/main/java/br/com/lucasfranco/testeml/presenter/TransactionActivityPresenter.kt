package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.model.Transaction

interface TransactionActivityPresenter {

    fun formatMessage(transaction : Transaction) : String
}