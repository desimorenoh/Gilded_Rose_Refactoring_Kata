import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.6.10"
}

group = "com.gildedrose"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib"))

	// Test
	testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
	testImplementation(kotlin("test"))
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
	testImplementation("org.junit.vintage:junit-vintage-engine:5.9.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
	testImplementation("org.mockito:mockito-inline:4.6.1")
	testImplementation("org.mockito:mockito-junit-jupiter:4.0.0")
	testImplementation("org.assertj:assertj-core:3.21.0")
	testImplementation("io.rest-assured:kotlin-extensions:4.3.0")
	testImplementation("io.rest-assured:spring-mock-mvc-kotlin-extensions:4.4.0")

// Kotlin Test
	testImplementation("org.jetbrains.kotlin:kotlin-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
	testImplementation("io.mockk:mockk:1.10.0")

}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}

// config JVM target to 1.8 for kotlin compilation tasks
tasks.withType<KotlinCompile>().configureEach {
	kotlinOptions.jvmTarget = "1.8"
}

tasks.test {
	useJUnitPlatform()
}
tasks.withType(Test::class).configureEach {
	useJUnitPlatform()
}
