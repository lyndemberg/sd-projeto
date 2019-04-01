package sd.oficina.customer1.grpc;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import sd.oficina.customer1.dao.AnoModeloDao;
import sd.oficina.customer1.exceptions.AtributoIdInvalidoException;
import sd.oficina.customer1.exceptions.TentaPersistirObjetoNullException;
import sd.oficina.shared.converter.ProtoConverterCustomer;
import sd.oficina.shared.model.customer.AnoModelo;
import sd.oficina.shared.proto.customer.AnoModeloProto;
import sd.oficina.shared.proto.customer.AnoModeloProtoList;
import sd.oficina.shared.proto.customer.AnoModeloResult;
import sd.oficina.shared.proto.customer.AnoModeloServiceGrpc;

import java.io.Serializable;
import java.util.Optional;

public final class AnoModeloService extends AnoModeloServiceGrpc.AnoModeloServiceImplBase implements Serializable {

    private final AnoModeloDao anoModeloDao;

    public AnoModeloService() {
        this.anoModeloDao = new AnoModeloDao();
    }

    @Override
    public void buscarTodos(Empty request, StreamObserver<AnoModeloProtoList> responseObserver) {

        final AnoModeloProtoList.Builder builder = AnoModeloProtoList.newBuilder();

        anoModeloDao.listarTodos()
                .forEach(anoModelo -> builder.addAnoModelos(
                        ProtoConverterCustomer.modelToProto(anoModelo)
                ));

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void salvar(AnoModeloProto request, StreamObserver<AnoModeloResult> responseObserver) {

        AnoModelo anoModelo = ProtoConverterCustomer.protoToModel(request);

        try {
            Optional<AnoModelo> optional = this.anoModeloDao.salvar(anoModelo);

            if (optional.isPresent()) {

                AnoModelo anoModeloSalvo = optional.get();

                responseObserver.onNext(
                        AnoModeloResult
                                .newBuilder()
                                .setCodigo(200)
                                .setAnoModelo(
                                        ProtoConverterCustomer.modelToProto(anoModeloSalvo)
                                )
                                .build()
                );

            } else {
                responseObserver.onNext(
                        AnoModeloResult
                                .newBuilder()
                                .setCodigo(400)
                                .build()
                );

            }

        } catch (AtributoIdInvalidoException | TentaPersistirObjetoNullException ex) {
            ex.printStackTrace();

            responseObserver.onNext(
                    AnoModeloResult
                            .newBuilder()
                            .setCodigo(400)
                            .build()
            );

        } catch (Exception ex) {
            ex.printStackTrace();

            responseObserver.onNext(
                    AnoModeloResult
                            .newBuilder()
                            .setCodigo(500)
                            .build()
            );
        }

        responseObserver.onCompleted();
    }

    @Override
    public void atualizar(AnoModeloProto request, StreamObserver<AnoModeloResult> responseObserver) {

        AnoModelo anoModelo = ProtoConverterCustomer.protoToModel(request);

        try {
            Optional<AnoModelo> optional = this.anoModeloDao.atualizar(anoModelo);

            if (optional.isPresent()) {

                AnoModelo anoModeloSalvo = optional.get();

                responseObserver.onNext(
                        AnoModeloResult
                                .newBuilder()
                                .setCodigo(200)
                                .setAnoModelo(
                                        ProtoConverterCustomer.modelToProto(anoModeloSalvo)
                                )
                                .build()
                );

            } else {
                responseObserver.onNext(
                        AnoModeloResult
                                .newBuilder()
                                .setCodigo(400)
                                .build()
                );

            }

        } catch (AtributoIdInvalidoException | TentaPersistirObjetoNullException ex) {
            ex.printStackTrace();

            responseObserver.onNext(
                    AnoModeloResult
                            .newBuilder()
                            .setCodigo(400)
                            .build()
            );

        } catch (Exception ex) {
            ex.printStackTrace();

            responseObserver.onNext(
                    AnoModeloResult
                            .newBuilder()
                            .setCodigo(500)
                            .build()
            );
        }

        responseObserver.onCompleted();
    }

    @Override
    public void deletar(AnoModeloProto request, StreamObserver<AnoModeloResult> responseObserver) {

        AnoModelo anoModelo = ProtoConverterCustomer.protoToModel(request);

        try {
            Boolean foiRemovido = this.anoModeloDao.remover(anoModelo.getId());

            if (foiRemovido) {

                responseObserver.onNext(
                        AnoModeloResult
                                .newBuilder()
                                .setCodigo(200)
                                .build()
                );
            } else {

                responseObserver.onNext(
                        AnoModeloResult
                                .newBuilder()
                                .setCodigo(204)
                                .build()
                );
            }


        } catch (AtributoIdInvalidoException aiiEx) {
            aiiEx.printStackTrace();

            responseObserver.onNext(
                    AnoModeloResult
                            .newBuilder()
                            .setCodigo(400)
                            .build()
            );

        } catch (Exception ex) {
            ex.printStackTrace();

            responseObserver.onNext(
                    AnoModeloResult
                            .newBuilder()
                            .setCodigo(500)
                            .build()
            );
        }

        responseObserver.onCompleted();
    }

    @Override
    public void buscar(AnoModeloProto request, StreamObserver<AnoModeloResult> responseObserver) {

        AnoModelo anoModelo = ProtoConverterCustomer.protoToModel(request);

        try {

            Optional<AnoModelo> optional = this.anoModeloDao.buscarPorId(anoModelo.getId());

            if (optional.isPresent()) {

                AnoModelo anoModeloDB = optional.get();

                responseObserver.onNext(
                        AnoModeloResult
                                .newBuilder()
                                .setCodigo(200)
                                .setAnoModelo(
                                        ProtoConverterCustomer.modelToProto(anoModeloDB)
                                )
                                .build()
                );
            } else {

                responseObserver.onNext(
                        AnoModeloResult
                                .newBuilder()
                                .setCodigo(204)
                                .build()
                );
            }


        } catch (NullPointerException | AtributoIdInvalidoException ex) {
            ex.printStackTrace();

            responseObserver.onNext(
                    AnoModeloResult
                            .newBuilder()
                            .setCodigo(400)
                            .build()
            );
        } catch (Exception ex) {
            ex.printStackTrace();

            responseObserver.onNext(
                    AnoModeloResult
                            .newBuilder()
                            .setCodigo(500)
                            .build()
            );


        }

        responseObserver.onCompleted();
    }

}
