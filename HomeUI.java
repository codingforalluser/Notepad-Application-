package ui;

import javax.swing.*;
import java.awt.*;

public class HomeUI extends JFrame {
	/**
	 * Class for Designing the UI
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea text = new JTextArea();
	// creating MenuBar
	public JMenuBar menu = new JMenuBar();
	// file menu
	public JMenu file = new JMenu("File");
	public JMenuItem fNew = new JMenuItem("New File");
	public JMenuItem fOpen = new JMenuItem("Open File");
	public JMenuItem fSave = new JMenuItem("Save");
	public JMenuItem fSaveAs = new JMenuItem("Save As");
	public JMenuItem exit = new JMenuItem("Exit");
	// edit menu
	public JMenu edit = new JMenu("Edit");
	public JMenuItem eCopy = new JMenuItem("Copy");
	public JMenuItem eCut = new JMenuItem("Cut");
	public JMenuItem ePaste = new JMenuItem("Paste");
	public JMenuItem eDelete = new JMenuItem("Delete");
	// view menu
	public JMenu view = new JMenu("View");
	// creating PopupMenu
	public JPopupMenu pmenu = new JPopupMenu();
	public JMenuItem pCopy = new JMenuItem("Copy");
	public JMenuItem pCut = new JMenuItem("Cut");
	public JMenuItem pPaste = new JMenuItem("Paste");
	public JMenuItem pDelete = new JMenuItem("Delete");
	public JMenuItem pSave = new JMenuItem("Save");

	public HomeUI() {
		super("Untitled - Notepad(Java)");

		// file menu
		fNew.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		file.add(fNew);
		fOpen.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		file.add(fOpen);
		file.addSeparator();
		fSave.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		file.add(fSave);
		fSaveAs.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		file.add(fSaveAs);
		exit.setAccelerator(KeyStroke.getKeyStroke('E', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		file.add(exit);

		// edit menu
		eCopy.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		edit.add(eCopy);
		eCut.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		edit.add(eCut);
		ePaste.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		edit.add(ePaste);
		eDelete.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		edit.add(eDelete);

		// adding menus into JMenuBar
		menu.add(file);
		menu.add(edit);
//		menu.add(view);

		// adding menu to JFrame
		this.setJMenuBar(menu);

		// adding MenuItems to PopupMenu
		pCopy.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		pmenu.add(pCopy);
		pCut.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		pmenu.add(pCut);
		pPaste.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		pmenu.add(pPaste);
		pDelete.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		pmenu.add(pDelete);
		pmenu.addSeparator();
		pSave.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		pmenu.add(pSave);

		// adding PopupMenu to JTextArea
		text.setComponentPopupMenu(pmenu);

		// adding JTextArea
		text.setMargin(new Insets(10, 10, 10, 10));
		text.setFont(new Font("Arial", Font.PLAIN, 14));
		text.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(text);
		this.add(scroll);

		this.setVisible(true);
		this.setBounds(150, 100, 600, 400);
//		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.validate();
	}
}
