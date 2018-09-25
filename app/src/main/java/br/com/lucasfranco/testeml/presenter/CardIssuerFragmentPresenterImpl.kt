package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.interactor.CardIssuerInteractor
import br.com.lucasfranco.testeml.model.Transaction
import br.com.lucasfranco.testeml.view.CardIssuerFragmentView

class CardIssuerFragmentPresenterImpl : CardIssuerFragmentPresenter {

    private lateinit var view: CardIssuerFragmentView

    override fun attachView(view: CardIssuerFragmentView) {
        this.view = view
    }

    override fun doRequestCardIssuers(transaction: Transaction) {
        CardIssuerInteractor().doRequestCardIssuers(transaction.selectedCC.id) {
            view.updateRecyclerView(it)
        }
    }



}
