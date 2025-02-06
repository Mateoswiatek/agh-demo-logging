package pl.agh.demo.logging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonResource {

    private final Proces2 personService;
    private final Proces3 notificationService;

    @GetMapping("/test")
    public ResponseEntity<String> testProcess() {
        Person person = new Person(1L, "Mateusz", 23);

        log.info("Proces1 processing... personId: {}", person.id());

        personService.processAction(person);
        notificationService.processAction(person);

        log.info("Proces1 DONE! for personId: {}", person.id());
        return ResponseEntity.ok("Response from process!");
    }
}
