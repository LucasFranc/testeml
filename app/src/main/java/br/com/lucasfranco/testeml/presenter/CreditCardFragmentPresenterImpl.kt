package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.interactor.CreditCardInteractor
import br.com.lucasfranco.testeml.view.CreditCardFragmentView

class CreditCardFragmentPresenterImpl : CreditCardFragmentPresenter {

    private lateinit var view: CreditCardFragmentView

    override fun attachView(view: CreditCardFragmentView) {
        this.view = view
    }

    override fun doRequestCreditCards() {
        view.showLoading()
        CreditCardInteractor().doRequestCreditCards( {
            view.hideLoading()
            view.updateRecyclerView(it)
        },{
            view.hideLoading()
            view.showToast(it)
        })
    }

}