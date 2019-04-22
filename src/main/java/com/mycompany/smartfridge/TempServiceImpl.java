/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.smartfridge;

import io.grpc.stub.StreamObserver;

/**
 *
 * @author Aaron
 */
public class TempServiceImpl extends TempServiceGrpc.TempServiceImplBase{
    @Override
    public void temp(Fridgetemp.TempRequest request, StreamObserver<Fridgetemp.TempReply> responseObserver){
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
    public void increasetemp(Fridgetemp.TempRequest request, StreamObserver<Fridgetemp.TempReply> responseObserver){
        System.out.println(request);
        
        Fridgetemp.TempReply response = Fridgetemp.TempReply.newBuilder()
                .setOutput("Increased temp by: " + request.getTemp() + " degrees celsius")
                .build();
        
        responseObserver.onNext(response);
        
        responseObserver.onCompleted();
    }
}
