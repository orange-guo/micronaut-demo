plugins {
	kotlin("jvm") version "1.4.30"
	kotlin("kapt") version "1.4.30"
	kotlin("plugin.allopen") version "1.4.30"
	id("com.github.johnrengelman.shadow") version "6.1.0"
	id("io.micronaut.application") version "1.4.2"
}

version = "0.1"
group = "club.geek66.kotlin.micronaut"

val kotlinVersion: String by project
val micronautVersion: String by project

repositories {
	maven { setUrl("http://mirrors.tencent.com/nexus/repository/maven-public/") }
	maven { setUrl("https://mirrors.huaweicloud.com/repository/maven/") }
	maven { setUrl("http://maven.aliyun.com/nexus/content/groups/public/") }
	maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots") }
	maven { setUrl("https://kotlin.bintray.com/kotlinx") }
}

micronaut {
	runtime("netty")
	testRuntime("kotest")
	processing {
		incremental(true)
		annotations("club.geek66.kotlin.micronaut.*")
	}
}

dependencies {
	// kotlin
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
	implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

	// micronaut
	implementation("io.micronaut:micronaut-validation")
	implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
	implementation("io.micronaut:micronaut-runtime")
	implementation("io.micronaut:micronaut-http-client")
	implementation("io.micronaut.data:micronaut-data-hibernate-jpa")

	kapt("io.micronaut.data:micronaut-data-processor")
	kaptTest("io.micronaut.data:micronaut-data-processor")

	// javax
	implementation("javax.annotation:javax.annotation-api")
	runtimeOnly("ch.qos.logback:logback-classic")
	runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("io.micronaut.sql:micronaut-jdbc-hikari")
}

application {
	mainClass.set("club.geek66.kotlin.micronaut.ApplicationKt")
}

tasks {
	compileKotlin {
		kotlinOptions {
			jvmTarget = "11"
		}
	}
	compileTestKotlin {
		kotlinOptions {
			jvmTarget = "11"
		}
	}
}
