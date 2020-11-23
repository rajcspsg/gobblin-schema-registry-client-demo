rootProject.name = "gobblin-schema-registry-client-demo"

pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
        maven {
            name = "JCenter Gradle Plugins"
            url  = java.net.URI("https://dl.bintray.com/gradle/gradle-plugins")
        }
    }
}

