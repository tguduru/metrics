package org.tugudu.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * A simple metrics reporter reports on console
 * @author Guduru, Thirupathi Reddy
 */

public class SimpleConsoleReporter {
    static MetricRegistry metricRegistry = new MetricRegistry();

    public static void main(final String[] args) throws InterruptedException {
        final ConsoleReporter consoleReporter = ConsoleReporter.forRegistry(metricRegistry)
                .convertDurationsTo(TimeUnit.SECONDS).build();
        consoleReporter.start(1, TimeUnit.SECONDS); // reports onto console for every second
        final Meter meter = metricRegistry.meter("main");
        meter.mark();
        doSomeWork();
    }

    private static void doSomeWork() throws InterruptedException {
        final Random random = new Random();
        final int randomValue = random.nextInt(10);
        System.out.println(randomValue);
        TimeUnit.SECONDS.sleep(randomValue);
    }
}
