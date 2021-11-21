plugins {
    this.id("com.android.library")
    this.id("kotlin-android")
    this.kotlin("kapt")
    this.id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Configuration.compileSdkVersion
    buildToolsVersion = Configuration.buildToolsVersion

    configurations.all {
        resolutionStrategy.force("com.google.android.material:material:${GlobalVersions.materialVersion}")
    }


    defaultConfig {
        minSdk = Configuration.minSdkVersion
        targetSdk = Configuration.targetSdkVersion
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = PresentationVersions.composeVersion
    }

    compileOptions {
        sourceCompatibility = Configuration.JavaVersionSupport
        targetCompatibility = Configuration.JavaVersionSupport
    }
    kotlinOptions {
        jvmTarget = Configuration.jvmTarget
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
    implementation(project(":log"))
    implementation(project(":domain"))

    PresentationDependencies.dependencyNotation.forEach {
        if(it.first == DependencyConfiguration.IMPLEMENTATION_PLATFORM)
            this.add(DependencyConfiguration.IMPLEMENTATION, platform(it.second))
        else
            this.add(it.first, it.second)
    }
}