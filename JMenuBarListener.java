package event;

import ui.*;
import main.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import java.awt.event.ActionEvent;

public class JMenuBarListener implements ActionListener {
	private HomeUI editor;
	public File file = null;
	private Validate validate;
	public JMenuBarListener(HomeUI editor, Validate validate) {
		this.editor = editor;
		this.validate = validate;
	}

	private void openFile() {
		Scanner fileIn;
		int response;
		StringBuffer line = new StringBuffer();
		JFileChooser chooser = new JFileChooser(".");

		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		response = chooser.showOpenDialog(null);
		if (response == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();

			try {
				fileIn = new Scanner(file);
				if (file.isFile()) {
					while (fileIn.hasNextLine()) {
						line.append(fileIn.nextLine() + "\n");
					}
				} else {
					System.out.println("Not a file");
				}
				fileIn.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			editor.setTitle(file.getName() + " - Notepad(Java)");
			editor.text.removeKeyListener(validate);
			validate = new Validate(editor, file);
			editor.text.addKeyListener(validate);
			editor.text.setText(line.toString());
		}
	}

	private void save() {
		if (file == null) {
			saveAs();
		} else if (file.exists()) {
			String text = editor.text.getText();
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(file);
				for (int l = text.length(), j = 0; l > 0; l--, j++) {
					fos.write(text.codePointAt(j));
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			editor.setTitle(file.getName() + " - Notepad(Java)");
		} else {
			saveAs();
		}
	}

	private void saveAs() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		int retrival = chooser.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try {
				file = chooser.getSelectedFile();
				file.createNewFile();
				save();
				editor.setTitle(file.getName() + " - Notepad(Java)");
				editor.text.removeKeyListener(validate);
				validate = new Validate(editor, file);
				editor.text.addKeyListener(validate);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		// for file menu
		if (e.getSource() == editor.fNew) {
			new Main();
		}
		if (e.getSource() == editor.fOpen) {
			openFile();
		}
		if (e.getSource() == editor.fSave) {
			save();
		}
		if (e.getSource() == editor.fSaveAs) {
			saveAs();
		}
		if (e.getSource() == editor.exit) {
			editor.dispose();
		}

		// for edit menu
		if (e.getSource() == editor.eCopy) {
			editor.text.copy();
		}
		if (e.getSource() == editor.eCut) {
			editor.text.cut();
		}
		if (e.getSource() == editor.ePaste) {
			editor.text.paste();
		}
		if (e.getSource() == editor.eDelete) {
			editor.text.replaceSelection("");
		}

		// for PopupMenu
		if (e.getSource() == editor.pCopy) {
			editor.text.copy();
		}
		if (e.getSource() == editor.pCut) {
			editor.text.cut();
		}
		if (e.getSource() == editor.pPaste) {
			editor.text.paste();
		}
		if (e.getSource() == editor.pDelete) {
			editor.text.replaceSelection("");
		}
		if (e.getSource() == editor.pSave) {
			save();
		}
	}

}
