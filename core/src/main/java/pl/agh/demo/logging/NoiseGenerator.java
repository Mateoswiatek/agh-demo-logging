package pl.agh.demo.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class NoiseGenerator {

    @Scheduled(initialDelay = 1000, fixedDelay = 200) // 5 - big Noise
    public void noise() {
        log.info("Noise logging {}", UUID.randomUUID());
    }
}
