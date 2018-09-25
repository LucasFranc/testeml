package br.com.lucasfranco.testeml.service

import br.com.lucasfranco.testeml.Constants
import br.com.lucasfranco.testeml.model.CardIssuer
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CardIssuerService {

    @GET(Constants.PAYMENT_METHODS + Constants.CARD_ISSUERS)
    fun getAllCardIssuers(@Query("public_key") publicKey: String,
                          @Query("payment_method_id") cardIssuerName : String): Call<List<CardIssuer>>

}

