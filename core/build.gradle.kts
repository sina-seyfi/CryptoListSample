plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Configuration.compileSdkVersion
    buildToolsVersion = Configuration.buildToolsVersion
    defaultConfig {
        applicationId = "com.sinaseyfi.${Configuration.projectName}"
        minSdk = Configuration.minSdkVersion
        targetSdk = Configuration.targetSdkVersion
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName
        multiDexEnabled = true
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName(BuildTypes.Debug.name) {
            this.isMinifyEnabled = BuildTypes.Debug.isMinifyEnabled
            this.isShrinkResources = BuildTypes.Debug.isShrinkResources
            this.isDebuggable = BuildTypes.Debug.isDebuggable
        }
        getByName(BuildTypes.Release.name) {
            this.isMinifyEnabled = BuildTypes.Release.isMinifyEnabled
            this.isShrinkResources = BuildTypes.Release.isShrinkResources
            this.isDebuggable = BuildTypes.Release.isDebuggable
            this.proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                *BuildTypes.Release.proguardFiles
            )
        }
    }

    buildFeatures {
        this.viewBinding = true
//        this.compose = true
    }

//    composeOptions {
//        this.kotlinCompilerExtensionVersion = PresentationVersions.composeVersion
//    }

    compileOptions {
        sourceCompatibility = Configuration.JavaVersionSupport
        targetCompatibility = Configuration.JavaVersionSupport
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    kapt {
        correctErrorTypes = true
    }

    flavorDimensions.apply {
        addAll(Flavors.dimensions)
    }

    productFlavors {
        Flavors.flavors.forEach { flavor ->
            this.register(flavor.name) {
                manifestPlaceholders.putAll(flavor.manifestPlaceholder)
                dimension = flavor.dimension
                if(flavor.applicationIdSuffix.isNotEmpty()) {
                    this.applicationIdSuffix = flavor.applicationIdSuffix
                }
                flavor.configs.forEach { config ->
                    this.buildConfigField(
                        config.first, config.second,
                        if (config.first == "String") {
                            "\"${config.third}\""
                        } else {
                            config.third
                        }
                    )
                }
            }
        }
    }

    variantFilter {
        this.flavors.forEach {
            val flavorName = it.name
            val buildType = this.buildType.name
            if(Flavors.flavors.any { flavor -> flavor.name == flavorName }) {
                val flavor = Flavors.flavors.first { flavor -> flavor.name == flavorName }
                ignore = (buildType !in List(flavor.supportedBuildTypes.size) { index -> flavor.supportedBuildTypes[index].name })
            }
        }
    }

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = Configuration.jvmTarget
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":log"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":remote"))
    implementation(project(":presentation"))
    implementation(project(":database"))

    CoreDependencies.dependencyNotation.forEach {
        this.add(it.first, it.second)
    }
}