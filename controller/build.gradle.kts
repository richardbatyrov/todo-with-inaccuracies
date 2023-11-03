import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.4"
    id("io.spring.dependency-management") version "1.0.14.RELEASE"
    kotlin("jvm") version "1.7.20"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.7.20"
}

java.sourceCompatibility = JavaVersion.VERSION_1_8

dependencies {
    // domain
    implementation(project(":domain-task"))
    implementation(project(":usecase"))

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // web
    implementation("org.springframework.boot:spring-boot-starter-data-rest")

    // tests
    testCompileOnly("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testImplementation("io.projectreactor:reactor-test")
}

tasks.test {
    useJUnitPlatform()
}
