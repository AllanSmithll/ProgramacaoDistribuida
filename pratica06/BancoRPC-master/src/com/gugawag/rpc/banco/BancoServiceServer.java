package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {
    private final List<Conta> contas = new ArrayList<>();

    public BancoServiceServer() throws RemoteException {}

    @Override
    public double saldo(String conta) throws RemoteException {
        for (Conta c : contas) {
            if (c.getNumero().equals(conta)) {
                return c.getSaldo();
            }
        }
        return 0;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void adicionarConta(Conta conta) throws RemoteException {
        contas.add(conta);
    }

    @Override
    public Conta pesquisarConta(String numero) throws RemoteException {
        for (Conta c : contas) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void removerConta(String numero) throws RemoteException {
        for (Conta c : contas) {
            if (c.getNumero().equals(numero)) {
                contas.remove(c);
                break;
            }
        }
    }
}
