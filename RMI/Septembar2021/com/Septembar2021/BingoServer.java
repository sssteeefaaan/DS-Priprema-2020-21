package com.Septembar2021;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class BingoServer {
    public BingoServer() throws MalformedURLException, RemoteException, AlreadyBoundException
    {
        LocateRegistry.createRegistry(1099);
        Naming.bind("rmi://127.0.0.1:1099/BingoService", new BingoManagerImpl());
    }

    public static void main(String[] args)
    {
        try {
            new BingoServer();
            System.out.println("Server je pokrenut...\nPritisnite Enter za kraj...");

            Scanner s = new Scanner(System.in);
            s.nextLine();
            s.close();
            System.exit(0);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
