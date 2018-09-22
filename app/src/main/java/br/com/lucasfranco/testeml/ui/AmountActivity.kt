package br.com.lucasfranco.testeml.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.lucasfranco.testeml.R
import br.com.lucasfranco.testeml.addFragment

class AmountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        addFragment(AmountFragment(),R.id.container)
    }
}
