package br.com.lucasfranco.testeml.view

import br.com.lucasfranco.testeml.model.Installments

interface InstallmentFragmentView : BaseView{

    fun updateRecyclerView(installments : Installments)

}
