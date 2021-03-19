package club.geek66.kotlin.micronaut.controller

import club.geek66.kotlin.micronaut.entity.BookCategory
import com.fasterxml.jackson.databind.ObjectMapper
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import javax.inject.Inject

@MicronautTest
class BookCategoryControllerTest : FunSpec() {

	@Inject
	private lateinit var server: EmbeddedServer

	@Inject
	@field:Client("/")
	private lateinit var client: HttpClient

	@Inject
	private lateinit var mapper: ObjectMapper

	init {
		test("test jackson") {
			mapper.readValue(
				"""
				{
				  "id": 0,
				  "name": "Java",
				  "books": []
				}
			""".trimIndent(), BookCategory::class.java
			)
		}
		test("integration") {
			client.toBlocking().use { client ->
				val id: Long = client.exchange(
					HttpRequest.POST("/bookCategories", BookCategory {
						name = "Java"
					}),
					BookCategory::class.java
				).let { response ->
					response.status shouldBe HttpStatus.OK
					response.body.get().run {
						id shouldBeGreaterThan 0
						name shouldBe "Java"
						id
					}
				}
				client.retrieve("/bookCategories/$id", BookCategory::class.java).run {
					name shouldBe "Java"
				}
				client.exchange<Any, Any>(HttpRequest.DELETE("/bookCategories/$id")).run {
					status shouldBe HttpStatus.OK
				}
			}

		}
	}

}
