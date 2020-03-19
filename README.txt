=== Software components required to run tests ===

 - Maven
 - Android emulator with the following settings:
    PLATFORM_NAME: Android
    PLATFORM_VERSION: 9
    DEVICE_NAME: emulator-5554
 - java version 1.8 or more
 if another emulator is used, make proper settings in file "src/main/java/app/AndroidDriverCapabilities.java"

=== Available ways to run tests ===

1 Maven - open console and run command 'mvn test'
2 open file RunCucumberSteps.java and run it as JUNIT test
3 run as separate scenarios within IDE(Intellij IDEA is required)
