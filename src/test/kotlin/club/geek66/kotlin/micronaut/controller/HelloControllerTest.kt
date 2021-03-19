package club.geek66.kotlin.micronaut.controller

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import javax.inject.Inject

/**
 *
 * @author: orange
 * @date: 2021/3/17
 * @time: 上午11:23
 * @copyright: Copyright 2021 by orange
 */
@MicronautTest
class HelloControllerTest(
	@Inject
	private val server: EmbeddedServer,
	@Inject
	@field:Client("/")
	private val client: HttpClient
) : FunSpec() {

	init {
		test("test get") {
			val response: String = client.toBlocking().retrieve("/hello")
			response shouldBe "Hello World"
		}
	}

}