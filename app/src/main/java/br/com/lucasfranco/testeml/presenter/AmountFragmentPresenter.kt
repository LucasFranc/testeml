package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.model.Transaction
import br.com.lucasfranco.testeml.view.AmountFragmentView

interface AmountFragmentPresenter {

    fun attachView(view : AmountFragmentView)
    fun onClickBtnNext(rawValue: Long, transaction: Transaction, valueString: String)
    fun formatValue(valueText: String): String
    fun checkZero(rawValue: Long):Boolean
}