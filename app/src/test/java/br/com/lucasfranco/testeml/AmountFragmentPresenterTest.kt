package br.com.lucasfranco.testeml

import br.com.lucasfranco.testeml.presenter.AmountFragmentPresenter
import br.com.lucasfranco.testeml.presenter.AmountFragmentPresenterImpl
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AmountFragmentPresenterTest {

    private lateinit var presenter: AmountFragmentPresenter

    @Before
    fun setUp() {
        presenter = AmountFragmentPresenterImpl()
    }

    @Test
    fun isFormatCorrect() {
        val result = presenter.formatValue("$5,000.00")
        assertEquals("5000.00",result)
    }

    @Test
    fun isFormatFail() {
        val result = presenter.formatValue("123abc")
        assertEquals("",result)
    }

    @Test
    fun checkFormatZero(){
        val result = presenter.checkZero(0L)
        assertEquals(result,true)
    }

    @Test
    fun checkFormatZeroFail(){
        val result = presenter.checkZero(3L)
        assertEquals(result,false)
    }
}