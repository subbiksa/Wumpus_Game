import java.util.*;
public class GameItem {
	private static String c;
	
	public static void main(String args[]){
				display();
	}
			
	 //This method will be displaying the game board for the User to view and the variable that specifies the displayed character.
	@SuppressWarnings("unused")
	public static void display(){
		Random rand= new Random();
	    ArrayList<String> game_item=new ArrayList<>();
		Gold g=new Gold();
		Pit p=new Pit();
		Wumpus w=new Wumpus();
		ClearGround cg= new ClearGround();
				
		for(int i=0;i<3;i++)
		{
			game_item.add(p.return_items());
			c="p";
			
		}
		for(int i=0;i<2;i++)
		{
			game_item.add(g.return_item());
			c="g";
		}
		for(int j=0;j<1;j++)
		{
			game_item.add(w.return_gameItem());
			c="W";
		}
		
		for(int k=0;k<10;k++)
		{
			game_item.add(cg.return_item());
			c=".";
			
		}
		
		Collections.shuffle(game_item);
		
		String Board[][] = new String[4][4]; 
		try{
			for(int i=0;i<Board.length;i++)
			{
				for(int j=0;j<Board.length;j++)	
				{
					Board[i][j]=game_item.get(i*4+j);
					System.out.print("\t");
					System.out.print(Board[i][j] );
					System.out.print("\t");
					System.out.print("|");
					
				}
				System.out.print("\n-----------------------------------------------------------------\n");
				
			}} 
		
			catch(ArrayIndexOutOfBoundsException e)
			{
			System.out.println("Wumpus World!!!");	
			}

		
		 String choice[]= {"g","p","W","."}; 
			c = (String)choice[rand.nextInt(choice.length)];
		System.out.println("\t# "+ c + " has appeared! #\n");
		
		if(c=="g")
		{ System.out.println("Score increases!!");
		 c=".";
		
		System.out.println(c + "is the new choice");
		}
		else if(c=="p")
	{
		System.out.println("You fell into a pit. Game over!!");
	}
		else if(c=="W")
		{
			System.out.println("Wumpus has eaten you. Game over!!");
		}
		
		
		else {
		String[] position= Board[rand.nextInt(Board.length)];
		System.out.println("Current position: *");
		}
		
		}

			
}