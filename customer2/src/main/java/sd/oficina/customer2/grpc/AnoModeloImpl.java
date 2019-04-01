package sd.oficina.customer2.grpc;

import sd.oficina.customer2.dao.AnoModeloDAO;
import sd.oficina.shared.model.customer.AnoModelo;
import com.google.protobuf.Empty;
import sd.oficina.shared.converter.ProtoConverterCustomer;
import io.grpc.stub.StreamObserver;
import sd.oficina.shared.proto.customer.AnoModeloProto;
import sd.oficina.shared.proto.customer.AnoModeloProtoList;
import sd.oficina.shared.proto.customer.AnoModeloResult;
import sd.oficina.shared.proto.customer.AnoModeloServiceGrpc;

import java.util.List;

public class AnoModeloImpl extends AnoModeloServiceGrpc.AnoModeloServiceImplBase {

    private AnoModeloDAO dao;

    public AnoModeloImpl() { dao = new AnoModeloDAO();}


    @Override
    public void buscarTodos(Empty request, StreamObserver<AnoModeloProtoList> responseObserver) {

        List<AnoModelo> anoModelos = dao.todos();
        final AnoModeloProtoList.Builder builder = AnoModeloProtoList.newBuilder();
        anoModelos.forEach(a -> builder.addAnoModelos(ProtoConverterCustomer.modelToProto(a)));
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void salvar(AnoModeloProto request, StreamObserver<AnoModeloResult> responseObserver) {
        AnoModelo result = this.dao.salvar(ProtoConverterCustomer.protoToModel(request));
        AnoModeloResult anoModeloResult = AnoModeloResult.newBuilder()
                .setCodigo(200)
                .setAnoModelo(ProtoConverterCustomer.modelToProto(result))
                .build();
        responseObserver.onNext(anoModeloResult);
        responseObserver.onCompleted();
    }

    @Override
    public void atualizar(AnoModeloProto request, StreamObserver<AnoModeloResult> responseObserver) {
        AnoModelo anoModelo = dao.atualizar(ProtoConverterCustomer.protoToModel(request));
        responseObserver.onNext(AnoModeloResult
                .newBuilder()
                .setAnoModelo(
                        anoModelo != null ? ProtoConverterCustomer.modelToProto(anoModelo) : AnoModeloProto.newBuilder().build()
                )
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void deletar(AnoModeloProto request, StreamObserver<AnoModeloResult> responseObserver) {
        this.dao.deletar(request.getId());
        responseObserver.onNext(AnoModeloResult.newBuilder().setCodigo(200).build());
        responseObserver.onCompleted();
    }

    @Override
    public void buscar(AnoModeloProto request, StreamObserver<AnoModeloResult> responseObserver) {
        AnoModelo anoModelo = dao.buscar(request.getId());
        responseObserver.onNext(AnoModeloResult
                .newBuilder()
                .setAnoModelo(
                        anoModelo != null ? ProtoConverterCustomer.modelToProto(anoModelo) : AnoModeloProto.newBuilder().build())
                .build());
        responseObserver.onCompleted();
    }
}
