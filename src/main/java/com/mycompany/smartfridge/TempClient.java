/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.smartfridge;

import io.grpc.*;

/**
 *
 * @author Aaron
 */
public class TempClient {
    public static void main(String args[]) throws Exception {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext(true)
                .build();
        
        TempServiceGrpc.TempServiceBlockingStub stub = TempServiceGrpc.newBlockingStub(channel);
        Fridgetemp.TempRequest request = Fridgetemp.TempRequest.newBuilder()
                .setTemp(2)
                .build();
        
        Fridgetemp.TempReply response = stub.temp(request);
        
        System.out.println(response);
        
        channel.shutdown();
    }
}
