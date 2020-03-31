

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


enum SuitEnum {//instantiate suit enum
	Spade("S"),
	Heart("H"),
	Diamond("D"),
	Club("C");
	
	private String suit;
	
	private SuitEnum(String suit)
	{
	    this.suit = suit;
	}
	
	public String getSuit()
	{
		return suit;
	}

}
enum RankEnum {//instantiate rank enum
	Two("2"),
	Three("3"),
	Four("4"),
	Five("5"),
	Six("6"),
	Seven("7"),
	Eight("8"),
	Nine("9"),
	Ten("T"),
	Jack("J"),
	Queen("Q"),
	King("K"),
	Ace("A"), ;

	private String rank;
	private RankEnum(String rank)
	{
		this.rank = rank ;
	}
	public String getRank()
	{
		return rank;
	}
}

class PlayingCard {//PlayingCard class filled with accessor and mutator methods

	private SuitEnum suit;
	private RankEnum rank;
	
	public PlayingCard(SuitEnum suit,RankEnum rank)
	{
		setCard(suit,rank);
	}
	public PlayingCard(PlayingCard pc)
	{
		this.suit=pc.suit;
		this.rank=pc.rank;
	}
	public SuitEnum getSuit() 
	{
		return suit;
	}
	public RankEnum getRank()
	{
		return rank;
	}
	public void setCard(SuitEnum suit,RankEnum rank) 
	{
	
		this.suit= suit;
		this.rank= rank;
	}
	
	@Override
	public String toString() {//displays each card in this format
		String pc= suit.getSuit() + rank.getRank()+" ";
		return pc;
	}
}

public class CardDeckShuffleProgram {//mainclass 
private final int MAXC =13;
private final int MAXD =52;


	private void deckOfCards(ArrayList<PlayingCard>cardList)//every method goes through this method to do its functions 
	{ 
		for(SuitEnum suit : SuitEnum.values()) //pass the values from 2 enum classes
			{
				for (RankEnum rank : RankEnum.values())
				{
					cardList.add(new PlayingCard(suit,rank));
				}
			}	
		
		printDeck(cardList);
		PlayingCard [] cardArray = new PlayingCard [cardList.size()];
		listToArray(cardList, cardArray);
		printDeck(cardArray);
		shuffle(cardArray);
		String[] strArray = new String [MAXD];				
		transfer(cardArray,strArray);
		String twoD[][] = new String [4][MAXC];
		transfer2D(twoD,strArray);
		print2D(twoD);
	}
	private void printDeck(ArrayList<PlayingCard>values) {//prints the first group of cards from an arraylist 
		System.out.println("Printing from ArrayList");
		System.out.println();
		int counter = 0;
		for (PlayingCard pc : values)
		{
			if (counter / MAXD == 0 ) //outputs all 52 cards
			{
				System.out.print(pc.toString());
				counter++;
				if (counter % MAXC == 0) //makes a new column every after every 13 rows
					{
						System.out.println();
					}
			}
		}
		System.out.println("----------------------------------------");
		}

	private void listToArray(ArrayList<PlayingCard> cardList, PlayingCard[]cardArray) //transfers values from PlayingCard's arraylist cardList to  PlayingCard's array cardArray.
		{
		
		
			for (int i = 0; i < cardList.size (); i++)
			cardArray [i] = cardList.get(i);//copies data from cardlist to cardarray
		
		}

	private void printDeck(PlayingCard[]cardArray) //prints the second group of cards using from an array
	{
		System.out.println("Printing from Array");
		System.out.println();
		int counter = 0;
		for (PlayingCard pc : cardArray)
		{
		if (counter / MAXD == 0 ) 
			{
				System.out.print(pc.toString());
				counter++;
				if (counter % MAXC == 0)
					{
						System.out.println();
					}
			}
		}
		System.out.println();
	}

	private void transfer(PlayingCard[]cardArray,String[] strArray) //transfers values from PlayingCard array type's cardArray array to String  array's strArray array. 
		{    
		for(int x=0;x<cardArray.length;x++) 
			{
				strArray[x]=cardArray[x].toString();//transfer data from cardArray to strArray by converting the cardArray to a string type array.
			}
		}


	private void shuffle(PlayingCard[] cardArray) 
	{
		Random rnd = new Random();//instantiate a new random instance variable rnd
		
		System.out.println("Shuffle the cards - Array version");
		System.out.println("Printing from ArrayList");
		
		System.out.println();
		String[]strArray=new String[MAXD];
		
		transfer(cardArray,strArray);
		
		for ( int i=0 ; i< MAXD;  i++)
			{
				int j = rnd.nextInt(52);
				swap(strArray, i,j);//calls swap function to swap out the ith integer value and jth integer value for 52 times
				PlayingCard random = cardArray[i];
				cardArray[i] = cardArray[j];
				cardArray[j] = random;
			}
		int counter=0;
		for (String pc : strArray)
			{
				if (counter / MAXD == 0 ) 
					{
						System.out.print(pc.toString());
						counter++;
				
						if (counter % MAXC== 0)
							{
						System.out.println();
							}
					}	
			}
		System.out.println();	
	}
	
	
	
	private void swap(String[] str,int i,int j) 
	{
		String random = str[i];
		str[i] = str[j];//swaps the ith and jth value
		str[j] = random;
	}
		

	private void transfer2D(String[][] twoD, String[] strArray)//transfers values from String array type's strArray array to 2D String  array's twoD array.
		{
		
			int x = 0;
			for(int l = 0;l<4;l++)
			for(int o=0;o<MAXC;o++)
				{
		
				twoD[l][o]=strArray[x];//transfers values from strArray and coverts it to a two dimensional twoD array  
				x++;	
	
				}
		}

	private void sort2D(String[][] twoD)
		{
	
			  Arrays.sort(twoD[0], Comparator.reverseOrder());
			  Arrays.sort(twoD[1], Comparator.reverseOrder());
			  Arrays.sort(twoD[2], Comparator.reverseOrder());
			  Arrays.sort(twoD[3], Comparator.reverseOrder());
		
		}


	private void print2D(String[][] strArray)
	{
		
		System.out.println("Re-arrange the cards");
		sort2D(strArray);
		for(int i=0; i<4; i++)
		{
			
			MyInt s = new MyInt();
			MyInt h = new MyInt();		
			MyInt d = new MyInt();		
			MyInt c = new MyInt();
			GetHandInfo(strArray[i], s, h, d, c);
		
		for(int j=0; j<MAXC;j++)
		{
			System.out.print(strArray[i][j]);

		}
			System.out.println();
			System.out.print(s.getInt() + " - ");
			System.out.print(h.getInt() + " - ");
			System.out.print(d.getInt() + " - ");
			System.out.print(c.getInt());
			System.out.println();
		}
	}
	
	private void GetHandInfo(String[] anHand, MyInt s, MyInt h, MyInt d, MyInt c)
	{
		
		
		for (int i =0; i < 13; i++)
		{
			if(anHand[i].charAt(0)=='S')
			{
				s.setInt(s.getInt()+1);
			}
			if(anHand[i].charAt(0)=='H')
			{
				h.setInt(h.getInt()+1);
			}
			if(anHand[i].charAt(0)=='D')
			{
				d.setInt(d.getInt()+1);
			}
			if(anHand[i].charAt(0)=='C')
			{
				c.setInt(c.getInt()+1);
			}
		}
	}
	
	

	public static void main(String[]args)
		{
		
			ArrayList <PlayingCard> cards = new ArrayList <PlayingCard>();
			CardDeckShuffleProgram deck = new CardDeckShuffleProgram();
			deck.deckOfCards(cards);
		}

}

class MyInt{

	private int n;
	
	public void setInt(int n)
	{
		this.n=n;
	
	}
	
	public int getInt()
	{
		return n;
	}

}