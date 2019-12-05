# Dogs

## Add Dependencies
### In the module `build.gradle`
* in the `dependencies` block, add 
  ```classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.1.0-alpha05"```
  
### In the app `build.gradle`

* apply the following plugins at the top of the file

  ```
  apply plugin: 'kotlin-kapt'
  apply plugin: 'androidx.navigation.safeargs'
  ``` 
  
* add version number variables to the root of the file
  
  ```  
  def lifecycleExtensionVersion = '1.1.1'
  def supportVersion = '28.0.0'
  def retrofitVersion = '2.3.0'
  def glideVersion = '4.9.0'
  def rxJavaVersion = '2.1.1'
  def roomVersion = '2.1.0-rc01'
  def navVersion = '2.1.0-alpha05'
  def preferencesVersion = '1.0.0'
  ```

* and the dependencies to the `dependencies` block
  
  ```
  implementation 'androidx.appcompat:appcompat:1.0.2'
  implementation 'androidx.core:core-ktx:1.0.2'
  implementation 'androidx.constraintlayout:constraintlayout:1.1.3'

  implementation "com.android.support:design:$supportVersion"
  implementation "android.arch.lifecycle:extensions:$lifecycleExtensionVersion"
  implementation "androidx.room:room-runtime:$roomVersion"
  implementation "androidx.legacy:legacy-support-v4:1.0.0"

  kapt "androidx.room:room-compiler:$roomVersion"
  implementation "androidx.room:room-ktx:$roomVersion"
  implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1"

  implementation "androidx.navigation:navigation-fragment-ktx:$navVersion"
  implementation "androidx.navigation:navigation-ui-ktx:$navVersion"
  
  implementation "com.google.android.material:material:1.0.0"
  implementation "com.squareup.retrofit2:retrofit:$retrofitVersion"
  implementation "com.squareup.retrofit2:converter-gson:$retrofitVersion"
  implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
  
  implementation "io.reactivex.rxjava2:rxjava:$rxJavaVersion"
  implementation "io.reactivex.rxjava2:rxandroid:$rxJavaVersion"
  
  implementation "com.github.bumptech.glide:glide:$glideVersion"
  implementation "com.android.support:palette-v7:$supportVersion"
  implementation "androidx.preference:preference:$preferencesVersion"
  ```