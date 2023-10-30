plugins {
    kotlin("jvm") version "1.9.0"
    id("maven-publish")
}

group = "me.selemba"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("net.java.dev.jna:jna:5.13.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

publishing{
    publications {
        create<MavenPublication>("maven") {
            groupId = "me.selemba"
            artifactId = "KotlinTinyFileDialogs"
            version = "1.0.0"

            from(components["java"])
        }
    }
}