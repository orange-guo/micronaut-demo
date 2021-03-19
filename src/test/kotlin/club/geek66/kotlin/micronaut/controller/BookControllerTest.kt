package club.geek66.kotlin.micronaut.controller

import club.geek66.kotlin.micronaut.entity.Book
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import java.util.*
import javax.inject.Inject

/**
 *
 * @author: orange
 * @date: 2021/3/18
 * @time: 下午4:18
 * @copyright: Copyright 2021 by orange
 */
@MicronautTest
internal class BookControllerTest : FunSpec() {

	@Inject
	private lateinit var server: EmbeddedServer

	@Inject
	@field:Client("/")
	private lateinit var client: HttpClient

	init {
		test("test") {
			val exchange = client.toBlocking()
				.exchange(
					HttpRequest.POST("/books", Book(id = 0, name = "Think in java", pages = 100, category = null)),
					Book::class.java
				)
			exchange.status shouldBe HttpStatus.OK
			exchange.body shouldBe Optional.of(Book(id = 1, name = "Think in java", pages = 100, category = null))
		}
	}

}