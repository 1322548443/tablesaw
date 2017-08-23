package tech.tablesaw.integration;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

import tech.tablesaw.api.Table;


public class Taxi {

    public static void main(String[] args) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        System.out.println("loading");
        Table trips;
        trips = Table.read().csv("/Users/larrywhite/downloads/yellow_tripdata_2016-01.csv");
        //trips = StorageManager.readTable("/Users/larrywhite/IdeaProjects/testdata/bigdata/Trips.saw");
        System.out.println(String.format("loaded %d records in %d seconds",
                trips.rowCount(),
                stopwatch.elapsed(TimeUnit.SECONDS)));
        out(trips.shape());
        out(trips.structure());
        trips.setName("Trips");
        trips.save("/Users/larrywhite/IdeaProjects/testdata/bigdata/");

        System.exit(0);

/*
        Column c = trips.column("total_amount");

        stopwatch.reset().start();
        // Create a grouping for subsequent queries
        ViewGroup vg = ViewGroup.create(trips, "passenger_count");
        out(String.format("Grouped %d records in %d ms",
                trips.rowCount(),
                stopwatch.elapsed(TimeUnit.MILLISECONDS)));

        stopwatch.reset().start();
        Table mean_total_fare = vg.reduce("total_amount", mean);
        out(String.format("Averaged %d records in %d ms",
                trips.rowCount(),
                stopwatch.elapsed(TimeUnit.MILLISECONDS)));
        out(mean_total_fare.print());

        stopwatch.reset().start();
        Table sum_total_fare = vg.reduce("total_amount", sum);
        out(String.format("Summed %d records in %d ms",
                trips.rowCount(),
                stopwatch.elapsed(TimeUnit.MILLISECONDS)));
        out(sum_total_fare.print());

        sum_total_fare = trips.sum("total_amount").by("passenger_count");
*/
    }

    private static void out(Object obj) {
        System.out.println(String.valueOf(obj));
    }

}
