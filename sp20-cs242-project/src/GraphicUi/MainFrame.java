package GraphicUi;


import java.io.File;
import java.util.*;  
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import PieceCreator.PieceCreatorImpl;
import object.Piece;
import object.Square;

import util.ImageUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar = new JMenuBar();;
	private JMenu menu_game = new JMenu("Game");

	private JMenu menu_record = new JMenu("Stat");

	private JMenuItem menuItem_game_exit = new JMenuItem("Exit");

	ButtonGroup groupRecord = new ButtonGroup();

	private JMenuItem lookRecord = new JMenuItem("View record");
	private JMenuItem clearRecord = new JMenuItem("Delete record");
	

	// level
	private JLabel levelTextLabel = new JLabel("Level");
	private JLabel levelLabel = new JLabel();// 
	private Box levelTextBox = Box.createHorizontalBox();
	private Box levelBox = Box.createHorizontalBox();

	// score
	private JLabel scoreTextLabel = new JLabel("Score");// 
	private JLabel scoreLabel = new JLabel();
	private Box scoreTextBox = Box.createHorizontalBox();
	private Box scoreBox = Box.createHorizontalBox();

	// Next
	private JLabel nextTextJLabel = new JLabel("Next");
	private Box nextTextBox = Box.createHorizontalBox();

	// resume
	private JLabel resumeJLabel = new JLabel();
	private Box resumeBox = Box.createHorizontalBox();

	// pause
	private JLabel pauseJLabel = new JLabel();
	private Box pauseBox = Box.createHorizontalBox();

	// start new game
	private JLabel startJLabel = new JLabel();
	private Box startBox = Box.createHorizontalBox();

	// score
	private int score = 0;
	// level
	private int currentLevel = 1;
	//
	private JPanel mainFrameJPanel = new JPanel();

	private JPanel toolPanel = new JPanel();
	private Box blankBox = Box.createHorizontalBox();

	private Square[][] squares;
	
	private GamePanel gamePanel;
	private PieceCreatorImpl pieceCreator = new PieceCreatorImpl();
	private Piece currentPiece, nextPiece;
	private Timer timer;
	// true->pause
	private boolean pauseFlag = false;

	//@SuppressWarnings("deprecation")
	public MainFrame() {
		menu_game.add(menu_record);

		menu_game.addSeparator();
		menu_game.add(menuItem_game_exit);

		menuBar.add(menu_game);

		groupRecord.add(lookRecord);
		groupRecord.add(clearRecord);
		menu_record.add(lookRecord);
		menu_record.add(clearRecord);

		this.setJMenuBar(menuBar);

		BoxLayout toolPanelLayout = new BoxLayout(this.toolPanel,
				BoxLayout.Y_AXIS);
		this.toolPanel.setLayout(toolPanelLayout);
		this.toolPanel.setBorder(new EtchedBorder());
		this.toolPanel.setBackground(Color.GRAY);

		// score
		this.scoreTextBox.add(this.scoreTextLabel);
		this.scoreLabel.setText(String.valueOf(this.score));
		this.scoreBox.add(scoreLabel);

		// level
		this.levelTextBox.add(this.levelTextLabel);
		this.levelLabel.setText(String.valueOf(this.currentLevel));
		this.levelBox.add(this.levelLabel);
		// restart
		this.resumeJLabel.setText("Restart");
		this.resumeJLabel.setPreferredSize(new Dimension(3, 25));
		this.resumeBox.add(this.resumeJLabel);
		// start
		this.startJLabel.setText("New Game");
		this.startJLabel.setPreferredSize(new Dimension(3, 25));
		this.startBox.add(this.startJLabel);
		// pause
		this.pauseJLabel.setText("Pause");
		this.pauseJLabel.setPreferredSize(new Dimension(3, 25));
		this.pauseBox.add(this.pauseJLabel);
		// next
		this.nextTextBox.add(this.nextTextJLabel);

		this.toolPanel.add(Box.createVerticalStrut(10));
		this.toolPanel.add(this.scoreTextBox);
		this.toolPanel.add(Box.createVerticalStrut(10));
		this.toolPanel.add(this.scoreBox);
		this.toolPanel.add(Box.createVerticalStrut(10));
		this.toolPanel.add(this.levelTextBox);
		this.toolPanel.add(Box.createVerticalStrut(10));
		this.toolPanel.add(this.levelBox);
		this.toolPanel.add(Box.createVerticalStrut(20));
		this.toolPanel.add(this.startBox);
		this.toolPanel.add(Box.createVerticalStrut(20));
		this.toolPanel.add(this.pauseBox);
		this.toolPanel.add(Box.createVerticalStrut(20));
		this.toolPanel.add(this.resumeBox);
		this.toolPanel.add(Box.createVerticalStrut(20));
		this.toolPanel.add(this.nextTextBox);

		this.blankBox.add(Box.createVerticalStrut(99));
		this.toolPanel.add(blankBox);
		
		this.toolPanel.setBackground(Color.white);
		/*
		this.setIconImage(MainFrame.toolkit
				.getImage("resource" + File.separator + "images"
						+ File.separator + "main_frame."));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}*/
		this.gamePanel = new GamePanel(this);
		this.setSize(448, 635);
		this.setLocation(250, 60);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Tetris");

		this.add(mainFrameJPanel);

		mainFrameJPanel.setLayout(null);
		mainFrameJPanel.add(this.gamePanel);
		this.gamePanel.setBounds(0, 0, this.getWidth() * 5 / 7,
				this.getHeight()*1217/1280);
		
		gamePanel.setVisible(true);
		mainFrameJPanel.add(this.toolPanel);
		this.toolPanel.setBounds(this.getWidth() * 5 / 7, 0,
				this.getWidth() * 2 / 7, this.getHeight());
		toolPanel.setVisible(true);
		setVisible(true);
		System.out.println("Welcome");

		initListeners();

	}//

	private void initListeners() {


		this.startJLabel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				start();
			}

		});

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					leftMove(1);
					break;
				case KeyEvent.VK_RIGHT:
					rightMove(1);
					break;
				case KeyEvent.VK_DOWN:
					down();
					break;
				case KeyEvent.VK_UP:
					change();
					break;
				}
			}

		});
	}// initListeners()

	public void down() {
		if (this.pauseFlag || this.currentPiece == null ) {
			return;
		}
		this.currentPiece.setSquaresYLocation(Piece.SQUARE_BORDER);
		this.gamePanel.repaint();
	}

	public void leftMove(int size) {
		if (this.pauseFlag || this.currentPiece == null 
				|| this.currentPiece.getMinXLocation() <= 0) {
			return;
		}
		this.currentPiece.setSquaresXLocation(-size * Piece.SQUARE_BORDER);
		this.gamePanel.repaint();
	}

	public void rightMove(int size) {
		if (this.pauseFlag
				|| this.currentPiece == null
			
				|| this.currentPiece.getMaxXLocation() + Piece.SQUARE_BORDER >= this.gamePanel
						.getWidth()) {
			return;
		}
		this.currentPiece.setSquaresXLocation(size * Piece.SQUARE_BORDER);
		this.gamePanel.repaint();
	}

                             

	private void change() {
		if (this.pauseFlag || this.currentPiece == null)
			return;
		this.currentPiece.change();


		int minX = this.currentPiece.getMinXLocation();
		if (minX < 0) {
			this.currentPiece.setSquaresXLocation(-minX);
		}
		int maxX = this.currentPiece.getMaxXLocation();
		if (maxX > this.gamePanel.getWidth()) {
			this.currentPiece.setSquaresXLocation(this.gamePanel.getWidth()
					- maxX);
		}
		this.gamePanel.repaint();
	}




	public Square[][] getSquares() {
		return squares;
	}

	public Square getSquare(int beginX, int beginY) {
		for (Square[] squares : this.squares) {
			for (Square square : squares) {
				if ((square.getImage() != null)
						&& (square.getBeginX() == beginX)
						&& (square.getBeginY() == beginY))
					return square;
			}
		}
		return null;
	}

	public Piece getCurrentPiece() {
		return currentPiece;
	}

	public Piece getNextPiece() {
		return nextPiece;
	}

	public GamePanel getGamePanel() {
		return this.gamePanel;
	}

	private void createNextPiece() {
		this.nextPiece = this.pieceCreator.createPiece(NEXT_X, NEXT_Y);
		this.repaint();
	}

	public void initSquares() {
		int x_size = this.gamePanel.getWidth() / Piece.SQUARE_BORDER;
		int y_size = this.gamePanel.getHeight() / Piece.SQUARE_BORDER;
		this.squares = new Square[x_size][y_size];
		for (int i = 0; i < this.squares.length; i++) {
			for (int j = 0; j < this.squares[i].length; j++) {
				this.squares[i][j] = new Square(Piece.SQUARE_BORDER * i,
						Piece.SQUARE_BORDER * j);
			}
		}

	}

	public void paint(Graphics g) {
		super.paint(g);
		if (this.nextPiece == null)
			return;
		ImageUtil.paintPiece(g, nextPiece);

	}


	private void start() {
		initSquares();
		if (this.timer != null) {
			this.timer.cancel();
		}
		createNextPiece();
		this.currentPiece = pieceCreator.createPiece(BEGIN_X, BEGIN_Y);

	}

	private static final int NEXT_X = 360;
	private static final int NEXT_Y = 520;
	private static final int BEGIN_X = Piece.SQUARE_BORDER * 8;
	private static final int BEGIN_Y = -Piece.SQUARE_BORDER * 2;
	static final Toolkit toolkit = Toolkit.getDefaultToolkit();

}// MainFrame

