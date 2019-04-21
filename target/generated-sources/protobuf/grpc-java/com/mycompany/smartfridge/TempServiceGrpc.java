package com.mycompany.smartfridge;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: fridgetemp.proto")
public final class TempServiceGrpc {

  private TempServiceGrpc() {}

  public static final String SERVICE_NAME = "com.mycompany.smartfridge.TempService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.mycompany.smartfridge.Fridgetemp.TempRequest,
      com.mycompany.smartfridge.Fridgetemp.TempReply> getTempMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "temp",
      requestType = com.mycompany.smartfridge.Fridgetemp.TempRequest.class,
      responseType = com.mycompany.smartfridge.Fridgetemp.TempReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.mycompany.smartfridge.Fridgetemp.TempRequest,
      com.mycompany.smartfridge.Fridgetemp.TempReply> getTempMethod() {
    io.grpc.MethodDescriptor<com.mycompany.smartfridge.Fridgetemp.TempRequest, com.mycompany.smartfridge.Fridgetemp.TempReply> getTempMethod;
    if ((getTempMethod = TempServiceGrpc.getTempMethod) == null) {
      synchronized (TempServiceGrpc.class) {
        if ((getTempMethod = TempServiceGrpc.getTempMethod) == null) {
          TempServiceGrpc.getTempMethod = getTempMethod = 
              io.grpc.MethodDescriptor.<com.mycompany.smartfridge.Fridgetemp.TempRequest, com.mycompany.smartfridge.Fridgetemp.TempReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "com.mycompany.smartfridge.TempService", "temp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.smartfridge.Fridgetemp.TempRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mycompany.smartfridge.Fridgetemp.TempReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TempServiceMethodDescriptorSupplier("temp"))
                  .build();
          }
        }
     }
     return getTempMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TempServiceStub newStub(io.grpc.Channel channel) {
    return new TempServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TempServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TempServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TempServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TempServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TempServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void temp(com.mycompany.smartfridge.Fridgetemp.TempRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.smartfridge.Fridgetemp.TempReply> responseObserver) {
      asyncUnimplementedUnaryCall(getTempMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTempMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.mycompany.smartfridge.Fridgetemp.TempRequest,
                com.mycompany.smartfridge.Fridgetemp.TempReply>(
                  this, METHODID_TEMP)))
          .build();
    }
  }

  /**
   */
  public static final class TempServiceStub extends io.grpc.stub.AbstractStub<TempServiceStub> {
    private TempServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempServiceStub(channel, callOptions);
    }

    /**
     */
    public void temp(com.mycompany.smartfridge.Fridgetemp.TempRequest request,
        io.grpc.stub.StreamObserver<com.mycompany.smartfridge.Fridgetemp.TempReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTempMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TempServiceBlockingStub extends io.grpc.stub.AbstractStub<TempServiceBlockingStub> {
    private TempServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mycompany.smartfridge.Fridgetemp.TempReply temp(com.mycompany.smartfridge.Fridgetemp.TempRequest request) {
      return blockingUnaryCall(
          getChannel(), getTempMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TempServiceFutureStub extends io.grpc.stub.AbstractStub<TempServiceFutureStub> {
    private TempServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TempServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TempServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TempServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mycompany.smartfridge.Fridgetemp.TempReply> temp(
        com.mycompany.smartfridge.Fridgetemp.TempRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTempMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TEMP = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TempServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TempServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TEMP:
          serviceImpl.temp((com.mycompany.smartfridge.Fridgetemp.TempRequest) request,
              (io.grpc.stub.StreamObserver<com.mycompany.smartfridge.Fridgetemp.TempReply>) responseObserver);
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

  private static abstract class TempServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TempServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mycompany.smartfridge.Fridgetemp.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TempService");
    }
  }

  private static final class TempServiceFileDescriptorSupplier
      extends TempServiceBaseDescriptorSupplier {
    TempServiceFileDescriptorSupplier() {}
  }

  private static final class TempServiceMethodDescriptorSupplier
      extends TempServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TempServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TempServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TempServiceFileDescriptorSupplier())
              .addMethod(getTempMethod())
              .build();
        }
      }
    }
    return result;
  }
}
