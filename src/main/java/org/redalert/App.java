package org.redalert;

import java.io.IOException;

/**
 * Hello world!
 */
public class App implements RedObserver {
    public static void main(String[] args) throws IOException, InterruptedException {
        RedNotifier notifier = new RedNotifier();
        notifier.addObserver(new App());

        notifier.listen();
    }

	@Override
	public void onRedAlert(Alert[] alert) {
        System.out.println("this is a red alert!");
	}
}
