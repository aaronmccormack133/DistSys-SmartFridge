/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartfridge;

import com.google.protobuf.Empty;
import com.mycompany.smartfridge.Fridgetemp.*;
import io.grpc.*;
import java.util.Iterator;

/**
 *
 * @author Aaron
 */
public class TempDecreaseClient {

    public static void main(String args[]) throws Exception {

//        Fridgetemp.TempRequest request = Fridgetemp.TempRequest.newBuilder()
//                .setTemp(1)
//                .build();

        //Fridgetemp.TempReply response = stub.decreasetemp();
        //System.out.println(response);
        //channel.shutdown();     
        new TempDecreaseClient();
    }
    
    public TempDecreaseClient(){
        decreaseTemp();
    }

    public void decreaseTemp() {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext(true)
                .build();

        TempServiceGrpc.TempServiceBlockingStub stub = TempServiceGrpc.newBlockingStub(channel);

        try {
            new Thread() {
                public void run() {
                    Empty request = Empty.newBuilder().build();

                    Iterator<Decrease> response = stub.decreasetemp(request);
                    while(response.hasNext()){
                        System.out.println(response.next().toString());
                    }
                }
            }.start();            
        }
        catch (RuntimeException e){
            System.out.println(e);
            return;
        }
    }
}
