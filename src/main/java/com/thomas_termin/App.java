package com.thomas_termin;

import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.utils.Utils;

public class App {

    private static final int KEY_INDEX = 0;
    private static final int PARTITION_INDEX = 1;

    public static void main(String... args) {
        new App().doit(args);
    }

    private void printHelp() {
        System.out.println("Usage: kafka_partition <key::string> <number_of_partitions::integer>");
    }

    public void doit(String... args) {
        if (args.length < 2) {
            printHelp();
            System.exit(1);
        } else {
            int partitions = 0;
            try {
                partitions = Integer.parseInt(args[PARTITION_INDEX]);
            } catch (NumberFormatException e) {
                System.out.println("number of partitions must be a number");
                System.exit(1);
            }

            try (StringSerializer keySerializer = new StringSerializer()) {
                byte [] keyBytes = keySerializer.serialize(null, args[KEY_INDEX]);
                int partition = Utils.toPositive(Utils.murmur2(keyBytes)) % partitions;
                System.out.println(args[KEY_INDEX] + " " + partition);
            }

        }
    }
}
