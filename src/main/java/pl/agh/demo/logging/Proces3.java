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
public class Proces3 { // NotificationService

    @Async
    @SneakyThrows
    public void processAction(Person person) {
        Thread.sleep(1000);
        log.info("Proces3 - invoked. PersonId: {}", person.id());
        log.info("Proces3 - processing.... personId: {}", person.id());
    }
}
