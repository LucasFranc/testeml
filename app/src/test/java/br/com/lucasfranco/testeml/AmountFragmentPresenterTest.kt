package br.com.lucasfranco.testeml

import br.com.lucasfranco.testeml.presenter.AmountFragmentPresenter
import br.com.lucasfranco.testeml.presenter.AmountFragmentPresenterImpl
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class AmountFragmentPresenterTest {

    @Mock lateinit var presenter: AmountFragmentPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = AmountFragmentPresenterImpl()
    }

    @Test
    fun is_format_correct() {
        val result = presenter.formatValue("$5,000.00")
        assertEquals("5000.00",result)

    }
}