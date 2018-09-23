package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.model.Transaction
import br.com.lucasfranco.testeml.view.AmountFragmentView

class AmountFragmentPresenter(val view : AmountFragmentView) {

    fun onClickBtnNext(transaction : Transaction, value: String) {
        transaction.amount = value
        view.onNextFragment()
    }

    fun formatValue(valueText: String): String {
        val value = valueText.replace("$","",false)
                .replace(",","",false)
                .replace(".","",false)
        val beforeDot = value.substring(0,value.length - 2)
        val afterDot = value.substring(value.length - 2)
        return "$beforeDot.$afterDot"
    }

    fun checkZero(rawValue: Long):Boolean {
        return rawValue == 0L
    }

}
