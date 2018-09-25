package br.com.lucasfranco.testeml.callback

import br.com.lucasfranco.testeml.model.CardIssuer

interface OnCardIssuerClick {

    fun onItemClick(selectedItem: CardIssuer)
}