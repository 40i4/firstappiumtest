package com.example.fiddlercheck

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso
import io.appium.java_client.AppiumBy
import io.appium.java_client.AppiumFluentWait
import io.appium.java_client.android.AndroidDriver
import java.time.Duration
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Test
import org.openqa.selenium.interactions.Interaction
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence

class HelloWorldTest : TestBase() {
    @IdRes
    private val nextButton: Int = R.id.button_first

    @Test
    fun headlinesScrollTest() {
        val wait: AppiumFluentWait<AndroidDriver> = AppiumFluentWait(driver)
        wait.until { driver ->
            driver.findElement(
                AppiumBy.androidDataMatcher(
                    Espresso.onData(allOf(`is`(instanceOf(String::class.java)), `is`("Americano"))).toString()
                )
            ).isDisplayed
            true
        }
//        AppiumBy.androidDataMatcher(Espresso.onData(allOf(`is`(instanceOf(String::class.java)), `is`("Americano"))).perform(click()).toString())

        // Scroll Down
        val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
        val moveToStart: Interaction =
            finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 726, 2452)
        val pressDown: Interaction = finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())
        val moveToEnd: Interaction =
            finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 726, 660)
        val pressUp: Interaction = finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())

        val swipe = Sequence(finger, 0)
        swipe.addAction(moveToStart)
        swipe.addAction(pressDown)
        swipe.addAction(moveToEnd)
        swipe.addAction(pressUp)

        driver.perform(listOf(swipe))

        print("roedeer")
    }
}
