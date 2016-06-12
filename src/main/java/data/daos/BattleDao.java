package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Battle;

public interface BattleDao extends JpaRepository<Battle, Integer> {

}
