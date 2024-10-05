package org.redalert;

import java.util.List;

import io.restassured.RestAssured;

/**
 * observer
 */
public class RedNotifier {
    public static final int INTERVAL_MS = 1000;
    public static final String API_URL = "https://api.tzevaadom.co.il/notifications";

    private List<RedObserver> observers;


    public void addObserver(RedObserver observer) {
        this.observers.add(observer);
    }

    public void listen() throws InterruptedException {
        while (true) {
            Alert[] alerts = RestAssured.get(API_URL)
                .then()
                .statusCode(200)
                .extract()
                .as(Alert[].class);

            if (alerts.length > 0) {
                for (RedObserver observer : this.observers) {
                    observer.onRedAlert(alerts);
                }
            }

            Thread.sleep(INTERVAL_MS);
        }
    }
}
