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
public class TempServer {
    public static void main(String args[]) throws Exception{
        Server server = ServerBuilder.forPort(8080)
            .addService(new TempServiceImpl())
            .build();

        //start the server
        server.start();

        System.out.println("Server started on port 50001");

        server.awaitTermination();
    }
}
