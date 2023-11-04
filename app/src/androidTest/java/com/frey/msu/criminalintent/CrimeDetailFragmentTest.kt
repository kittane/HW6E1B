// https://developer.android.com/guide/fragments/test
// https://developer.android.com/training/testing/espresso/basics

package com.frey.msu.criminalintent

import android.widget.EditText
import org.junit.Assert.*
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import org.junit.After
import org.junit.Before
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    private lateinit var scenario: FragmentScenario<CrimeDetailFragment>

    @Before
    fun setUp() {
        scenario = launchFragmentInContainer()
    }

    @Test
    fun testEditTextUpdateCrimeTitle() {
        scenario.onFragment { fragment ->
            fragment.view?.findViewById<EditText>(R.id.crime_title)?.setText("New Crime Title")
            val editText = fragment.view?.findViewById<EditText>(R.id.crime_title)
            assertEquals("New Crime Title", editText?.text.toString())
        }
    }

    @After
    fun tearDown() {
        scenario.close()
    }
}