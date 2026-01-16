package com.inonu.stokmaliyet.Mapper;

import com.inonu.stokmaliyet.Entity.User;
import com.inonu.stokmaliyet.dto.Response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getRole());
    }

    public List<UserResponse> toResponseList(List<User> userList) {
        if (userList == null) {
            return null;
        }
        return userList.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
