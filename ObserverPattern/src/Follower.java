
public class Follower implements Observer {
	
	private String followerName;
	

	public Follower(String followerName) {
		this.followerName = followerName;
	}
	
	public String getFollowerName() {
		return this.followerName;
	}
	
	public void setFollowerName(String newName) {
		this.followerName = newName;
	}
	
	@Override
	public void update(String status) {
		System.out.println("Notifiying subscriber " + this.followerName + " of update.");
		
	}
	
	public void play() {
		System.out.println("Playing: Best of Jerry Sienfeld");
	}

}
