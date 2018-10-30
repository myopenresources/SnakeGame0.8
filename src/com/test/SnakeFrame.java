package com.test;

import java.awt.Toolkit;

import javax.swing.JFrame;

import com.game.SnakeControl;
import com.game.SnakePanel;

public class SnakeFrame
{
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame snakeFrame = new JFrame("Snake Game");

		SnakePanel snakePanel = new SnakePanel();
		SnakeControl snakControl = new SnakeControl(snakePanel);
		snakeFrame.add("Center", snakePanel);
		snakeFrame.add("East", snakControl);

		Toolkit tok = Toolkit.getDefaultToolkit();
		int width = tok.getScreenSize().width;
		int height = tok.getScreenSize().height;

		snakeFrame.setBounds((width - 650) / 2, (height - 600) / 2, 680, 555);
		snakeFrame.setResizable(false);
		snakeFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		snakeFrame.setVisible(true);

	}

}
