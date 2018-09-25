package br.com.lucasfranco.testeml.callback

import br.com.lucasfranco.testeml.model.Installment

interface OnInstallmentClick {

    fun onItemClick(installment : Installment)

}