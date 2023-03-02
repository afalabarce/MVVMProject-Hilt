pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MVVM Project Hilt"
include ("app",
    ":model",
    ":datasource",
    ":data",
    ":domain",
)
