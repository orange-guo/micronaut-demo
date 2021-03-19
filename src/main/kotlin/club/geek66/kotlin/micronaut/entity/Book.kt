package club.geek66.kotlin.micronaut.entity

import javax.persistence.*

/**
 * @author: orange
 * @date: 2021/3/17
 * @time: 下午12:06
 * @copyright: Copyright 2021 by orange
 */
@Entity
data class Book(
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long,
	var name: String,
	var pages: Int,
	@ManyToOne
	@JoinColumn(name = "category_id")
	var category: BookCategory?,
)