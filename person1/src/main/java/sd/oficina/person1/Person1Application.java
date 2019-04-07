package sd.oficina.person1;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import sd.oficina.person1.grpc.CidadeService;
import sd.oficina.person1.grpc.ClienteService;
import sd.oficina.person1.grpc.EstadoService;
import sd.oficina.person1.grpc.FornecedorService;

import java.io.IOException;

public class Person1Application {
    public static void main(String[] args) {

        //
        System.out.println("Servidor Person 1 inicializado");
        //

        //Inicializando o server
        Server server = ServerBuilder
                .forPort(3333)
                .addService((BindableService) new CidadeService())
                .addService((BindableService) new ClienteService())
                .addService((BindableService) new EstadoService())
                .addService((BindableService) new FornecedorService())
                .build();

        try {
            server.start();
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
