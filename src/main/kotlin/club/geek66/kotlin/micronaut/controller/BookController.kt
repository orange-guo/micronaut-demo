package club.geek66.kotlin.micronaut.controller

import club.geek66.kotlin.micronaut.entity.Book
import club.geek66.kotlin.micronaut.repository.BookRepository
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

/**
 *
 * @author: orange
 * @date: 2021/3/17
 * @time: 下午12:07
 * @copyright: Copyright 2021 by orange
 */
@Controller("/books")
class BookController(
	private val repo: BookRepository
) {

	@Post
	fun create(book: Book): Book = repo.save(book).apply(::println)

}