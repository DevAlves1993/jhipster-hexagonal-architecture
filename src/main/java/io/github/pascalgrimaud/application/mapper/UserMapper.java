package io.github.pascalgrimaud.application.mapper;

import io.github.pascalgrimaud.domain.UserDTO;
import io.github.pascalgrimaud.infrastructure.secondary.entity.AuthorityEntity;
import io.github.pascalgrimaud.infrastructure.secondary.entity.UserEntity;
import java.util.*;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * Mapper for the entity {@link UserEntity} and its DTO called {@link UserDTO}.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class UserMapper {

    public List<UserDTO> usersToUserDTOs(List<UserEntity> users) {
        return users.stream().filter(Objects::nonNull).map(this::userToUserDTO).collect(Collectors.toList());
    }

    public UserDTO userToUserDTO(UserEntity user) {
        return new UserDTO(user);
    }

    public List<UserEntity> userDTOsToUsers(List<UserDTO> userDTOs) {
        return userDTOs.stream().filter(Objects::nonNull).map(this::userDTOToUser).collect(Collectors.toList());
    }

    public UserEntity userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            UserEntity user = new UserEntity();
            user.setId(userDTO.getId());
            user.setLogin(userDTO.getLogin());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setImageUrl(userDTO.getImageUrl());
            user.setActivated(userDTO.isActivated());
            user.setLangKey(userDTO.getLangKey());
            Set<AuthorityEntity> authorities = this.authoritiesFromStrings(userDTO.getAuthorities());
            user.setAuthorities(authorities);
            return user;
        }
    }

    private Set<AuthorityEntity> authoritiesFromStrings(Set<String> authoritiesAsString) {
        Set<AuthorityEntity> authorities = new HashSet<>();

        if (authoritiesAsString != null) {
            authorities =
                authoritiesAsString
                    .stream()
                    .map(
                        string -> {
                            AuthorityEntity auth = new AuthorityEntity();
                            auth.setName(string);
                            return auth;
                        }
                    )
                    .collect(Collectors.toSet());
        }

        return authorities;
    }

    public UserEntity userFromId(Long id) {
        if (id == null) {
            return null;
        }
        UserEntity user = new UserEntity();
        user.setId(id);
        return user;
    }
}
