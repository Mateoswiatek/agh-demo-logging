package pl.agh.demo.logging;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonResource {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/test")
    @SneakyThrows
    public ResponseEntity<String> testProcess() {
        Person person = new Person(1L, "Mateusz", 23);
        log.info("Proces1 processing... personId: {}", person.id());
        String url1 = "http://localhost:5002/process-action";
        String url2 = "http://localhost:5003/process-action";

        CompletableFuture<ResponseEntity<String>> future1 = CompletableFuture.supplyAsync(() ->
                restTemplate.postForEntity(url1, person, String.class));

        CompletableFuture<ResponseEntity<String>> future2 = CompletableFuture.supplyAsync(() ->
                restTemplate.postForEntity(url2, person, String.class));

        future1.thenAccept(response -> log.info("Response 1: {}", response.getBody()));
        future2.thenAccept(response -> log.info("Response 2: {}", response.getBody()));

        Thread.sleep(400);
        log.info("Proces1 DONE! for personId: {}", person.id());
        return ResponseEntity.ok("Response from process!");
    }
}
