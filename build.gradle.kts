plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
	kotlin("plugin.jpa") version "1.9.25"
	id("org.flywaydb.flyway") version "10.0.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Starters oficiais
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web") // Alterado de webmvc para web

	// Kotlin & Jackson
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // Grupo correto: com.fasterxml
	implementation("org.flywaydb:flyway-mysql")
	// Database
	runtimeOnly("com.mysql:mysql-connector-j")

	// Testes
	testImplementation("org.springframework.boot:spring-boot-starter-test") // Agrupa web e jpa testes
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}