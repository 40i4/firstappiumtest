package com.example.fiddlercheck

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.EspressoOptions
import io.appium.java_client.android.options.UiAutomator2Options
import java.net.URL
import org.junit.After
import org.junit.Before

abstract class TestBase {
    private var _driver: AndroidDriver? = null
    protected val driver: AndroidDriver
        get() = _driver!!

    private val options = UiAutomator2Options()
        .setDeviceName("emulator-5554")
        .setPlatformName("Android")
        .setAppPackage(BuildConfig.APPLICATION_ID)
        //.setAppActivity("com.example.fiddlercheck.MainActivity")
        .eventTimings()
//    private val driverUrl: URL = URL("http://127.0.0.1:4723/wd/hub")
    private val driverUrl: URL = URL("http://10.0.2.2:4723/wd/hub")

    @Before
    fun setUp() {
        this._driver = AndroidDriver(driverUrl, options)
    }

    @After
    fun tearDown() {
//        this._driver?.quit() ?: error("Driver instance was unable to quit.")
    }
}
