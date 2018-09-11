# Retrofit-Network-Call-Using-Kotlin
Make API calls using retrofit- built complete using kotlin




# To add retrofit to your project add below dependencies to your module's build.gradle file

	  implementation "com.squareup.retrofit2:retrofit:2.0.0"
    implementation "io.reactivex.rxjava2:rxjava:2.1.0"
    implementation "com.squareup.retrofit2:adapter-rxjava2:2.3.0"
    implementation 'io.reactivex.rxjava2:rxandroid:2.0.2'

# Add below line for logging your request 

	  implementation "com.squareup.okhttp3:logging-interceptor:3.8.0"
		
# Add Gson converter factory library for automatically parsing

	implementation "com.squareup.retrofit2:converter-gson:$rootProject.gsonLibraryVersion"
	
# Also don't forget to add INTERNET permission to Manifest file without is you cannot fetch data from internet

	<uses-permission android:name="android.permission.INTERNET"/>
	
Now <sync> your project again.
	
	
Just replace API_KEY in MainActivity class with your key. To get the API_KEY for fetching data, please visit below link, it is free just enter your email and verify your apikey from mail you receive
http://www.omdbapi.com/apikey.aspx
