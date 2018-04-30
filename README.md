# LSLforAndroid
A Lab Streaming Layer (LSL) Library version targeted for Android. It mainly based on the original LSL which runs on Desktop Environments 

## System Requirements
Thus far the library is tested on the [android studio](https://developer.android.com/studio/) platform which runs on an [Ubuntu (16.04 LTS)](https://www.ubuntu.com/download/desktop) Linux 64-bit (x86) OS, but it is critical that you have the following packages installed:
* [Android NDK (r14b)](https://developer.android.com/ndk/downloads/older_releases)
   + This NDK version allows the compilation of C++ based boost libraries 
* [Android SDK Platform-Tools (27.0.1 or above)](https://developer.android.com/studio/releases/platform-tools)
* [Android SDK Tools (26.1.1 or above)](https://developer.android.com/studio/releases/sdk-tools)

## Installation in Your Mobile App
### In Android Studio (gradle)
   * Clone this repo via ``` git clone https://github.com/acmaheri/LSLforAndroid.git``` then import and integrate it into your android studio environment. 

### Updates
* ``` v0.0.01 ```
    + The demo app is disabled.
    + The release is compiled in a generic ```.aar``` library format so as to allow easier multi-platforms integration.  The output ```.aar``` library file can be found [here](https://github.com/acmaheri/LSLforAndroid/tree/master/libAndroidLSL/build/outputs/aar), probably you might need also existing dependencies which is found in this repository.
    + The pre-compiled files can also be found [here](https://github.com/acmaheri/LSLforAndroid/tree/master/libAndroidLSL/build), just incase if you need them. 
   
