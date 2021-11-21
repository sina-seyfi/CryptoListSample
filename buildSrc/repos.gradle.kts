allprojects {
    repositories {
        flatDir {
            this.dir("libs")
        }
        google()
        jcenter()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}