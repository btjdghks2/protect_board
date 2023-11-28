package com.example.ItemOrderUser.service;

import com.example.ItemOrderUser.dto.userdto.UserDto;
import com.example.ItemOrderUser.dto.userdto.UserRequestDto;
import com.example.ItemOrderUser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Long join(UserDto dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));

        return userRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public Map<String, String> validateHandling(Errors errors) {
        Map<String,String> validatorResult = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()) {
            String validkeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validkeyName,error.getDefaultMessage());
        }
        return validatorResult;
    }

    public void checkUsernameDuplication(UserRequestDto dto) {
        boolean usernameDuplicate = userRepository.existsByUsername(dto.toEntity().getUsername());
    }


}
