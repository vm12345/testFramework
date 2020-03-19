=== Software components required to run tests ===

 - Maven
 - Android emulator with the following settings:
    PLATFORM_NAME: Android
    PLATFORM_VERSION: 9
    DEVICE_NAME: emulator-5554
 - java version 1.8 or higher
 if another emulator is used or if real device is needed, make proper settings in file "src/main/java/app/AndroidDriverCapabilities.java"

Links:
Android SDK - https://developer.android.com/studio
Appium - http://appium.io/
Intelij idea - https://www.jetbrains.com/idea/download/
Check for device connection - https://developer.android.com/studio/command-line/adb - points from 4 to 8

Before running tests install three programs above.
Make sure, that device is in device list by command 'adb devices' in terminal

'List of devices attached'
example: 'emulator-5556 device product:sdk_google_phone_x86_64 model:Android_SDK_built_for_x86_64 device:generic_x86_64'
example: 'emulator-5554 device product:sdk_google_phone_x86 model:Android_SDK_built_for_x86 device:generic_x86'

Where emulator-5554 - is a device name

If you use real device - command 'adb devices' will show all devices connected.

Then open project in Intellij idea, set up SDK in IDEA settings.

You need to set a device name into DesiredCapabilities in 'src/main/java/app/AndroidDriverCapabilities.java'

=== Available ways to run tests ===

1 Maven - open console and run command 'mvn test'
2 open file RunCucumberSteps.java and run it as JUNIT test
3 run as separate scenarios within IDE(Intellij IDEA is required)
