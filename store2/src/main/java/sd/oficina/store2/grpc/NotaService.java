package sd.oficina.store2.grpc;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import sd.oficina.shared.converter.ProtoConverterStore;
import sd.oficina.shared.model.store.Nota;
import sd.oficina.shared.proto.customer.*;
import sd.oficina.store2.daos.NotaDao;

import java.util.List;

public class NotaService extends NotaServiceGrpc.NotaServiceImplBase {

    private NotaDao notaDao;

    public NotaService() {
        this.notaDao = new NotaDao();
    }

    @Override
    public void salvar(NotaProto request, StreamObserver<NotaResult> responseObserver) {
        Nota nota = this.notaDao.salvar(ProtoConverterStore.protoToModel(request));

        if (!nota.equals(null)) {
            responseObserver.onNext(
                    NotaResult.newBuilder()
                            .setCodigo(200)
                            .setNota(ProtoConverterStore.modelToProto(nota))
                            .build());
        } else {
            responseObserver.onNext(
                    NotaResult.newBuilder()
                            .setCodigo(400)
                            .build());
        }

        responseObserver.onCompleted();
    }

    @Override
    public void atualizar(NotaProto request, StreamObserver<NotaResult> responseObserver) {
        Nota nota = this.notaDao.atualizar(ProtoConverterStore.protoToModel(request));

        if (!nota.equals(null)) {
            responseObserver
                    .onNext(NotaResult.newBuilder()
                            .setCodigo(200)
                            .setNota(ProtoConverterStore.modelToProto(nota)).build());
        } else {
            responseObserver
                    .onNext(NotaResult.newBuilder()
                            .setCodigo(400)
                            .build());
        }

        responseObserver.onCompleted();
    }

    @Override
    public void deletar(NotaProto request, StreamObserver<NotaResult> responseObserver) {
        this.notaDao.deletar(ProtoConverterStore.protoToModel(request));
        responseObserver.
                onNext(NotaResult.newBuilder()
                        .setCodigo(200)
                        .build());
        responseObserver.onCompleted();
    }

    @Override
    public void buscar(NotaProto request, StreamObserver<NotaResult> responseObserver) {
        Nota nota = this.notaDao.buscar(ProtoConverterStore.protoToModel(request));

        if (!nota.equals(null)) {
            responseObserver.onNext(NotaResult
                    .newBuilder()
                    .setCodigo(200)
                    .setNota(
                            ProtoConverterStore.modelToProto(nota))
                    .build());
        } else {
            responseObserver.onNext(NotaResult
                    .newBuilder()
                    .setCodigo(400)
                    .build());
        }

        responseObserver.onCompleted();
    }

    @Override
    public void buscarTodos(Empty request, StreamObserver<NotaProtoList> responseObserver) {
        List<Nota> notas = this.notaDao.listar();

        NotaProtoList.Builder builder = NotaProtoList.newBuilder();
        for (Nota nota : notas) {
            builder.addNota(ProtoConverterStore.modelToProto(nota));
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }
}