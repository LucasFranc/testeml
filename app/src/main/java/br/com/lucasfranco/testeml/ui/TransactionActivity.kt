package br.com.lucasfranco.testeml.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.addFragment
import br.com.lucasfranco.testeml.model.Transaction
import br.com.lucasfranco.testeml.replaceFragment

class TransactionActivity : AppCompatActivity() {

    var transaction : Transaction = Transaction()
    private val amountFragment = AmountFragment()
    private val creditCardFragment = CreditCardFragment()
    private val cardIssuerFragment = CardIssuerFragment()
    private val installmentFragment = InstallmentFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        addFragment(amountFragment,R.id.container)
    }

    fun nextFragment(){
        when {
            amountFragment.isVisible -> replaceFragment(creditCardFragment)
            creditCardFragment.isVisible -> replaceFragment(cardIssuerFragment)
            cardIssuerFragment.isVisible -> replaceFragment(installmentFragment)
        }
    }


}
