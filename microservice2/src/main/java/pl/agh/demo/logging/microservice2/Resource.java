package pl.agh.demo.logging.microservice2;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.demo.logging.Person;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Resource {

    @GetMapping("/smoke")
    public ResponseEntity<String> getPerson() {
        return ResponseEntity.ok("Smoke");
    }

    @SneakyThrows
    @PostMapping("/process-action")
    public ResponseEntity<String> processAction(@RequestBody Person person) {
        Thread.sleep(600);
        log.atInfo().setMessage("Microservice2 - invoked. PersonId: {}").addArgument(person.id()).addKeyValue("personId", person.id()).log();
        Thread.sleep(400);
        log.atInfo().setMessage("Microservice2 - processing... PersonId: {}").addArgument(person.id()).addKeyValue("personId", person.id()).log();
        return ResponseEntity.ok("Microservice2 - processed");
    }
}
