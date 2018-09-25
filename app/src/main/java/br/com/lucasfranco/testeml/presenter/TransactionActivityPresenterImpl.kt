package br.com.lucasfranco.testeml.presenter

import br.com.lucasfranco.testeml.model.Transaction

class TransactionActivityPresenterImpl : TransactionActivityPresenter {

    override fun formatMessage(transaction: Transaction) : String{

        return "Amount : " + transaction.amount + breakLine() +
                "Credit Card : " + transaction.selectedCC.name + breakLine() +
                "Card Issuer : " + transaction.selectedCI.name + breakLine() +
                transaction.selectedInstallment.recommended_message
    }

    private fun breakLine() : String?{
        return System.getProperty ("line.separator")
    }

}