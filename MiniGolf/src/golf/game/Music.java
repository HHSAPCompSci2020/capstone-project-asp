package golf.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;

public class Music extends JPanel implements ActionListener, JayLayerListener {
	private JayLayer sound;

	public Music() {
		// super();

		String[] soundEffects = new String[] {"coconutmall.mp3", "fizzdintimate.mp3","thepast.mp3"};
		String[] songs = new String[] {"coconutmall.mp3", "fizzdintimate.mp3","thepast.mp3"};

		sound = new JayLayer("Assets/", "Assets/", false);
		sound.addPlayList();
		sound.addSongs(0, songs);
		sound.addSoundEffects(soundEffects);
		sound.changePlayList(0);
		sound.addJayLayerListener(this);

		// TODO Add more customizations to the panel

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		sound.nextSong();
	}

	@Override
	public void songEnded() {
		sound.stopSong();
	}

	@Override
	public void playlistEnded() {
	}

	@Override
	public void musicStarted() {
	}

	@Override
	public void musicStopped() {
	}

}

