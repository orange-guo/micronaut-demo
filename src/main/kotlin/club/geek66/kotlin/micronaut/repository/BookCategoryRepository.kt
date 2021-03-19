package club.geek66.kotlin.micronaut.repository

import club.geek66.kotlin.micronaut.entity.BookCategory
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

/**
 *
 * @author: orange
 * @date: 2021/3/19
 * @time: 下午4:06
 * @copyright: Copyright 2021 by orange
 */
@Repository
interface BookCategoryRepository : JpaRepository<BookCategory, Long>