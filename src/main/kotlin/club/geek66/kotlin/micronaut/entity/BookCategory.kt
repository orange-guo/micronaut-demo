package club.geek66.kotlin.micronaut.entity

import javax.persistence.*

/**
 *
 * @author: orange
 * @date: 2021/3/19
 * @time: 下午4:02
 * @copyright: Copyright 2021 by orange
 */
@Entity
class BookCategory() {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	var id: Long = 0

	var name: String = "N/A"

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	var books: List<Book>? = emptyList()

	constructor(init: BookCategory.() -> Unit = {}) : this() {
		init()
	}

}