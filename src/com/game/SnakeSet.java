package com.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SnakeSet extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel northPanel, centerPanel, southPanel;
	private JPanel selectPanel, modePanel;
	private JPanel foodPanel, headPanel, bodyPanel;
	private JLabel selectLabel, foodLabel, headLabel, bodyLabel;
	private JRadioButton briefness, medium, difficulty;
	private ButtonGroup bg;
	private JPanel foodColorPanel, foodSelectPanel;
	private JRadioButton foodRed, foodGreen, foodBlue, foodYellow, foodOrange;
	private ButtonGroup bg2;
	private JPanel headColorPanel, headSelectPanel;
	private JRadioButton headRed, headGreen, headBlue, headYellow, headOrange;
	private ButtonGroup bg3;
	private JPanel bodyColorPanel, bodySelectPanel;
	private JRadioButton bodyRed, bodyGreen, bodyBlue, bodyYellow, bodyOrange;
	private ButtonGroup bg4;
	private JPanel showPanel, defaultPanel, buttonPanel;
	private JRadioButton showGrid, cancelGrid;
	private ButtonGroup bg5;
	private JButton defaultButton, confirm, cancel;
	private SnakePanel setPanel;

	public SnakeSet(SnakePanel snakePanel)
	{
		setPanel = snakePanel;

		northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());

		selectPanel = new JPanel();
		modePanel = new JPanel();

		selectLabel = new JLabel("ѡ�񼶱�");
		selectLabel.setForeground(Color.red);
		briefness = new JRadioButton("��");
		medium = new JRadioButton("�е�");
		difficulty = new JRadioButton("����");

		bg = new ButtonGroup();
		bg.add(briefness);
		bg.add(medium);
		bg.add(difficulty);

		selectPanel.add(selectLabel);
		modePanel.add(briefness);
		modePanel.add(medium);
		modePanel.add(difficulty);

		northPanel.add("North", selectPanel);
		northPanel.add("Center", modePanel);

		foodPanel = new JPanel();
		foodPanel.setLayout(new BorderLayout());

		foodColorPanel = new JPanel();
		foodSelectPanel = new JPanel();

		foodLabel = new JLabel("ʳ����ɫ");
		foodLabel.setForeground(Color.red);
		foodBlue = new JRadioButton("��");
		
		foodRed = new JRadioButton("��");
		foodGreen = new JRadioButton("��");
		foodYellow = new JRadioButton("��");
		foodOrange = new JRadioButton("��");

		bg2 = new ButtonGroup();
		bg2.add(foodBlue);
		bg2.add(foodRed);
		bg2.add(foodGreen);
		bg2.add(foodYellow);
		bg2.add(foodOrange);

		foodColorPanel.add(foodLabel);
		foodSelectPanel.add(foodBlue);
		foodSelectPanel.add(foodRed);
		foodSelectPanel.add(foodGreen);
		foodSelectPanel.add(foodYellow);
		foodSelectPanel.add(foodOrange);

		foodPanel.add("North", foodColorPanel);
		foodPanel.add("Center", foodSelectPanel);

		headPanel = new JPanel();
		headPanel.setLayout(new BorderLayout());

		headColorPanel = new JPanel();
		headSelectPanel = new JPanel();

		headLabel = new JLabel("��ͷ��ɫ");
		headLabel.setForeground(Color.red);
		headBlue = new JRadioButton("��");
		
		headRed = new JRadioButton("��");
		headGreen = new JRadioButton("��");
		headYellow = new JRadioButton("��");
		headOrange = new JRadioButton("��");

		bg3 = new ButtonGroup();
		bg3.add(headBlue);
		bg3.add(headRed);
		bg3.add(headGreen);
		bg3.add(headYellow);
		bg3.add(headOrange);

		headPanel.add(headLabel);
		headColorPanel.add(headLabel);
		headSelectPanel.add(headBlue);
		headSelectPanel.add(headRed);
		headSelectPanel.add(headGreen);
		headSelectPanel.add(headYellow);
		headSelectPanel.add(headOrange);

		headPanel.add("North", headColorPanel);
		headPanel.add("Center", headSelectPanel);

		bodyPanel = new JPanel();
		bodyPanel.setLayout(new BorderLayout());

		bodyColorPanel = new JPanel();
		bodySelectPanel = new JPanel();

		bodyLabel = new JLabel("������ɫ");
		bodyLabel.setForeground(Color.red);
		bodyRed = new JRadioButton("��");
		
		bodyGreen = new JRadioButton("��");
		bodyBlue = new JRadioButton("��");
		bodyYellow = new JRadioButton("��");
		bodyOrange = new JRadioButton("��");

		bg4 = new ButtonGroup();
		bg4.add(bodyRed);
		bg4.add(bodyGreen);
		bg4.add(bodyBlue);
		bg4.add(bodyYellow);
		bg4.add(bodyOrange);

		bodyPanel.add(bodyLabel);
		bodyColorPanel.add(bodyLabel);
		bodySelectPanel.add(bodyRed);
		bodySelectPanel.add(bodyGreen);
		bodySelectPanel.add(bodyBlue);
		bodySelectPanel.add(bodyYellow);
		bodySelectPanel.add(bodyOrange);

		bodyPanel.add("North", bodyColorPanel);
		bodyPanel.add("Center", bodySelectPanel);

		centerPanel.add("North", foodPanel);
		centerPanel.add("Center", headPanel);
		centerPanel.add("South", bodyPanel);

		showPanel = new JPanel();
		defaultPanel = new JPanel();
		buttonPanel = new JPanel();

		showGrid = new JRadioButton("��ʾ����");
		cancelGrid = new JRadioButton("ȡ������");
		
		bg5 = new ButtonGroup();
		bg5.add(showGrid);
		bg5.add(cancelGrid);

		defaultButton = new JButton("Ĭ������");
		confirm = new JButton("ȷ��");
		cancel = new JButton("ȡ��");

		showPanel.add(showGrid);
		showPanel.add(cancelGrid);
		defaultPanel.add(defaultButton);
		buttonPanel.add(confirm);
		buttonPanel.add(cancel);

		southPanel.add("North", showPanel);
		southPanel.add("Center", defaultPanel);
		southPanel.add("South", buttonPanel);
		
		briefness.setSelected(true);
		foodBlue.setSelected(true);
		headBlue.setSelected(true);
		bodyRed.setSelected(true);
		cancelGrid.setSelected(true);
		

		this.add("North", northPanel);
		this.add("Center", centerPanel);
		this.add("South", southPanel);

		Toolkit tok = Toolkit.getDefaultToolkit();
		int width = tok.getScreenSize().width;
		int height = tok.getScreenSize().height;
		this.setBounds((width - 260) / 2, (height - 370) / 2, 260, 405);
		this.setTitle("��Ϸ����");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		
		defaultButton .addActionListener(new ActionListener()
		{
			public void actionPerformed(final ActionEvent e)
			{
				
				briefness.setSelected(true);
				foodBlue.setSelected(true);
				headBlue.setSelected(true);
				bodyRed.setSelected(true);
				cancelGrid.setSelected(true);
				
				
			}
		});
		confirm.addActionListener(new ActionListener()
		{
			public void actionPerformed(final ActionEvent e)
			{
				if (briefness.isSelected())
				{
					setPanel.mode = SnakeConstant.BRIEFNESS;
				}
				if (medium.isSelected())
				{
					setPanel.mode = SnakeConstant.SECONDARY;
				}
				if (difficulty.isSelected())
				{
					setPanel.mode = SnakeConstant.DIFFICULTY;
				}
				if(foodBlue.isSelected()){
					setPanel.foodColor=SnakeConstant.SNAKEBLUE;
				}
				if(foodRed.isSelected()){
					setPanel.foodColor=SnakeConstant.SNAKERED;
				}
				if(foodGreen.isSelected()){
					setPanel.foodColor=SnakeConstant.SNAKEGREEN;
				}
				if(foodYellow.isSelected()){
					setPanel.foodColor=SnakeConstant.SNAKEYELLOW;
				}
				if(foodOrange.isSelected()){
					setPanel.foodColor=SnakeConstant.SNAKEORANGE;
				}
				
				if(headBlue.isSelected()){
					setPanel.headColor=SnakeConstant.SNAKEBLUE;
				}
				if(headRed.isSelected()){
					setPanel.headColor=SnakeConstant.SNAKERED;
				}
				if(headGreen.isSelected()){
					setPanel.headColor=SnakeConstant.SNAKEGREEN;
				}
				if(headYellow.isSelected()){
					setPanel.headColor=SnakeConstant.SNAKEYELLOW;
				}
				if(headOrange.isSelected()){
					setPanel.headColor=SnakeConstant.SNAKEORANGE;
				}
				
				if(bodyBlue.isSelected()){
					setPanel.bodyColor=SnakeConstant.SNAKEBLUE;
				}
				if(bodyRed.isSelected()){
					setPanel.bodyColor=SnakeConstant.SNAKERED;
				}
				if(bodyGreen.isSelected()){
					setPanel.bodyColor=SnakeConstant.SNAKEGREEN;
				}
				if(bodyYellow.isSelected()){
					setPanel.bodyColor=SnakeConstant.SNAKEYELLOW;
				}
				if(bodyOrange.isSelected()){
					setPanel.bodyColor=SnakeConstant.SNAKEORANGE;
				}
				if(showGrid.isSelected()){
					setPanel.showSign=true;
				}
				if(cancelGrid.isSelected()){
					setPanel.showSign=false;
				}
				setPanel.requestFocus();
				dispose();

			}
		});

		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(final ActionEvent e)
			{
				dispose();

			}
		});

	}

}
