package club.geek66.kotlin.micronaut.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

/**
 *
 * @author: orange
 * @date: 2021/3/17
 * @time: 上午11:17
 * @copyright: Copyright 2021 by orange
 */
@Controller("/hello")
class HelloController {

	@Get(produces = [MediaType.TEXT_PLAIN])
	fun index(): String = "Hello World"

}