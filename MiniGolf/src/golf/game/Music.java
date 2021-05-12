package golf.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import jay.jaysound.JayLayer;
import jay.jaysound.JayLayerListener;

public class Music extends JPanel implements ActionListener, JayLayerListener {
	private JComboBox<String> effects;
	private JayLayer sound;

	public Music() {
		super();

		// String[] soundEffects = new
		// String[]{"title1.mp3","title2.mp3","title3.mp3","title4.mp3","title5.mp3"};
		String[] songs = new String[] { "Assets/QuirkyWorky.mp3" };

		// effects = new JComboBox<String>(soundEffects);
		sound = new JayLayer("audio/", "audio/", false);
		sound.addPlayList();
		sound.addSongs(0, songs);
		// sound.addSoundEffects(soundEffects);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void playlistEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void musicStarted() {

	}

	@Override
	public void musicStopped() {

	}
}
