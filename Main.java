import ui.*;
import event.*;

public class Main {
	public Main() {
		HomeUI editor = new HomeUI(); // calling constructor for UI (Main UI class)
		Validate validateJTextArea = new Validate(editor, null);
		JMenuBarListener menuListener = new JMenuBarListener(editor, validateJTextArea);
		// applying ActionListener to menu file
		editor.fNew.addActionListener(menuListener);
		editor.fOpen.addActionListener(menuListener);
		editor.fSave.addActionListener(menuListener);
		editor.fSaveAs.addActionListener(menuListener);
		editor.exit.addActionListener(menuListener);
		 
		// applying Listener to menu edit
		editor.eCopy.addActionListener(menuListener);
		editor.eCut.addActionListener(menuListener);
		editor.ePaste.addActionListener(menuListener);
		editor.eDelete.addActionListener(menuListener);
		
		// applying listener to PopupMenu
		editor.pCopy.addActionListener(menuListener);
		editor.pCut.addActionListener(menuListener);
		editor.pPaste.addActionListener(menuListener);
		editor.pDelete.addActionListener(menuListener);
		editor.pSave.addActionListener(menuListener);
		
		//validating textarea
		editor.text.addKeyListener(validateJTextArea);
	}

	public static void main(String[] args) {
		new Main();
	}

}
