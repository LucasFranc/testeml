package br.com.lucasfranco.testeml.callback

import br.com.lucasfranco.testeml.model.CreditCard

interface OnCreditCardClick {

    fun onItemClick(selectedItem: CreditCard)

}