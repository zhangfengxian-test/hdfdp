package ch11.remote;

import java.rmi.Naming;

public class MyRemoteClient {

    public static void main(String[] args) throws Exception {
        MyRemote service =
                (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
        System.out.println(service.sayHello());
    }

}
