//--------------------[Song.java]--------------------

public class Song implements IComponent {
	public String songName;
	public String artist;
	public float speed = 1; // Default playback speed

	public Song(String songName, String artist ) {
		this.songName = songName;
		this.artist = artist; 
	}

	public String getArtist() {
		return this.artist;
	}

	@Override
	public void play() {
		System.out.println("Now playing: " + this.songName + " By: " + this.artist);
	}

	@Override
	public void setPlaybackSpeed(float speed) {
		System.out.println("Setting " + this.songName + " playback speed to: " + speed);
		this.speed = speed;
	}

	@Override
	public String getName() {
		return this.songName;
	}
	
}