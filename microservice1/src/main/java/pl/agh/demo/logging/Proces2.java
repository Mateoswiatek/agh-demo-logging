package pl.agh.demo.logging;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableAsync
@AllArgsConstructor
public class Proces2 { // PersonService

    @Async
    @SneakyThrows
    public void processAction(Person person) {
        Thread.sleep(600);
        log.info("Proces2 - invoked. PersonId: {}", person.id());
        Thread.sleep(400);
        log.info("Proces2 - processing.... PersonId: {}", person.id());
    }
}
