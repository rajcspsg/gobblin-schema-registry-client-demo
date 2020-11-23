buildscript {
    repositories {
        mavenCentral()
        mavenLocal()
        jcenter()
    }
    dependencies {
        classpath ("com.commercehub.gradle.plugin:gradle-avro-plugin:0.16.0")
    }
}

plugins {
    java
    application
    id("com.commercehub.gradle.plugin.avro") version "0.16.0"
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
}

dependencies {
    implementation("org.apache.gobblin", "gobblin-kafka-09", "0.14.0")
    implementation("org.apache.avro", "avro", "1.8.2")
    testCompile("junit", "junit", "4.12")
}

application {

    mainClassName = "Main"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
