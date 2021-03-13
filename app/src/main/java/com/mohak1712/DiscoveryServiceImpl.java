package com.mohak1712;

import com.mohak1712.register.DiscoveryServiceGrpc;
import com.mohak1712.register.Register;
import com.mohak1712.register.Response;
import io.envoyproxy.envoy.config.core.v3.Address;
import io.envoyproxy.envoy.config.core.v3.SocketAddress;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class DiscoveryServiceImpl extends DiscoveryServiceGrpc.DiscoveryServiceImplBase {

    private List<Address> addresses;

    public DiscoveryServiceImpl(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public void register(Register request, StreamObserver<Response> responseObserver) {
        Address address = Address.newBuilder().setSocketAddress(SocketAddress.newBuilder()
                .setAddress(request.getIp())
                .setPortValue(Integer.parseInt(request.getPort())).build())
                .build();
        addresses.add(address);
        responseObserver.onNext(Response.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();
    }

    @Override
    public void deregister(Register request, StreamObserver<Response> responseObserver) {
        Address address = Address.newBuilder().setSocketAddress(SocketAddress.newBuilder()
                .setAddress(request.getIp())
                .setPortValue(Integer.parseInt(request.getPort())).build())
                .build();
        addresses.remove(address);
        responseObserver.onNext(Response.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();
    }
}
