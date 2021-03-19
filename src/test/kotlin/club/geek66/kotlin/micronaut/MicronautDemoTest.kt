package club.geek66.kotlin.micronaut

import io.kotest.core.spec.style.StringSpec
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
class MicronautDemoTest(private val application: EmbeddedApplication<*>) : StringSpec({

	"test the server is running" {
		assert(application.isRunning)
	}
})
