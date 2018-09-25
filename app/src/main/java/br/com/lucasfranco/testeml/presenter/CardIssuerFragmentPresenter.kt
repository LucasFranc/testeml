package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.model.Transaction
import br.com.lucasfranco.testeml.view.CardIssuerFragmentView

interface CardIssuerFragmentPresenter {

    fun attachView(view: CardIssuerFragmentView)
    fun doRequestCardIssuers(transaction : Transaction)

}