package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.interactor.CreditCardInteractor
import br.com.lucasfranco.testeml.view.CreditCardFragmentView

class CreditCardFragmentPresenterImpl : CreditCardFragmentPresenter {

    private lateinit var view: CreditCardFragmentView

    override fun attachView(view: CreditCardFragmentView) {
        this.view = view
    }

    override fun doRequestCreditCards() {
        CreditCardInteractor().doRequestCreditCards {
            view.updateRecyclerView(it)
        }
    }

}