plugins {
    this.id("kotlin")
    this.id("java-library")
    this.kotlin("kapt")
}
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    LogDependencies.dependencyNotation.forEach {
        this.add(it.first, it.second)
    }
}
java {
    sourceCompatibility = Configuration.JavaVersionSupport
    targetCompatibility = Configuration.JavaVersionSupport
}