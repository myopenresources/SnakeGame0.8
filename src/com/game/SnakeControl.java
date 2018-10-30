package com.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SnakeControl extends JPanel
{
	private static final long serialVersionUID = 1L;

	SnakePanel gamePanel;

	private JPanel northPanel, centerPanel, southPanel;
	private JLabel  sharp, sharp2, sharp3, icon, state;
	static JLabel speed, grade,score;
	private JButton set,startGame,  end;
	public static JButton start;
	public SnakeControl(SnakePanel snakePanel)
	{

		
		gamePanel = snakePanel;
		this.setPreferredSize(new Dimension(150, 510));
		
		northPanel = new JPanel();
		centerPanel = new JPanel();
		southPanel = new JPanel();

		northPanel.setLayout(new BorderLayout());
		southPanel.setLayout(new BorderLayout());

		sharp = new JLabel("          ---------------------");
		speed = new JLabel("          速度：" + gamePanel.snakeSpeed + "毫秒");
		grade = new JLabel("          等级：1" );
		score = new JLabel("游戏分数：0");
		sharp2 = new JLabel("       ---------------------       ");
		sharp3 = new JLabel("       ---------------------       ");

		icon = new JLabel(new ImageIcon("images\\icon.jpg"));
		state = new JLabel(new ImageIcon("images\\state.jpg"));

		set = new JButton("游戏设置");
		startGame = new JButton("开始游戏");
		start = new JButton("暂停游戏");
		end = new JButton("退出游戏");

		start.setEnabled(false);

		northPanel.add("North", sharp);
		northPanel.add("Center", speed);
		northPanel.add("South", grade);

		centerPanel.add(score);
		centerPanel.add(sharp2);
		centerPanel.add(set);
		centerPanel.add(startGame);
		centerPanel.add(start);
		centerPanel.add(end);
		centerPanel.add(sharp3);

		southPanel.add("North", icon);
		southPanel.add("Center", state);

		this.setLayout(new BorderLayout());
		this.add("North", northPanel);
		this.add("Center", centerPanel);
		this.add("South", southPanel);
		
		set.addActionListener(new ActionListener()
		{
			public void actionPerformed(final ActionEvent e)
			{
				SnakeSet snakeSet = new SnakeSet(gamePanel);
				snakeSet.setVisible(true);
			
			
				
			}
		});

		startGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(final ActionEvent e)
			{
				set.setEnabled(false);
				startGame.setEnabled(false);
				start.setEnabled(true);
				gamePanel.init();
				gamePanel.requestFocus();
			}
		});

		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(final ActionEvent e)
			{

				if (start.getActionCommand().equals("继续游戏"))
				{
					start.setText("暂停游戏");
					gamePanel.derail = true;
					gamePanel.requestFocus();
				}
				else if (start.getActionCommand().equals("暂停游戏"))
				{
					start.setText("继续游戏");
					gamePanel.derail = false;
					gamePanel.requestFocus();
				}

			}

		});

		end.addActionListener(new ActionListener()
		{
			public void actionPerformed(final ActionEvent e)
			{
				int in = JOptionPane.showConfirmDialog(null, "您确定要退出吗？", "提示",
						JOptionPane.YES_NO_OPTION);

				if (in == JOptionPane.YES_OPTION)
				{
					gamePanel.snakeDerail = false;
					System.exit(0);
				}

			}
		});

	}

	
}
