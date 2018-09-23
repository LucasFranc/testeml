package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.view.CreditCardFragmentView

interface CreditCardFragmentPresenter {

    fun attachView(view: CreditCardFragmentView)
    fun doRequestCreditCards()

}