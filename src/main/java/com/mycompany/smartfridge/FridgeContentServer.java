package com.mycompany.smartfridge;

import com.mycompany.smartfridge.FridgeContentProto.*;
import io.grpc.*;
import io.grpc.stub.StreamObserver;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aaron
 */
public class FridgeContentServer {
    private Server server;
    
    public static void main(String args[]) throws Exception{
        final FridgeContentServer server = new FridgeContentServer();
        server.start();
        server.blockUntilShutdown();
    }
    
    private void start() throws Exception{
        server = ServerBuilder.forPort(8080)
                .addService(new FridgeContentImpl())
                .build()
                .start();
        
        System.out.println("Server started on Port 8080");
        
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                server.shutdown();
                System.out.println("--------------------");
                System.out.println("Server shut down");
                System.out.println("--------------------");               
            }
        });
    }
    
    private void blockUntilShutdown() throws InterruptedException{
        if(server != null){
            server.awaitTermination();
        }
    }
    
    private class FridgeContentImpl extends FridgeContentGrpc.FridgeContentImplBase{
        private List<FoodDate> foods;
        
        public FridgeContentImpl(){
            foods = new ArrayList<FoodDate>();
            FoodDate food1 = FoodDate.newBuilder().setName("yoghurt").setDate(31).build();
            FoodDate food2 = FoodDate.newBuilder().setName("ham").setDate(15).build();
            FoodDate food3 = FoodDate.newBuilder().setName("cheese").setDate(21).build();
            FoodDate food4 = FoodDate.newBuilder().setName("milk").setDate(17).build();
            foods.add(food1);
            foods.add(food2);
            foods.add(food3);
            foods.add(food4);
        }
        
        @Override
        public void getDatedFood(com.google.protobuf.Empty request, StreamObserver<FoodDate> responseObserver){
            List<FoodDate> outOfDate = new ArrayList<FoodDate>();
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int dateNum = localDate.getDayOfMonth();
            List<Integer> dates = foods.stream().map(FoodDate::getDate).collect(Collectors.toList());
//            for(int i : dates){
//                if(i >= dateNum){
//                    System.out.println(dates);
//                }
//            }
            
            for(FoodDate fooddate : foods){
                if(fooddate.getDate() == dateNum){
                    outOfDate.add(fooddate);
                }
            }
            
            responseObserver.onNext(FoodDate.newBuilder().build());
            responseObserver.onCompleted();
        }
        
        class StreamTask extends TimerTask{
            StreamObserver<FoodDate> f;
            int index = 0;
            
            public StreamTask(StreamObserver<FoodDate> d){
                f = d;
            }
            
            @Override
            public void run(){
                if(index == foods.size()){
                    f.onCompleted();
                    this.cancel();
                }
                else{
                    f.onNext(foods.get(index++));
                }
            }
        }
    }
}
