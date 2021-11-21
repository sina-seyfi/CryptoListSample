import java.lang.StringBuilder

private fun String.camelize(): String =
    when {
        length > 1 -> { "${first().toUpperCase()}${substring(1)}" }
        length == 1 -> { "${first().toUpperCase()}" }
        else -> ""
    }

interface BaseDependencyConfiguration {
    val IMPLEMENTATION: String
    val IMPLEMENTATION_PLATFORM: String
    val API: String
    val TEST_API: String
    val ANNOTATION_PROCESSING_ANDROID_TEST: String
    val ANNOTATION_PROCESSING_TEST: String
    val ANNOTATION_PROCESSING: String
    val ANDROID_TEST_IMPLEMENTATION: String
    val TEST_IMPLEMENTATION: String
    val COMPILE_ONLY: String
}

object DependencyConfiguration : BaseDependencyConfiguration {
    override val IMPLEMENTATION = "implementation"
    val DEBUG_IMPLEMENTATION = "debugImplementation"
    override val IMPLEMENTATION_PLATFORM = "implementationPlatform"
    override val API = "api"
    override val TEST_API = "testImplementation"
    override val ANNOTATION_PROCESSING_ANDROID_TEST = "kaptAndroidTest"
    override val ANNOTATION_PROCESSING_TEST = "kaptTest"
    override val ANNOTATION_PROCESSING = "kapt"
    override val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
    override val TEST_IMPLEMENTATION = "testImplementation"
    override val COMPILE_ONLY = "compileOnly"
}

// Sample input > output:
// BuildTypes.Debug, Flavors.Bazaar, Flavors.Develop >>> Implementation: developBazaarDebugImplementation
// This class facilitate dependency notation string building by sorting flavors by their dimension layer index
// and remove any duplicate flavor on same layer and then check to see if that flavor supports that build type.
class DependencyConfigurationBuilder(buildType: BuildTypeConfig, vararg flavors: FlavorConfig)
    : BaseDependencyConfiguration {

    private val flavorNamesAppended: String by lazy {
        val filteredFlavors = flavors.distinctBy { flavor -> flavor.dimension } // Remove any duplicated flavor name dimension
            .filter { flavor -> flavor.supportedBuildTypes.contains(buildType) } // Remove not supported flavors by this build type
            .sortedBy { flavor -> Flavors.dimensions.indexOf(flavor.dimension) } // Sort flavors by their flavor dimension layer
        StringBuilder().apply { filteredFlavors.forEach { flavor -> flavor.name.camelize() } }.toString() // Camelize final build variant name
    }

    private val finalBuildVariant: String by lazy {
        if(flavorNamesAppended.isEmpty()) buildType.name
        else "$flavorNamesAppended${buildType.name.camelize()}"
    }

    override val IMPLEMENTATION: String = "$finalBuildVariant${DependencyConfiguration.IMPLEMENTATION.camelize()}"
    override val IMPLEMENTATION_PLATFORM: String = "$finalBuildVariant${DependencyConfiguration.IMPLEMENTATION_PLATFORM.camelize()}"
    override val API: String = "$finalBuildVariant${DependencyConfiguration.API.camelize()}"
    override val TEST_API: String = "$finalBuildVariant${DependencyConfiguration.TEST_API.camelize()}"
    override val ANNOTATION_PROCESSING_ANDROID_TEST: String = "$finalBuildVariant${DependencyConfiguration.ANNOTATION_PROCESSING_ANDROID_TEST.camelize()}"
    override val ANNOTATION_PROCESSING_TEST: String = "$finalBuildVariant${DependencyConfiguration.ANNOTATION_PROCESSING_ANDROID_TEST.camelize()}"
    override val ANNOTATION_PROCESSING: String = "$finalBuildVariant${DependencyConfiguration.ANNOTATION_PROCESSING.camelize()}"
    override val ANDROID_TEST_IMPLEMENTATION: String = "$finalBuildVariant${DependencyConfiguration.ANDROID_TEST_IMPLEMENTATION.camelize()}"
    override val TEST_IMPLEMENTATION: String = "$finalBuildVariant${DependencyConfiguration.TEST_IMPLEMENTATION.camelize()}"
    override val COMPILE_ONLY: String = "$finalBuildVariant${DependencyConfiguration.COMPILE_ONLY.camelize()}"

}