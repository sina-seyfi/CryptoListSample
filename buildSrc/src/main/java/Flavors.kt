import java.util.*

interface FlavorConfig {
    val name: String
    val manifestPlaceholder: Map<String, String>
    val applicationIdSuffix: String
    val dimension: String
    val supportedBuildTypes: Array<BuildTypeConfig>
    val configs:List<Triple<String,String,String>>
}

object Flavors {

    private const val dimensionBase = "base"
    private const val dimensionMarket = "market"

    val dimensions = arrayOf(dimensionBase)

    val flavors = arrayOf(Develop)

    object Develop: FlavorConfig {
        private const val API_VERSION = "v1"
        override val name: String = this::class.java.simpleName.toLowerCase(Locale.ENGLISH)
        override val manifestPlaceholder: Map<String, String> = mapOf("app_name" to "${Configuration.appName} - $name")
        override val applicationIdSuffix: String = "dev"
        override val dimension: String = dimensionBase
        override val supportedBuildTypes: Array<BuildTypeConfig> = arrayOf(BuildTypes.Debug)
        override val configs: List<Triple<String, String, String>> = listOf(
            Triple("String", "API_BASE_URL", "https://pro-api.coinmarketcap.com/${API_VERSION}/cryptocurrency/"),
            Triple("String", "API_KEY", "0e58d5e5-9da9-4137-88c1-c761e610238e"),
            Triple("String", "API_KEY_HEADER", "X-CMC_PRO_API_KEY")
        )
    }

    object Product: FlavorConfig {
        override val name: String = this::class.java.simpleName.toLowerCase(Locale.ENGLISH)
        override val manifestPlaceholder: Map<String, String> = mapOf("app_name" to Configuration.appName)
        override val applicationIdSuffix: String = "dev"
        override val dimension: String = dimensionBase
        override val supportedBuildTypes: Array<BuildTypeConfig> = arrayOf(BuildTypes.Debug)
        override val configs: List<Triple<String, String, String>> = emptyList()
    }

    object Bazaar: FlavorConfig {
        override val name: String = this::class.java.simpleName.toLowerCase(Locale.ENGLISH)
        override val manifestPlaceholder: Map<String, String> = mapOf("app_name" to "${Configuration.appName} - $name")
        override val applicationIdSuffix: String = "bazaar"
        override val dimension: String = dimensionMarket
        override val supportedBuildTypes: Array<BuildTypeConfig> = arrayOf(BuildTypes.Debug, BuildTypes.Release)
        override val configs: List<Triple<String, String, String>> = emptyList()
    }

    object Play: FlavorConfig {
        override val name: String = this::class.java.simpleName.toLowerCase(Locale.ENGLISH)
        override val manifestPlaceholder: Map<String, String> = mapOf("app_name" to "${Configuration.appName} - $name")
        override val applicationIdSuffix: String = "bazaar"
        override val dimension: String = dimensionMarket
        override val supportedBuildTypes: Array<BuildTypeConfig> = arrayOf(BuildTypes.Debug, BuildTypes.Release)
        override val configs: List<Triple<String, String, String>> = emptyList()
    }

}