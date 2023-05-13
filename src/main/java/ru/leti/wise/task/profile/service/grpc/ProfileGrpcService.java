package ru.leti.wise.task.profile.service.grpc;

import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import ru.leti.wise.task.profile.ProfileGrpc;
import ru.leti.wise.task.profile.ProfileGrpc.SignInRequest;
import ru.leti.wise.task.profile.ProfileGrpc.SignInResponse;
import ru.leti.wise.task.profile.ProfileGrpc.SignUpResponse;
import ru.leti.wise.task.profile.ProfileGrpc.SignUpRequest;
import ru.leti.wise.task.profile.ProfileGrpc.GetAllProfilesResponse;
import ru.leti.wise.task.profile.ProfileServiceGrpc.ProfileServiceImplBase;
import ru.leti.wise.task.profile.logic.GetAllProfilesOperation;
import ru.leti.wise.task.profile.logic.SignInOperation;
import ru.leti.wise.task.profile.logic.SignUpOperation;

@Slf4j
@GRpcService
@RequiredArgsConstructor
public class ProfileGrpcService extends ProfileServiceImplBase {

    private final SignUpOperation signUpOperation;
    private final SignInOperation signInOperation;
    private final GetAllProfilesOperation getAllProfilesOperation;

    @Override
    public void signUp(SignUpRequest request, StreamObserver<SignUpResponse> responseObserver) {
        responseObserver.onNext(signUpOperation.activate(request));
        responseObserver.onCompleted();
    }

    @Override
    public void signIn(SignInRequest request, StreamObserver<SignInResponse> responseObserver) {
        responseObserver.onNext(signInOperation.activate(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getAllProfiles(Empty request, StreamObserver<GetAllProfilesResponse> responseObserver) {
        super.getAllProfiles(request, responseObserver);
    }
}
