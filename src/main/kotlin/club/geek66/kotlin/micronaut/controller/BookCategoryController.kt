package club.geek66.kotlin.micronaut.controller

import club.geek66.kotlin.micronaut.entity.BookCategory
import club.geek66.kotlin.micronaut.repository.BookCategoryRepository
import io.micronaut.http.annotation.*
import java.util.*

/**
 * @author: orange
 * @date: 2021/3/19
 * @time: 下午4:05
 * @copyright: Copyright 2021 by orange
 */
@Controller("bookCategories")
class BookCategoryController(
	private val repo: BookCategoryRepository
) {

	@Post
	fun create(bookCategory: BookCategory): BookCategory = repo.save(bookCategory).also(::println)

	@Get("{id}")
	fun get(id: Long): Optional<BookCategory> = repo.findById(id)

	@Delete("{id}")
	fun delete(@PathVariable id: Long) = repo.deleteById(id)

}