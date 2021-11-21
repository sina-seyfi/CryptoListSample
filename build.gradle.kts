// Top-level build file where you can add configuration options common to all sub-projects/modules.
apply(from = "buildSrc/repos.gradle.kts")
buildscript {

    val kotlinVersion by extra(Configuration.kotlinVersion)
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Configuration.gradleVersion}")
//        classpath("de.mannodermaus.gradle.plugins:android-junit5:${Configuration.Junit5Compat}")
        classpath("com.google.gms:google-services:${Configuration.googleServiceVersion}")
        classpath("com.google.firebase:firebase-crashlytics-gradle:${Configuration.analyticVersion}")
        classpath("com.google.dagger:dagger:${Configuration.dagger2Version}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Configuration.kotlinVersion}")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:${GlobalVersions.navigationVersion}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${GlobalVersions.hiltVersion}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts files
    }

}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}


tasks.register("clean").configure {
    delete("build")
}