package com.mohak1712.register;

import io.grpc.stub.ClientCalls;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: Register.proto")
public final class DiscoveryServiceGrpc {

  private DiscoveryServiceGrpc() {}

  public static final String SERVICE_NAME = "DiscoveryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Register,
      Response> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "register",
      requestType = Register.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Register,
      Response> getRegisterMethod() {
    io.grpc.MethodDescriptor<Register, Response> getRegisterMethod;
    if ((getRegisterMethod = DiscoveryServiceGrpc.getRegisterMethod) == null) {
      synchronized (DiscoveryServiceGrpc.class) {
        if ((getRegisterMethod = DiscoveryServiceGrpc.getRegisterMethod) == null) {
          DiscoveryServiceGrpc.getRegisterMethod = getRegisterMethod = 
              io.grpc.MethodDescriptor.<Register, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DiscoveryService", "register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Register.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new DiscoveryServiceMethodDescriptorSupplier("register"))
                  .build();
          }
        }
     }
     return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Register,
      Response> getDeregisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deregister",
      requestType = Register.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Register,
      Response> getDeregisterMethod() {
    io.grpc.MethodDescriptor<Register, Response> getDeregisterMethod;
    if ((getDeregisterMethod = DiscoveryServiceGrpc.getDeregisterMethod) == null) {
      synchronized (DiscoveryServiceGrpc.class) {
        if ((getDeregisterMethod = DiscoveryServiceGrpc.getDeregisterMethod) == null) {
          DiscoveryServiceGrpc.getDeregisterMethod = getDeregisterMethod = 
              io.grpc.MethodDescriptor.<Register, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "DiscoveryService", "deregister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Register.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new DiscoveryServiceMethodDescriptorSupplier("deregister"))
                  .build();
          }
        }
     }
     return getDeregisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DiscoveryServiceStub newStub(io.grpc.Channel channel) {
    return new DiscoveryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DiscoveryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DiscoveryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DiscoveryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DiscoveryServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DiscoveryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(Register request,
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void deregister(Register request,
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getDeregisterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Register,
                Response>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getDeregisterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Register,
                Response>(
                  this, METHODID_DEREGISTER)))
          .build();
    }
  }

  /**
   */
  public static final class DiscoveryServiceStub extends io.grpc.stub.AbstractStub<DiscoveryServiceStub> {
    private DiscoveryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiscoveryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscoveryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiscoveryServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(Register request,
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deregister(Register request,
        io.grpc.stub.StreamObserver<Response> responseObserver) {
      ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeregisterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DiscoveryServiceBlockingStub extends io.grpc.stub.AbstractStub<DiscoveryServiceBlockingStub> {
    private DiscoveryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiscoveryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscoveryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiscoveryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Response register(Register request) {
      return blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response deregister(Register request) {
      return blockingUnaryCall(
          getChannel(), getDeregisterMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DiscoveryServiceFutureStub extends io.grpc.stub.AbstractStub<DiscoveryServiceFutureStub> {
    private DiscoveryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiscoveryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscoveryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiscoveryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> register(
        Register request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> deregister(
        Register request) {
      return futureUnaryCall(
          getChannel().newCall(getDeregisterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_DEREGISTER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DiscoveryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DiscoveryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((Register) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_DEREGISTER:
          serviceImpl.deregister((Register) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DiscoveryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DiscoveryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return RegisterOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DiscoveryService");
    }
  }

  private static final class DiscoveryServiceFileDescriptorSupplier
      extends DiscoveryServiceBaseDescriptorSupplier {
    DiscoveryServiceFileDescriptorSupplier() {}
  }

  private static final class DiscoveryServiceMethodDescriptorSupplier
      extends DiscoveryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DiscoveryServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DiscoveryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DiscoveryServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getDeregisterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
