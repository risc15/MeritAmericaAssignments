import java.util.ArrayList;

//--------------------[Playlist.java]--------------------

public class Playlist implements IComponent {

	public String playlistName;
	public ArrayList<IComponent> playlist = new ArrayList<IComponent>();

	public Playlist(String playlistName) {
		this.playlistName = playlistName;
	}

	public void remove(IComponent component) {
		playlist.remove(component);
	}
	
	public void add(IComponent component) {
		playlist.add(component);
	}
	
	@Override
	public void play() {
		System.out.println("Now playing the playlist: " + this.playlistName);
		for(IComponent i: playlist) {
			i.play();
		}
	}
	
	@Override
	public void setPlaybackSpeed(float speed) {
		System.out.println("Setting speed of playlist: " + this.playlistName + " to " + speed);
		for(IComponent i: playlist) {
			i.setPlaybackSpeed(speed);
		}
	}

	@Override
	public String getName() {
		return this.playlistName;
	}
	
}