package br.edu.ifpb.gugawag.so.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) throws IOException {
        System.out.println("== Cliente ==");
        Socket socket = new Socket("127.0.0.1", 7001);

        try (DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Digite o comando: ");
                String comando = scanner.nextLine();
                dos.writeUTF(comando);

                String resposta = dis.readUTF();
                System.out.println("Servidor: " + resposta);
            }
        }
    }
}
