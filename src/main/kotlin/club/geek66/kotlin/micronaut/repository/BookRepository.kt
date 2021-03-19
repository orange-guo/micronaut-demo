package club.geek66.kotlin.micronaut.repository

import club.geek66.kotlin.micronaut.entity.Book
import io.micronaut.context.annotation.Executable
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

/**
 *
 * @author: orange
 * @date: 2021/3/17
 * @time: 下午12:02
 * @copyright: Copyright 2021 by orange
 */
@Repository
interface BookRepository : CrudRepository<Book, Long> {

	@Executable
	fun find(name: String): Book

	@Executable
	fun find(name: String, pages: Int): Book

}
