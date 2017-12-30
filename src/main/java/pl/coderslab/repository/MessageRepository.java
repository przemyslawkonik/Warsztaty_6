package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

	public List<Message> findByReceiverId(long id);

	public List<Message> findBySenderId(long id);
}
