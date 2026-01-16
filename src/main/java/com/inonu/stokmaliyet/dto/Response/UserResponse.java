package com.inonu.stokmaliyet.dto.Response;

import com.inonu.stokmaliyet.Enum.Role;

public record UserResponse(
        Long id,
        String username,
        Role role) {
}
