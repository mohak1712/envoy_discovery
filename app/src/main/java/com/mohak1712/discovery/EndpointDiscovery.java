package com.mohak1712.discovery;

import com.google.protobuf.Any;
import io.envoyproxy.envoy.config.core.v3.Address;
import io.envoyproxy.envoy.config.core.v3.SocketAddress;
import io.envoyproxy.envoy.config.endpoint.v3.ClusterLoadAssignment;
import io.envoyproxy.envoy.config.endpoint.v3.Endpoint;
import io.envoyproxy.envoy.config.endpoint.v3.LbEndpoint;
import io.envoyproxy.envoy.config.endpoint.v3.LocalityLbEndpoints;
import io.envoyproxy.envoy.service.discovery.v3.DeltaDiscoveryRequest;
import io.envoyproxy.envoy.service.discovery.v3.DeltaDiscoveryResponse;
import io.envoyproxy.envoy.service.discovery.v3.DiscoveryRequest;
import io.envoyproxy.envoy.service.discovery.v3.DiscoveryResponse;
import io.envoyproxy.envoy.service.endpoint.v3.EndpointDiscoveryServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class EndpointDiscovery extends EndpointDiscoveryServiceGrpc.EndpointDiscoveryServiceImplBase {

    private List<Address> addresses;

    public EndpointDiscovery(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public StreamObserver<DiscoveryRequest> streamEndpoints(StreamObserver<DiscoveryResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(DiscoveryRequest value) {
                if (addresses.isEmpty()) {
                    responseObserver.onNext(DiscoveryResponse.newBuilder()
                            .setTypeUrl(value.getTypeUrl())
                            .addResources(Any.newBuilder()
                                    .setTypeUrl(value.getTypeUrl())
                                    .setValue(ClusterLoadAssignment.getDefaultInstance().toBuilder()
                                            .setClusterName("some_service")
                                            .build().toByteString())
                                    .build())
                            .build());
                    return;
                }
                addresses.forEach(address -> {
                    ClusterLoadAssignment clusterLoadAssignment = ClusterLoadAssignment.newBuilder()
                            .setClusterName("some_service")
                            .addEndpoints(LocalityLbEndpoints.newBuilder()
                                    .addLbEndpoints(LbEndpoint.newBuilder()
                                            .setEndpoint(Endpoint.newBuilder()
                                                    .setAddress(Address.newBuilder()
                                                            .setSocketAddress(SocketAddress.newBuilder()
                                                                    .setAddress(address.getSocketAddress().getAddress())
                                                                    .setPortValue(address.getSocketAddress().getPortValue())
                                                                    .build())
                                                            .build())
                                                    .build())
                                            .build())
                                    .build())
                            .build();
                    responseObserver.onNext(DiscoveryResponse.newBuilder()
                            .setTypeUrl(value.getTypeUrl())
                            .addResources(Any.newBuilder()
                                    .setTypeUrl(value.getTypeUrl())
                                    .setValue(clusterLoadAssignment.toByteString())
                                    .build())
                            .build());

                });
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };
    }

    @Override
    public StreamObserver<DeltaDiscoveryRequest> deltaEndpoints(StreamObserver<DeltaDiscoveryResponse> responseObserver) {
        return super.deltaEndpoints(responseObserver);
    }

    @Override
    public void fetchEndpoints(DiscoveryRequest request, StreamObserver<DiscoveryResponse> responseObserver) {
        super.fetchEndpoints(request, responseObserver);
    }

}
