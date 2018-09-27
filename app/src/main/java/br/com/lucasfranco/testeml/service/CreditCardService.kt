package br.com.lucasfranco.testeml.service

import br.com.lucasfranco.testeml.model.CreditCard
import br.com.lucasfranco.testeml.utils.Constants
import retrofit2.Call
import retrofit2.http.GET

interface CreditCardService {

    @GET(Constants.PAYMENT_METHODS + "?" + Constants.PUBLIC_KEY + Constants.PUBLIC_KEY_VALUE)
    fun getAllCreditCards(): Call<List<CreditCard>>
}