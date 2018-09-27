package br.com.lucasfranco.testeml.view

import br.com.lucasfranco.testeml.model.CardIssuer

interface CardIssuerFragmentView : BaseView {

    fun updateRecyclerView(list : List<CardIssuer>)
    fun showNoResultsView()

}
