-dontobfuscate

-dontnote android.net.http.**
-dontwarn org.apache.**
-dontwarn org.w3c.dom.**
-dontnote retrofit2.Platform

-dontwarn com.google.errorprone.annotations.*
-dontwarn com.squareup.okhttp.**
-dontwarn kotlin.**
-dontwarn okio.**
-dontwarn retrofit2.**

-keepattributes *Annotation*
-keepattributes Signature
-keepattributes Exceptions

-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

-keep class android.arch.core.util.** { *; }
-keep class com.firebase.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.google.gson.stream.** { *; }
-keep class org.apache.** { *; }
-keep class retrofit2.** { *; }
-keep class sun.misc.Unsafe { *; }

-keepnames class com.fasterxml.jackson.** { *; }
-keepnames class javax.servlet.** { *; }
-keepnames class org.ietf.jgss.** { *; }

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
