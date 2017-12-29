package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

	public List<Tweet> findByUser(User u);

	public List<Tweet> findByUserId(long id);

	public List<Tweet> findAllByOrderByCreatedDesc();
}
