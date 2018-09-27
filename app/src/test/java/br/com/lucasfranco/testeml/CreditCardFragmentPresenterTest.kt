package br.com.lucasfranco.testeml

import br.com.lucasfranco.testeml.interactor.CreditCardInteractor
import br.com.lucasfranco.testeml.presenter.CreditCardFragmentPresenter
import br.com.lucasfranco.testeml.presenter.CreditCardFragmentPresenterImpl
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CreditCardFragmentPresenterTest{

    private lateinit var presenter: CreditCardFragmentPresenter
    @Mock private lateinit var interactor: CreditCardInteractor

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        presenter = CreditCardFragmentPresenterImpl()
    }

    @Test
    fun testGetAllCreditCards(){
        presenter.doRequestCreditCards()
        }
    }