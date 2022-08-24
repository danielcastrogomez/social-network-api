package org.casdan.socialnetworkbackend.repositories;

import java.awt.print.Pageable;
import java.util.List;

import org.casdan.socialnetworkbackend.entities.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findByUserId(Long id);
	
	//Page<Message> findAll(Pageable pageable);

}
