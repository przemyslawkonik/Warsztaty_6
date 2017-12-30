package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	public List<Comment> findByTweet(Tweet tweet);

	public List<Comment> findByTweetId(long id);
}
