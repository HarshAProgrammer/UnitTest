package com.example.unittest

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun usernameIsNotEmpty() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }


    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Harsh",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }


    @Test
    fun usernameAlreadyExistsReturnsFalse() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl", "123", "123"
        )
        assertThat(result).isFalse()
    }


    @Test
    fun passwordRepeatedIncorrectlyReturnsFalse() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Harsh", "123", "456"
        )
        assertThat(result).isFalse()
    }


    @Test
    fun `less than 2 digit password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Harsh", "abcdef", "abcdef"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun emptyPasswordReturnsFalse() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Harsh",
            "",
            ""
        )
        assertThat(result).isFalse()
    }


}