package pl.agh.demo.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.github.loki4j.logback.json.AbstractFieldJsonProvider;
import com.github.loki4j.logback.json.JsonEventWriter;

import java.time.Instant;

public class LokiTimestampProvider extends AbstractFieldJsonProvider {

    @Override
    protected void writeExactlyOneField(JsonEventWriter jsonEventWriter, ILoggingEvent iLoggingEvent) {
        jsonEventWriter.writeStringField("@timestamp", Instant.now().toString());
    }
}


