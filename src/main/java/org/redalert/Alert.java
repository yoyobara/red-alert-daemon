package org.redalert;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Alert {
    @JsonProperty
    private String notificationId;

    private LocalDateTime datetime;

    @JsonProperty
    private int threat;

    @JsonProperty
    private boolean isDrill;

    @JsonProperty
    public List<String> cities;

    @JsonSetter("time")
    public LocalDateTime setTheDateTime(int time) {
        return Instant.ofEpochSecond(time).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
