package Hello

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter=AtomicLong()
    @CrossOrigin("*")
    @GetMapping("/greeting")
    fun greeting()=
            Greeting(counter.incrementAndGet(), "Hello World!")
}