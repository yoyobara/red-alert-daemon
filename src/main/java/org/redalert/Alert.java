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
    public void setTheDateTime(int time) {
        this.datetime = Instant.ofEpochSecond(time).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public String toString() {
        return String.format("{id: %s, datetime: %s, threat: %d, isdrill: %s, cities: %s}", notificationId, datetime, threat, isDrill, cities);
    }
}
