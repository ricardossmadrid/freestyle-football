package business.wrapper;

public class BattleResponseWrapper {
	
	private int id;
	
	private String youtubeUrlChallenged;

	public BattleResponseWrapper() {
		
	}

	public BattleResponseWrapper(int id, String youtubeUrlChallenged) {
		this.id = id;
		this.youtubeUrlChallenged = youtubeUrlChallenged;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeUrlChallenged() {
		return youtubeUrlChallenged;
	}

	public void setYoutubeUrlChallenged(String youtubeUrlChallenged) {
		this.youtubeUrlChallenged = youtubeUrlChallenged;
	}

	@Override
	public String toString() {
		return "BattleResponseWrapper [id=" + id + ", youtubeUrlChallenged=" + youtubeUrlChallenged + "]";
	}

}
