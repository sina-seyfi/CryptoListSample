interface BuildTypeConfig {
    val name: String
    val isMinifyEnabled: Boolean
    val isShrinkResources: Boolean
    val isDebuggable: Boolean
    val configs: List<Triple<String, String, String>>
}

abstract class DefaultBuildTypeConfig: BuildTypeConfig {
    override val isMinifyEnabled: Boolean = false
    override val isShrinkResources: Boolean = false
    override val isDebuggable: Boolean = true
    override val configs: List<Triple<String, String, String>> = emptyList()
}

object BuildTypes {

    object Debug: DefaultBuildTypeConfig() {
        override val name: String = "debug"
        override val configs: List<Triple<String, String, String>>
            get() = listOf(
                Triple("int", "DATABASE_VERSION", "1"),
                Triple("String", "SCHEMA_NAME", "\"crypto_db\"")
            )
    }

    object Release: DefaultBuildTypeConfig() {
        override val name: String = "release"
        override val isMinifyEnabled: Boolean = true
        override val isShrinkResources: Boolean = true
        override val isDebuggable: Boolean = false
        val proguardFiles = arrayOf("proguard-rules.pro")
    }

}