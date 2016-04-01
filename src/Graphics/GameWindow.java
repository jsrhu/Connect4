package Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.Controller;

public class GameWindow extends JFrame {

    private static JButton start, current, save, check, load;
    private static JLabel status;
    private static GameBoard board;
	private final String name = "Connect Four";
	public static void setCheck(JButton check) {
		GameWindow.check = check;
	}
	public static JButton getLoad() {
		return load;
	}
	public static void setLoad(JButton load) {
		GameWindow.load = load;
	}
	private Controller control;
    
    public GameWindow(int[][] x) {
        initComponents(x);
        setSize(680,675);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setName(name);
        setVisible(true);
    }
    private void initComponents(int[][] x) {
    	board = new GameBoard(x);
        start = new JButton("Start Game");
        current = new JButton("Current State");
        save = new JButton("Save");
        load = new JButton("Load");
        check = new JButton("Check");
        status = new JLabel("Select A Game Mode");
        control = new Controller(board, start, current, save, load, check);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(board);
        board.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        status.setFont(new java.awt.Font("Times New Roman", 0, 25));
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(current, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(load, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(board, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(current, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(load, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }
    public void update(String s, int[][] x){
    	board.setBoard(x);
    	board.repaint();
    	status.setText(s);
    }
	public static JButton getStart() {
		return start;
	}
	public static void setStart(JButton start) {
		GameWindow.start = start;
	}
	public static JButton getCurrent() {
		return current;
	}
	public static void setCurrent(JButton current) {
		GameWindow.current = current;
	}
	public static JButton getSave() {
		return save;
	}
	public static void setSave(JButton save) {
		GameWindow.save = save;
	}
	public static JButton getCheck() {
		return check;
	}
}
