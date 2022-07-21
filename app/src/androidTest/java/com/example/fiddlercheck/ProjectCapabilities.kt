package com.example.fiddlercheck

import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities

class ProjectCapabilities {
   companion object {
       const val packageName = BuildConfig.APPLICATION_ID

       fun AndroidBaseCapabilities(): DesiredCapabilities {
           val caps = DesiredCapabilities()
           caps.setCapability("autoAcceptAlerts", false)
           caps.setCapability("platformName", "Android")
           caps.setCapability("automationName", "UiAutomator2")
           caps.setCapability("deviceName", "emulator-5554")
           caps.setCapability("appPackage", packageName)

          // caps.setCapability(MobileCapabilityType.APP, File(appDir, apkFile).absolutePath)

           //caps.setCapability("udid", "")
           caps.setCapability("appActivity", "com.example.fiddlercheck.MainActivity")
           return caps
       }
   }
}