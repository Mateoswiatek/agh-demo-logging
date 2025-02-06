package pl.agh.demo.logging;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MainComponent {
//    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DemologgingApplication.class);

    @PostConstruct
    public void init() {
        log.info("Wykonano mnie!");
        Person person = new Person(1L, "Mateusz", 23);
        f(person);
    }

    public static void f(Person person) {
        log.info("Main.f - invoked. personId:{}", person.id());

        boolean warunek = true;
        if(warunek) {
            log.warn("Spełniono");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    try{
                        log.debug("i:{} j:{}", i, j);
                    } catch (Exception e){
                        log.error("Błąd: {}",e.getMessage());
                    }
                }
            }
        }
    }
}
