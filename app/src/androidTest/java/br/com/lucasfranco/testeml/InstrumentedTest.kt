package br.com.lucasfranco.testeml

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import br.com.lucasfranco.testeml.R.id.btn_next
import br.com.lucasfranco.testeml.R.id.edt_text_amount
import br.com.lucasfranco.testeml.ui.TransactionActivity
import br.com.lucasfranco.testeml.ui.adapter.CardIssuerAdapter
import br.com.lucasfranco.testeml.ui.adapter.CreditCardAdapter
import br.com.lucasfranco.testeml.ui.adapter.InstallmentAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest {

    @get:Rule
    val activityRule: ActivityTestRule<TransactionActivity> =
            ActivityTestRule(TransactionActivity::class.java)

    @Test
    fun testHappyFlow() {
        onView(withId(edt_text_amount)).perform(typeText("500000"))
        onView(withId(btn_next)).perform(click())
        Thread.sleep(5000)
        onView(withId(R.id.rv_credit_card)).perform(actionOnItemAtPosition<CreditCardAdapter.ViewHolder>(0, click()))
        Thread.sleep(5000)
        onView(withId(R.id.rv_card_issuer)).perform(actionOnItemAtPosition<CardIssuerAdapter.ViewHolder>(0, click()))
        Thread.sleep(5000)
        onView(withId(R.id.rv_installment)).perform(actionOnItemAtPosition<InstallmentAdapter.ViewHolder>(3, click()))
        Thread.sleep(2000)

        if (!viewWithTextExist(R.string.ok) && !viewWithTextExist(R.string.ok)) {
            throw Exception()
        }else{
            onView(withText(R.string.ok)).perform(click())
        }
        Thread.sleep(2000)
    }

    private fun viewWithTextExist(text: Int): Boolean {
        return try {
            onView(withText(text)).check(matches(isDisplayed()))
            true
        } catch (e: NoMatchingViewException) {
            false
        }

    }
}
