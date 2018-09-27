package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.model.Transaction
import br.com.lucasfranco.testeml.view.AmountFragmentView

class AmountFragmentPresenterImpl : AmountFragmentPresenter {

    private lateinit var view: AmountFragmentView

    override fun attachView(view: AmountFragmentView) { this.view = view }

    override fun onClickBtnNext(rawValue: Long, transaction: Transaction, valueString: String) {
        if(!checkZero(rawValue)) {
            transaction.amount = formatValue(valueString)
            view.onNextFragment()
        }else{ view.showError() }
    }

    override fun formatValue(valueText: String): String {
        return if(valueText.contains('$')) {
            val value = valueText.replace("$", "", false)
                    .replace(",", "", false)
                    .replace(".", "", false)
            val beforeDot = value.substring(0, value.length - 2)
            val afterDot = value.substring(value.length - 2)
            "$beforeDot.$afterDot"
        }else
            ""
    }

    override fun checkZero(rawValue: Long):Boolean {
        return rawValue == 0L
    }

}
