package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.model.Transaction
import br.com.lucasfranco.testeml.view.InstallmentFragmentView

interface InstallmentFragmentPresenter {

    fun attachView(view : InstallmentFragmentView)
    fun doRequestInstallments(transaction: Transaction)
}