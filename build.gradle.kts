import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

val zircon_version: String by project
val slf4j_version: String by project
val junit_version: String by project
val mockito_version: String by project
val assertj_version: String by project

plugins {
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "5.2.0"
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("org.slf4j:slf4j-api:$slf4j_version")
    implementation("org.slf4j:slf4j-simple:$slf4j_version")

    implementation("org.hexworks.zircon:zircon.core-jvm:$zircon_version")
    implementation("org.hexworks.zircon:zircon.jvm.swing:$zircon_version")

    testImplementation("junit:junit:$junit_version")
    testImplementation("org.mockito:mockito-all:$mockito_version")
    testImplementation("org.assertj:assertj-core:$assertj_version")
}

tasks {
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("shadow")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "com.example.MainKt"))
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "com.example.MainKt"
    }
}


