/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartfridge;

import com.mycompany.smartfridge.Fridgetemp.*;
import io.grpc.*;
import io.grpc.stub.StreamObserver;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Aaron
 */
public class TempServer {

    private Server server;

    private void start() throws Exception {
        server = ServerBuilder.forPort(8080)
                .addService(new TempServiceImpl())
                .build()
                .start();

        System.out.println("Server started on port 8080");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                server.shutdown();
                System.out.println("--------------------");
                System.out.println("Server shut down");
                System.out.println("--------------------");
            }
        });
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String args[]) throws Exception {
        TempServer server = new TempServer();
        server.start();
        server.blockUntilShutdown();
    }

    private class TempServiceImpl extends TempServiceGrpc.TempServiceImplBase {
        
        private double degrees = 5.0;

        @Override
        public void temp(Fridgetemp.TempRequest request, StreamObserver<Fridgetemp.TempReply> responseObserver) {
            System.out.println(request);

            //builder to construct new Protobuffer object
            Fridgetemp.TempReply response = Fridgetemp.TempReply.newBuilder()
                    .setOutput("Temperature of the fridge is: " + request.getTemp() + " degrees celsius")
                    .build();

            //Use response Observer to send a single response back
            responseObserver.onNext(response);

            // call oncompleted when its done
            responseObserver.onCompleted();
        }

        @Override
        public void decreasetemp(com.google.protobuf.Empty request, StreamObserver<Fridgetemp.Decrease> responseObserver) {
            Timer t = new Timer();

            t.schedule(new RemindTask(responseObserver), 0, 2000);
        }

        class RemindTask extends TimerTask {
            
            StreamObserver<Decrease> t;
            
            public RemindTask(StreamObserver<Decrease> t1){
                t = t1;
            }
            @Override
            public void run(){
                if(degrees > 0){
                    degrees -= 0.5;
                    Decrease decrease = Decrease.newBuilder().setTempdecrease(degrees).build();
                    t.onNext(decrease);
                }
                else{
                    t.onCompleted();
                    this.cancel();
                }
            }
        }
    }
}
