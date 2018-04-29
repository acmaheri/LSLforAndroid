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
   * Add it in your root build.gradle at the end of repositories:
```javascript
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
* Add the dependency: 
```javascript
   	dependencies {
	        implementation 'com.github.acmaheri:LSLforAndroid:v0.0.01'
	}
 ```
* You may also need to modify your ```local.properties``` file so that it includes the path to your ndk and sdk
```javascript
        ndk.dir=<your-path-name>/android-ndk-r14b
        sdk.dir=<your-path-name>/Sdk
```
