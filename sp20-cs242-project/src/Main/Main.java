package Main;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import GraphicUi.MainFrame;

public class Main {
	public static void main(String[] args) {


		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
	}

}
