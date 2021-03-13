package com.mohak1712;

import com.mohak1712.discovery.EndpointDiscovery;
import io.envoyproxy.envoy.config.core.v3.Address;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        List<Address> addresses = new ArrayList<>();
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new DiscoveryServiceImpl(addresses).bindService())
                .addService(new EndpointDiscovery(addresses).bindService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
