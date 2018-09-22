package br.com.lucasfranco.testeml.presenter

import android.util.Log

class AmountFragmentPresenter {

    fun onClickBtnNext(value: String) {
        Log.e("teste",value)
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
        return rawValue.equals(0L)
    }

}
