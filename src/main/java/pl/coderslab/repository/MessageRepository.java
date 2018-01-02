package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

	public List<Message> findByReceiverIdOrderByCreatedDesc(long id);

	public List<Message> findBySenderIdOrderByCreatedDesc(long id);

	@Query("SELECT m FROM Message m WHERE m.receiver.id=:id OR m.sender.id=:id ORDER BY m.created DESC")
	public List<Message> findByUserId(@Param("id") long id);
}
