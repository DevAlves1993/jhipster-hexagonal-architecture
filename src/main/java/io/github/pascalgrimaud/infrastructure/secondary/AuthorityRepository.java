package io.github.pascalgrimaud.infrastructure.secondary;

import io.github.pascalgrimaud.infrastructure.secondary.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link AuthorityEntity} entity.
 */
public interface AuthorityRepository extends JpaRepository<AuthorityEntity, String> {}
