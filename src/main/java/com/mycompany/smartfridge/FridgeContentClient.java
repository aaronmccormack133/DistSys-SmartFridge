/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smartfridge;

import com.google.protobuf.Empty;
import com.mycompany.smartfridge.FridgeContentProto.*;
import io.grpc.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Aaron
 */
public class FridgeContentClient {
    
    public FridgeContentClient(){
        getFoodDate();
    }
    
    public void getFoodDate(){
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext(true)
                .build();
        
        FridgeContentGrpc.FridgeContentBlockingStub stub = FridgeContentGrpc.newBlockingStub(channel);
        
        try{
            new Thread(){
                public void run(){
                    Empty request = Empty.newBuilder().build();
                    
                    Iterator<FoodDate> response = stub.getDatedFood(request);
                    while(response.hasNext()){
                        System.out.println(response.next().toString());
                    }
                }
            }.start();
        }
        catch(RuntimeException e){
            System.out.println(e);
            return;
        }
    }
    
    public static void main(String args[]) throws Exception{
        new FridgeContentClient();
    }
}
