package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.User;
import data.entities.Video;

public interface VideoDao extends JpaRepository<Video, Integer> {
	
	List<Video> findByPlayer(User player);

}
