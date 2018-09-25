package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.model.Transaction

interface AmountFragmentPresenter {

    fun onClickBtnNext(transaction : Transaction, value: String)
    fun formatValue(valueText: String): String
    fun checkZero(rawValue: Long):Boolean
}