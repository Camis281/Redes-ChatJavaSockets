package com.example;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Criar um ServerSocket para escutar na porta 4444
            serverSocket = new ServerSocket(4444);
            System.out.println("Servidor escutando na porta 4444...");
        } catch (IOException e) {
            System.err.println("Não foi possível escutar na porta 4444.");
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            // Aceita a conexão do cliente
            clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado!");
        } catch (IOException e) {
            System.err.println("Falha no accept.");
            System.exit(1);
        }

        try (
            // Criar um PrintWriter para enviar dados ao cliente
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            // Criar um BufferedReader para ler dados do cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Cliente: " + inputLine);
                // Envia uma resposta de volta ao cliente
                out.println("Eco: " + inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
 * Para rodar usa :
 * 1 -javac -d bin src/com/example/*.java
 * 2- java -cp bin com.example.Server
 * 3 - java -cp bin com.example.Client (usa em ouro terminal)
 */

