package br.com.lucasfranco.testeml.view

import br.com.lucasfranco.testeml.model.CreditCard

interface CreditCardFragmentView {

    fun updateRecyclerView(list : List<CreditCard>)

}