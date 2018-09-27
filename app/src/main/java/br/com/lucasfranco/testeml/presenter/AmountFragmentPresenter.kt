package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.model.Transaction
import br.com.lucasfranco.testeml.view.AmountFragmentView

interface AmountFragmentPresenter {

    fun attachView(view : AmountFragmentView)
    fun onClickBtnNext(transaction : Transaction, value: String)
    fun formatValue(valueText: String): String
    fun checkZero(rawValue: Long):Boolean
}