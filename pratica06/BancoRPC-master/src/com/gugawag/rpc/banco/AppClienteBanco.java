package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String ipServidor = "localhost";

        Registry registry = LocateRegistry.getRegistry(ipServidor);
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while (opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    System.out.println(banco.saldo(conta));
                    break;
                }
                case 2: {
                    System.out.println(banco.quantidadeContas());
                    break;
                }
                case 3: {
                    System.out.println("Digite o número da conta:");
                    String numero = entrada.next();
                    System.out.println("Digite o saldo da conta:");
                    double saldo = entrada.nextDouble();
                    Conta conta = new Conta(numero, saldo);
                    banco.adicionarConta(conta);
                    System.out.println("Conta criada: " + conta.getNumero() + " - " + conta.getSaldo());
                    break;
                }
                case 4: {
                    System.out.println("Digite o número da conta:");
                    String numero = entrada.next();
                    Conta conta = banco.pesquisarConta(numero);
                    if (conta != null) {
                        System.out.println("Conta encontrada: " + conta.getNumero() + " - " + conta.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Digite o número da conta:");
                    String numero = entrada.next();
                    banco.removerConta(numero);
                    System.out.println("Conta removida");
                    break;
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("\n=== BANCO RMI ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Cadastro de nova conta");
        System.out.println("4 - Pesquisa de conta");
        System.out.println("5 - Remoção de conta");
        System.out.println("9 - Sair");
    }
}