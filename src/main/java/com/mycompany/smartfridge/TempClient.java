/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.smartfridge;

import io.grpc.*;
import com.mycompany.smartfridge.TempGUI; 

/**
 *
 * @author Aaron
 */
public class TempClient {
    protected TempGUI ui;
    
    public static void main(String args[]) throws Exception {
//        java.awt.EventQueue.invokeLater(new Runnable(){
//            @Override
//            public void run() {
//                ui = new TempGUI(TempClient.this);
//                ui.setVisible(true);
//            }
//            
//        });
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
