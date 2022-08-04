package org.casdan.socialnetworkbackend.repositories;

import java.util.List;
import java.util.Optional;

import org.casdan.socialnetworkbackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByLogin(String login);
	
	Optional<User> findByToken(String token);
	
//	@Query(value = "select u from User where first_name like :term or last_name like :term or login like :term")
//	List<User> search(@Param("term") String term);
	
}
