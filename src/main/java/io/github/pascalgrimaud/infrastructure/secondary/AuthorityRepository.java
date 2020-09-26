package io.github.pascalgrimaud.infrastructure.secondary;

import io.github.pascalgrimaud.infrastructure.secondary.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
