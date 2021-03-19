package club.geek66.kotlin.micronaut.repository

import club.geek66.kotlin.micronaut.entity.Book
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.context.BeanContext
import io.micronaut.data.annotation.Query
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

/**
 * @author: orange
 * @date: 2021/3/17
 * @time: 下午2:46
 * @copyright: Copyright 2021 by orange
 */
@MicronautTest
class BookRepositoryTest(
	private val repo: BookRepository,
	private val ctx: BeanContext
) : FunSpec() {
	init {
		test("Test find by name") {
			ctx.getBeanDefinition(BookRepository::class.java)
				.getRequiredMethod<Any>("find", String::class.java)
				.annotationMetadata
				.stringValue(Query::class.java)
				.orElse(null) shouldBe
				"SELECT book_ FROM ${Book::class.qualifiedName} AS book_ WHERE (book_.name = :p1)"
		}
		test("Test find by name and pages") {
			ctx.getBeanDefinition(BookRepository::class.java)
				.getRequiredMethod<Any>("find", String::class.java, Int::class.java)
				.annotationMetadata
				.stringValue(Query::class.java)
				.get() shouldBe
				"SELECT book_ FROM ${Book::class.qualifiedName} AS book_ WHERE (book_.name = :p1 AND book_.pages = :p2)"
		}
		test("Test save") {
			Book(id = 0, name = "Think in java", pages = 30, category = null).also(repo::save)
			val book = repo.find(name = "Think in java")
			book.name shouldBe "Think in java"
			book.pages shouldBe 30
		}
	}
}