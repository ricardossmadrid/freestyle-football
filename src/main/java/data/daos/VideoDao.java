package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Video;

public interface VideoDao extends JpaRepository<Video, Integer> {

}
