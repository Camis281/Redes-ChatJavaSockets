package com.example;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            // Cria um Socket para conectar ao servidor na porta 4444
            kkSocket = new Socket("localhost", 4444);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("O host localhost não foi encontrado.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Erro de IO com localhost.");
            System.exit(1);
        }

        try (
            // Cria um BufferedReader para ler entrada do usuário
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String userInput;
            System.out.println("Digite suas mensagens: ");
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                // Recebe e exibe a resposta do servidor
                System.out.println("Servidor: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                kkSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
