package com.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SnakePanel extends JPanel implements KeyListener, Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Point> snake = new LinkedList<Point>();
	int direction = SnakeConstant.RIGHT;
	public boolean derail = false;
	public boolean snakeDerail = true;
	Thread thread;
	public int snakeSpeed = 120;
	// private int foodX = (int) ((Math.random() * 47) + 1), foodY = (int)
	// ((Math
	// .random() * 47) + 1);
	private int foodX , foodY;
	private int score;
	private int grade = 1;
	public boolean showSign =false;
	public int mode=SnakeConstant.BRIEFNESS;
	public int foodColor=SnakeConstant.SNAKEBLUE;
	public int headColor=SnakeConstant.SNAKEBLUE;
	public int bodyColor=SnakeConstant.SNAKERED;

	public SnakePanel()
	{
		this.addKeyListener(this);

	}

	public void init()// 初始化
	{
		food();
		int x = 25;
		int y = 25;

		for (int i = 0; i < 2; i++)
		{
			snake.addFirst(new Point(x--, y));
		}

		derail = true;
		thread = new Thread(this);
		thread.start();

	}

	private void food()// 产生食物
	{
		foodX = (int) ((Math.random() * 47) + 1);
		foodY = (int) ((Math.random() * 47) + 1);
	}

	private void isEatFood()// 是否吃到食物
	{
		if (snake.getFirst().x == foodX && snake.getFirst().y == foodY)
		{
			food();
			int x = snake.getFirst().x;
			int y = snake.getFirst().y;
			Point newFrist = new Point(x, y);
			snake.addLast(newFrist);
			score += 10;
			switch (mode){
			case SnakeConstant.BRIEFNESS:
				 briefness();
				break;
			case SnakeConstant.SECONDARY:
				secondary();
				break;
			case SnakeConstant.DIFFICULTY:
				 difficulty();
				break;
				
			}
			}

			SnakeControl.score.setText("游戏分数：" + score);

		}
	

	private void judge()// 判断是否出界
	{
		int snakeX = snake.getFirst().x;
		int snakeY = snake.getFirst().y;

		if (snakeX <= 0)
		{
			snakeDerail = false;
			derail = false;
			JOptionPane.showMessageDialog(null,
					"您输了，" + SnakeControl.score.getText());
		System.exit(0);

		}
		if (snakeX >= 51)
		{
			snakeDerail = false;
			derail = false;
			JOptionPane.showMessageDialog(null,
					"您输了，" + SnakeControl.score.getText());
			System.exit(0);
		}
		if (snakeY <= 0)
		{
			snakeDerail = false;
			derail = false;
			JOptionPane.showMessageDialog(null,
					"您输了，" + SnakeControl.score.getText());
			System.exit(0);
		}
		if (snakeY >= 51)
		{
			snakeDerail = false;
			derail = false;
			JOptionPane.showMessageDialog(null,
					"您输了，" + SnakeControl.score.getText());
			System.exit(0);
		}
	}

	private void orientation(int di)// 俭查方向是否相反
	{
		if (!(di + direction == 0))
		{
			direction = di;
		}
	}

	private void isEatSnake()//是否吃到身体
	{
		for (int i = 1; i < snake.size(); i++)
		{
			if (snake.get(i).equals(snake.getFirst()))
			{
				snakeDerail = false;
				derail = false;
				showSign=false;
				JOptionPane.showMessageDialog(null,
						"您输了，" + SnakeControl.score.getText());
				System.exit(0);
			}
		}
	}

	private void move() // 移动方法
	{
		isEatFood();

		snake.removeLast();

		int x = snake.getFirst().x;
		int y = snake.getFirst().y;

		switch (direction)
		{
		case SnakeConstant.UP:
			y--;

			break;
		case SnakeConstant.DOWN:

			y++;
			break;
		case SnakeConstant.LEFT:
			x--;
			break;
		case SnakeConstant.RIGHT:
			x++;
			break;
		}

		Point newFrist = new Point(x, y);
		snake.addFirst(newFrist);
		judge();
		isEatSnake();

		repaint();

	}

	public void paintComponent(Graphics g) // 重画
	{
		super.paintComponent(g);
		g.drawRect(8, 8, 503, 503);
		
		if(showSign){
			for(int i=2;i<=50;i++){
				g.setColor(new Color(160,160,160));
				g.drawLine(9,i*10,510,i*10);
				g.drawLine(i*10,9,i*10,510);
			}
			
		}
	switch(foodColor){
	case SnakeConstant.SNAKEBLUE:
		g.setColor(Color.cyan);
		break;
	case SnakeConstant.SNAKERED:
		g.setColor(Color.red);
		break;
	case SnakeConstant.SNAKEGREEN:
		g.setColor(Color.green);
		break;
	case SnakeConstant.SNAKEYELLOW:
		g.setColor(Color.yellow);
		break;
	case  SnakeConstant.SNAKEORANGE:
		g.setColor(Color.orange);
		break;
	}

		for (int i = 0; i < snake.size(); i++)
		{
			Point point = snake.get(i);
			if (i == 0)
			{

				g.fill3DRect(foodX * SnakeConstant.SIZE, foodY
						* SnakeConstant.SIZE, SnakeConstant.SIZE,
						SnakeConstant.SIZE, true);
				switch(headColor){
				case SnakeConstant.SNAKEBLUE:
					g.setColor(Color.blue);
					break;
				case SnakeConstant.SNAKERED:
					g.setColor(Color.red);
					break;
				case SnakeConstant.SNAKEGREEN:
					g.setColor(Color.green);
					break;
				case SnakeConstant.SNAKEYELLOW:
					g.setColor(Color.yellow);
					break;
				case  SnakeConstant.SNAKEORANGE:
					g.setColor(Color.orange);
					break;
				}
			}
			else
			{
				switch(bodyColor){
				case SnakeConstant.SNAKEBLUE:
					g.setColor(Color.blue);
					break;
				case SnakeConstant.SNAKERED:
					g.setColor(Color.red);
					break;
				case SnakeConstant.SNAKEGREEN:
					g.setColor(Color.green);
					break;
				case SnakeConstant.SNAKEYELLOW:
					g.setColor(Color.yellow);
					break;
				case  SnakeConstant.SNAKEORANGE:
					g.setColor(Color.orange);
					break;
				}
			}

			g.fill3DRect(point.x * SnakeConstant.SIZE, point.y
					* SnakeConstant.SIZE, SnakeConstant.SIZE,
					SnakeConstant.SIZE, true);

		}

	}
	
	private void remove(){ //作弊
		if(snake.size()>2){
		for(int i=2;i<snake.size();i++){
			snake.remove(i);
			repaint();
		}
		}
	}

	private void briefness() // 简单
	{
		switch (score)
		{
		case 30:
			snakeSpeed = 120;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 60:
			snakeSpeed = 110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 90:
			snakeSpeed = 110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 120:
			snakeSpeed = 100;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 150:
			snakeSpeed = 90;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 180:
			snakeSpeed = 90;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 210:
			snakeSpeed = 80;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 240:
			snakeSpeed = 80;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 270:
			snakeSpeed = 70;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 300:
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			snakeDerail = false;
			derail = false;
			JOptionPane.showMessageDialog(null,
					"恭喜您通全关了，游戏分数300");
			System.exit(0);
			break;

		}
	}
	
	private void secondary(){
		switch (score)
		{
		case 50:
			snakeSpeed = 110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 100:
			snakeSpeed = 110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 150:
			snakeSpeed = 110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 200:
			snakeSpeed = 110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 250:
			snakeSpeed = 110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 300:
			snakeSpeed =110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 350:
			snakeSpeed =110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 400:
			snakeSpeed = 110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 450:
			snakeSpeed = 110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 500:
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			snakeDerail = false;
			derail = false;
			
					JOptionPane.showMessageDialog(null,
							"恭喜您通全关了，游戏分数500");;
			System.exit(0);
			break;

		}
	}
	private void difficulty(){
		switch (score)
		{
		case 100:
			snakeSpeed = 110;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 200:
			snakeSpeed = 100;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 300:
			snakeSpeed = 90;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 400:
			snakeSpeed = 80;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 500:
			snakeSpeed = 70;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 600:
			snakeSpeed = 60;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 700:
			snakeSpeed = 50;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 800:
			snakeSpeed = 40;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 900:
			snakeSpeed = 30;
			grade += 1;
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			break;
		case 1000:
			SnakeControl.speed.setText("          速度：" + snakeSpeed + "毫秒");
			SnakeControl.grade.setText("          等级：" + grade);
			snakeDerail = false;
			derail = false;
			JOptionPane.showMessageDialog(null,
					"恭喜您通全关了，游戏分数1000");
			System.exit(0);
			break;

		}
	}


	@Override
	public void run()
	{

		while (snakeDerail)
		{
			if (derail)
			{

				move();
				try
				{
					Thread.sleep(snakeSpeed);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{

		switch (e.getKeyCode())
		{
		case KeyEvent.VK_UP:

			orientation(SnakeConstant.UP);
			break;
		case KeyEvent.VK_DOWN:

			orientation(SnakeConstant.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			orientation(SnakeConstant.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			orientation(SnakeConstant.RIGHT);
			break;
		case KeyEvent.VK_S:
			derail = false;
			SnakeControl.start.setText("继续游戏");
			break;
		case KeyEvent.VK_D:
			derail = true;
			SnakeControl.start.setText("暂停游戏");
			break;
		case KeyEvent.VK_F:
			showSign=true;
		//SnakeSet.show.setText("取消网格");
			break;
		case KeyEvent.VK_G:
			showSign=false;
			//SnakeSet.show.setText("显示网格");
			break;
		case KeyEvent.VK_R:
			remove();
			break;
		case KeyEvent.VK_E:
			int in = JOptionPane.showConfirmDialog(null, "您确定要退出吗？", "提示",
					JOptionPane.YES_NO_OPTION);

			if (in == JOptionPane.YES_OPTION)
			{
				snakeDerail = false;
				System.exit(0);
			

		}
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}
}
