package com.example.fiddlercheck

import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.junit.After
import org.junit.Before
import org.openqa.selenium.remote.DesiredCapabilities
import java.lang.Exception
import java.net.URL

open class TestBase {
   protected var driver: AndroidDriver<MobileElement>? = null
   protected open var caps: DesiredCapabilities? = null
   private val webDriverURL: URL = URL("http://127.0.0.1:4723/wd/hub")


   @Before
   fun setUp() {
       this.driver = AndroidDriver(webDriverURL, caps)
   }

   @After
   fun tearDown() {
       this.driver?.quit() ?: throw Exception("Driver instance was unable to quit.")
   }

}