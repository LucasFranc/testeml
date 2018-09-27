package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.interactor.InstallmentInteractor
import br.com.lucasfranco.testeml.model.Transaction
import br.com.lucasfranco.testeml.view.InstallmentFragmentView

class InstallmentFragmentPresenterImpl : InstallmentFragmentPresenter {

    private lateinit var view: InstallmentFragmentView

    override fun attachView(view: InstallmentFragmentView) {
        this.view = view
    }

    override fun doRequestInstallments(transaction: Transaction) {
        view.showLoading()
        InstallmentInteractor().doRequestInstallments(
                transaction.amount,
                transaction.selectedCC.id,
                transaction.selectedCI.id) {
            view.hideLoading()
            view.updateRecyclerView(it)
        }
    }


}
