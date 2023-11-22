package com.binarfud.backend.service.implementation;

import com.binarfud.backend.dto.request.CreateUserRequest;
import com.binarfud.backend.dto.request.UpdateUserRequest;
import com.binarfud.backend.dto.response.CreateUserResponse;
import com.binarfud.backend.dto.response.DeleteUserResponse;
import com.binarfud.backend.dto.response.UpdateUserResponse;
import com.binarfud.backend.model.User;
import com.binarfud.backend.repository.UserRepository;
import com.binarfud.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SimpleUserService implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        return null;
    }

    @Override
    public UpdateUserResponse updateUser(UUID userId, UpdateUserRequest updateUserRequest) {
        var id = UUID.fromString(userRepository.updateUser(
                userId,
                updateUserRequest.getUsername(),
                updateUserRequest.getEmailAddress(),
                updateUserRequest.getPassword()
        ));

        var updateUserResponse = modelMapper.map(updateUserRequest, UpdateUserResponse.class);
        updateUserResponse.setId(id);

        return updateUserResponse;
    }

    @Override
    public DeleteUserResponse deleteUser(UUID userId) {
        userRepository.deleteUser(userId);
        return new DeleteUserResponse("User deleted successfully");
    }

}
