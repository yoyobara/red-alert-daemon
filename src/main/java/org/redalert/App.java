package org.redalert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZoneOffset;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.json.JsonMapper;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        String jsonVal = Files.readString(Path.of("example.json"));
        JsonMapper mapper = new JsonMapper();
        Alert alert = mapper.readValue(jsonVal, Alert.class);
        System.out.println(alert.cities);
    }
}
