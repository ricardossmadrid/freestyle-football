package business.wrapper;

public class BattleVoteWrapper {
	
	private int id;
	
	private String playerVoted;

	public BattleVoteWrapper() {
	}

	public BattleVoteWrapper(int id, String playerVoted) {
		this.id = id;
		this.playerVoted = playerVoted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerVoted() {
		return playerVoted;
	}

	public void setPlayerVoted(String playerVoted) {
		this.playerVoted = playerVoted;
	}

	@Override
	public String toString() {
		return "BattleVoteWrapper [id=" + id + ", playerVoted=" + playerVoted + "]";
	}

}
