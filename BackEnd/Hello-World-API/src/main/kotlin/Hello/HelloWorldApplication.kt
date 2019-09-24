package Hello


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class HelloWorldApplication

fun main(args: Array<String>) {
	SpringApplication.run(HelloWorldApplication::class.java, *args)
}
