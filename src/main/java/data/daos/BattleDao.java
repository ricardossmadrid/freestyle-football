package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import data.entities.Battle;
import data.entities.User;

public interface BattleDao extends JpaRepository<Battle, Integer> {

	List<Battle> findByPlayersOrderByBattleChallengeTimeDesc(User player);
}
