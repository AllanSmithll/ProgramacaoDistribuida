package br.edu.ifpb.gugawag.so.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server {
    private static final List<String> files = new ArrayList<>(Arrays.asList("arquivo1.txt", "arquivo2.txt"));

    public static void main(String[] args) throws IOException {
        System.out.println("== Servidor ==");
        ServerSocket serverSocket = new ServerSocket(7001);

        try (Socket socket = serverSocket.accept();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            System.out.println("Cliente conectado: " + socket.getInetAddress());

            while (true) {
                String comando = dis.readUTF();
                System.out.println("Comando recebido: " + comando);
                String resposta = processarComando(comando);
                dos.writeUTF(resposta);
            }
        }
    }

    private static String processarComando(String comando) {
        try {
            String[] partes = comando.split(" ");
            switch (partes[0].toLowerCase()) {
                case "readdir":
                    return String.join(", ", files);
                case "rename":
                    return rename(partes[1], partes[2]);
                case "create":
                    return create(partes[1]);
                case "remove":
                    return remove(partes[1]);
                default:
                    return "Comando inválido!";
            }
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    private static String rename(String antigo, String novo) {
        if (files.contains(antigo)) {
            files.remove(antigo);
            files.add(novo);
            return "Arquivo renomeado com sucesso!";
        }
        return "Arquivo não encontrado!";
    }

    private static String create(String nome) {
        if (!files.contains(nome)) {
            files.add(nome);
            return "Arquivo criado com sucesso!";
        }
        return "Arquivo já existe!";
    }

    private static String remove(String nome) {
        if (files.remove(nome)) {
            return "Arquivo removido com sucesso!";
        }
        return "Arquivo não encontrado!";
    }
}
