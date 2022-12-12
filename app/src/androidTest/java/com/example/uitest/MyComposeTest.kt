package com.example.uitest

import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.uitest.ui.theme.UITestTheme
import org.junit.Rule
import org.junit.Test

class MyComposeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun blankInputTest(){
        //Установить контент
        composeTestRule.setContent {
            UITestTheme {
                MainUi()
            }
        }
        //Получить узел "my_button" и нажать
        composeTestRule.onNode(hasContentDescription("my_button")).performClick()
        //Получить узел с текстом "No one is here" и сказать что он точно есть, если его не будет, тест провалится
        composeTestRule.onNodeWithText("No one is here").assertExists()
    }

    @Test
    fun filledInputTest(){
        //Установить контент
        composeTestRule.setContent {
            UITestTheme {
                MainUi()
            }
        }
        val name = "deb"
        //Получить узел "my_input" и ввести туда переменную name
        composeTestRule.onNode(hasContentDescription("my_input")).performTextInput(name)
        //Получить узел "my_button" и нажать
        composeTestRule.onNode(hasContentDescription("my_button")).performClick()
        //Получить узел с текстом "hi $name" и сказать что он точно есть, если его не будет, тест провалится
        composeTestRule.onNodeWithText("hi $name").assertExists()
    }
}