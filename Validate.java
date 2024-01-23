package event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import ui.*;

public class Validate implements KeyListener {
	private HomeUI editor;
	private File file;

	public Validate(HomeUI editor, File file) {
		this.editor = editor;
		this.file = file;
	}

	public void keyTyped(KeyEvent e) {
		if (file == null) {
			editor.setTitle("Untitled* - Notepad(Java)");
		} else if (file.exists()) {
			editor.setTitle(file.getName() + "* - Notepad(Java)");
		} else {
			System.out.println("nahi");
			editor.setTitle("Untitled* - Notepad(Java)");
		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

}
