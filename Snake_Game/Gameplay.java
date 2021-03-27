
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	
	private int[] snakeXlength = new int[750];
	private int[] snakeYlength = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon snakeright;
	private ImageIcon snakeleft;
	private ImageIcon snakeup;
	private ImageIcon snakedown;
	
	private int lengthofsnake =3;
	
	private int score = 0;
	
	private int moves = 0;
	
	private ImageIcon snakebody;
	
	private int[] appleXpos = {25,50,75,100,125,150,175,200,225,250,275,300,325
			,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825};
	
	private int[] appleYpos = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
	private ImageIcon apple;
	private Random random = new Random();
	private int xpos = random.nextInt(33);
	private int ypos = random.nextInt(22);
	
	
	private Timer timer;
	private int delay = 100;
	
	private ImageIcon titleImage;
	private ImageIcon backImage;
	public Gameplay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
	}

	public void paint(Graphics g)
	{
		if (moves == 0)
		{
			snakeXlength[2] = 50;
			snakeXlength[1] = 75;
			snakeXlength[0] = 100;
			
			snakeYlength[2] = 100;
			snakeYlength[1] = 100;
			snakeYlength[0] = 100;
			
		}
		//title
		g.setColor(Color.white);
		g.drawRect(16, 10, 851, 55);
		
		//titleimage
		titleImage = new ImageIcon("images/title.png");
		titleImage.paintIcon(this, g, 16, 11);
		
		//border
		g.setColor(Color.white);
		g.drawRect(16, 74, 851, 577);
		
		//background
		backImage = new ImageIcon("images/back.png");
		backImage.paintIcon(this,g, 16, 74);
		
		//snake
		snakeright = new ImageIcon("images/snakeright.png");
		snakeright.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
		
		//scoreboard
		g.setColor(Color.BLACK);
		g.setFont(new Font("arial", Font.BOLD, 18));
		g.drawString("Scores: "+score, 770,30);
		
		//snakelength
				g.setColor(Color.WHITE);
				g.setFont(new Font("arial", Font.BOLD, 18));
				g.drawString("Length: "+lengthofsnake, 770,55);
		
		for (int a = 0; a < lengthofsnake; a++) 
		{
			if (a==0 && right)
			{
				snakeright = new ImageIcon("images/snakeright.png");
				snakeright.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);	
			}
			if (a==0 && left)
			{
				snakeleft = new ImageIcon("images/snakeleft.png");
				snakeleft.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);	
			}
			if (a==0 && up)
			{
				snakeup = new ImageIcon("images/snakeup.png");
				snakeup.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);	
			}
			if (a==0 && down)
			{
				snakedown = new ImageIcon("images/snakedown.png");
				snakedown.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);	
			}
			if (a!=0)
			{
				snakebody = new ImageIcon("images/snakebody.png");
				snakebody.paintIcon(this, g, snakeXlength[a], snakeYlength[a]);	
			}
		}
		
		apple = new ImageIcon("images/apple.png");
				if((appleXpos[xpos]==snakeXlength[0] && appleYpos[ypos]==snakeYlength[0]))
				{
					score++;
					lengthofsnake++;
					xpos = random.nextInt(33);
					ypos = random.nextInt(22);
				}
				
				apple.paintIcon(this, g,appleXpos[xpos], appleYpos[ypos]);
				
				for(int b = 1; b<lengthofsnake; b++)
				{
					if((snakeXlength[b]==snakeXlength[0] && snakeYlength[b]==snakeYlength[0]))
					{
						up = false;
						down = false;
						right=false;
						left=false;
						
						g.setColor(Color.RED);
						g.setFont(new Font("showcard gothic",Font.BOLD,50));
						g.drawString("GAME OVER!", 300, 300);
						
						g.setFont(new Font("arial",Font.BOLD,20));
						g.drawString("Press Space for Restart", 350, 340);
						
						
					}
				}
				
				
		g.dispose();
 
		
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			moves=0;
			score=0;
			lengthofsnake=3;
			repaint();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			moves++;
			right =true;
			if(!left)
			{
				right=true;
			}
			else 
			{
				right=false;
				left=true;
			}
			up = false;
			down = false;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			moves++;
			left =true;
			if(!right)
			{
				left=true;
			}
			else 
			{
				left=false;
				right=true;
			}
			up = false;
			down = false;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			moves++;
			up =true;
			if(!down)
			{
				up=true;
			}
			else 
			{
				up=false;
				down=true;
			}
			left = false;
			right = false;
			
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			moves++;
			down =true;
			if(!up)
			{
				down=true;
			}
			else 
			{
				down=false;
				up=true;
			}
			left = false;
			right = false;
			
		}
	}

		
	

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(right)
		{
			for(int i=lengthofsnake;i>=0;i--)
			{
				snakeYlength[i+1]=snakeYlength[i];
			}
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakeXlength[i]=snakeXlength[i]+25;
				}
				else
				{
					snakeXlength[i]=snakeXlength[i-1];
				}
				if(snakeXlength[i]>850)
				{
					snakeXlength[i]=25;
				}
			}
			repaint();
		}
		if(left)
		{
			for(int i=lengthofsnake;i>=0;i--)
			{
				snakeYlength[i+1]=snakeYlength[i];
			}
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakeXlength[i]=snakeXlength[i]-25;
				}
				else
				{
					snakeXlength[i]=snakeXlength[i-1];
				}
				if(snakeXlength[i]<25)
				{
					snakeXlength[i]=850;
				}
			}
			repaint();
			
		}
		if(up)
		{
			for(int i=lengthofsnake;i>=0;i--)
			{
				snakeXlength[i+1]=snakeXlength[i];
			}
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakeYlength[i]=snakeYlength[i]-25;
				}
				else
				{
					snakeYlength[i]=snakeYlength[i-1];
				}
				if(snakeYlength[i]<75)
				{
					snakeYlength[i]=625;
				}
			}
			repaint();
		}
		if(down)
		{
			for(int i=lengthofsnake;i>=0;i--)
			{
				snakeXlength[i+1]=snakeXlength[i];
			}
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakeYlength[i]=snakeYlength[i]+25;
				}
				else
				{
					snakeYlength[i]=snakeYlength[i-1];
				}
				if(snakeYlength[i]>625)
				{
					snakeYlength[i]=75;
				}
			}
			repaint();
		}
	}
}
