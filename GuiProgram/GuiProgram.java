import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Collections;

 class a3 extends JFrame
{
	private final JButton [] buttonArray;    //create array of buttons
	private final Icon ic;					//create icon 1 for button image
	private final Icon ic2;					//create icon 2 for another button image
	private Icon ic3;						//create icon3 for the congratulations gif


	
	int[] nums = new int[49];//initializing an integer array of 49 values 
	int counter1 = 0;			//initialize counters for each of the buttons with the lucky number 
	int counter2 = 0;
	int counter3 = 0;
	int counter4 = 0;
	int counter5 = 0;
	int counter6 = 0;
	int counter7 = 0;
	
			
			
	 
	 public a3()
	{
			
		super("Good Luck to you!");
		setLayout(new GridLayout(7,7));  //construct 7,7 grid layout
			
		ic =  new ImageIcon(new ImageIcon("ic.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		ic2 =  new ImageIcon(new ImageIcon("ic2.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		buttonArray = new JButton [49];
			
		for (int j = 0; j < nums.length; j++)
		{
		    nums[j] = j + 1;  
		
		}
		Random rand = new Random();
		
		for (int i = 0; i < nums.length; i++) //shuffling the array of numbers in nums
		{  
			int randomIndexToSwap = rand.nextInt(nums.length);
			int temp = nums[randomIndexToSwap];
			nums[randomIndexToSwap] = nums[i];
			nums[i] = temp;
		}
		String strArray[] = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);//converting nums array from int array to string array
		for(int i = 0; i < buttonArray.length; i++)
		{
			 
			
		if(i % 2 == 0)//alternating between initialization of buttons with 2 different images
			{		
			
				buttonArray  [i] = new JButton (strArray[i],ic);//adding a number and an image to a button
				add(buttonArray[i]);
				buttonArray[i].addActionListener(new btnlisten());//adding action listeners to each and every button
				 
			}
		else
			{
		
				buttonArray  [i] = new JButton (strArray[i],ic2);
				add(buttonArray[i]);
				buttonArray[i].addActionListener(new btnlisten());
			
			}
		
		
		
		}
		 
	}


	

	private class btnlisten implements ActionListener
	{
		
		 int wn = nums[0]; //initializing the 7 lucky numbers
		 int x1 = nums[1];
		 int x2 = nums[2];
		 int x3 = nums[3];
		 int x4 = nums[4];
		 int x5 = nums[5];
		 int x6 = nums[6];
					
		public void actionPerformed(ActionEvent e)
		{													//functions for the 7 lucky numbered buttons
				if (e.getSource()==buttonArray[x1]) { 
					 buttonArray[x1].setBackground(Color.green);
					 counter1 += 1;
					 buttonArray[x1].setFont((new Font("Serif", Font.BOLD, 20)));
					 buttonArray[x1].setForeground(Color.white);
					}
				if (e.getSource()==buttonArray[x2]) {
					 buttonArray[x2].setBackground(Color.green);
					 counter2 += 1;
					 buttonArray[x2].setFont((new Font("Serif", Font.BOLD, 20)));
					 buttonArray[x2].setForeground(Color.white);
					}
				if (e.getSource()==buttonArray[x3]) {
					 buttonArray[x3].setBackground(Color.green);
					 counter3 += 1;
					 buttonArray[x3].setFont((new Font("Serif", Font.BOLD, 20)));
					 buttonArray[x3].setForeground(Color.white);
					}
				if (e.getSource()==buttonArray[x4]) {
					 buttonArray[x4].setBackground(Color.green);
					 counter4 += 1;
					 buttonArray[x4].setFont((new Font("Serif", Font.BOLD, 20)));
					 buttonArray[x4].setForeground(Color.white);
					}
				if (e.getSource()==buttonArray[x5]) {
					 buttonArray[x5].setBackground(Color.green);
					 counter5 += 1;
					 buttonArray[x5].setFont((new Font("Serif", Font.BOLD, 20)));
					 buttonArray[x5].setForeground(Color.white);
					}
				if (e.getSource()==buttonArray[x6]) {
					 buttonArray[x6].setBackground(Color.green);
					 counter6 += 1;
					 buttonArray[x6].setFont((new Font("Serif", Font.BOLD, 20)));
					 buttonArray[x6].setForeground(Color.white);
					}
				if (e.getSource()==buttonArray[wn]) {
					 buttonArray[wn].setBackground(Color.red);
					 buttonArray[wn].setFont((new Font("Serif", Font.BOLD, 25)));
					 buttonArray[wn].setForeground(Color.white);
					 counter7 += 1;
				
					}
				
				
				int wna=Integer.parseInt(buttonArray[wn].getText());  
				int y1=Integer.parseInt(buttonArray[x1].getText());  
				int y2=Integer.parseInt(buttonArray[x2].getText());  
				int y3=Integer.parseInt(buttonArray[x3].getText());  
				int y4=Integer.parseInt(buttonArray[x4].getText());  
				int y5=Integer.parseInt(buttonArray[x5].getText());  
				int y6=Integer.parseInt(buttonArray[x6].getText());  
							
					
				
				int [] winningnumbers = {y1,y2,y3,y4,y5,y6};//array of winning numbers that is displayed on the button
				int[] sortedArray = Arrays.stream(winningnumbers).sorted().map(i -> i).toArray();//using lambda to sort array numbers in ascending order
				
				if(counter1 >0 && counter2 >0 && counter3 >0 && counter4 >0 && counter5 >0 && counter6 >0 && counter7 >0 ) {
					ic3 =  new ImageIcon(new ImageIcon("congratulations.gif").getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT));
					
					JOptionPane.showMessageDialog(null,"Congratulations!"+"\n"+(Arrays.toString(sortedArray))+"\n"+"Top prize "+wna,"Hope you enjoyed the game",JOptionPane.INFORMATION_MESSAGE,ic3); //show joption pane upon clicking all 7 numbers	
		     	    
				}
		
			
			
		
			 
		}
	
		
		
	}
	
}

public class  GuiProgram
{
	public static void main (String [] args)
	{
		
		a3 d = new a3();
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setSize(1200, 800);
		d.setVisible(true);
		d.setResizable(false);
	}
}