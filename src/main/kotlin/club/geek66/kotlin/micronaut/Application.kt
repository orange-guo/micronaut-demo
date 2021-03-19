package club.geek66.kotlin.micronaut

import io.micronaut.runtime.Micronaut
import kotlin.reflect.jvm.javaMethod

fun main(args: Array<String>) {
	Micronaut.build()
		.args(*args)
		.packages(::main.javaMethod!!.declaringClass.packageName)
		.start()
}