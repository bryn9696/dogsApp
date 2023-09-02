The application can be run on an Android device set up.

Ensure that the Android SDK is installed on your system. The SDK provides the necessary tools and libraries for developing Android apps.
Emulator or Device: You'll need an Android emulator or a physical Android device to run the app.

First, the project needs to be built by running the command: ./gradlew

Then run: ./gradlew assembleDebug

Next run: export PATH="/Users/{yourUsername}/Library/Android/sdk/platform-tools:$PATH"

Run: ./gradlew assembleDebug

The app should then be able to be run via the Android emulator.

----------------

If i had more time for this I would:
- Try to sharpen the presentation of the images
- Clean up the way the image url is extracted from the API
- Display the extra information from the API