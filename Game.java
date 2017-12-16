import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {
	

	
	public static String[][] board=new String[4][4];
	public static String msg="";
	public static int gold=0;
	
	@SuppressWarnings("resource")
	private static String menu(){
	{
		Scanner sc=new Scanner(System.in);
		Gold g=new Gold();
		Pit p=new Pit();
		Wumpus w=new Wumpus();
		ClearGround cg=new ClearGround();
		System.out.println("====WUMPUS====");
		 System.out.println("Enter the desired operation");
		 System.out.println("1.Move Player Down");
		 System.out.println("2.Move Player Up");
		 System.out.println("3.Move Player Left");
		 System.out.println("4.Move Player Right");
		 System.out.println("5.Quit");
		int player_life=1;
		List<String> game_item=new ArrayList<>();
		board[0][0]="*";
		for(int i=0;i<3;i++)
		{
			game_item.add(p.return_items());
			
		}
		for(int i=0;i<2;i++)
		{
			game_item.add(g.return_item());
		}
		for(int i=0;i<1;i++)
		{
			game_item.add(w.return_gameItem());
		}
		
		
		for(int i=0;i<10;i++)
		{
			game_item.add(cg.return_item());
		}
		
		Collections.shuffle(game_item);
		List<String> game_item2=new ArrayList<String>();
		game_item2.addAll(game_item);
		/*for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				board[i][j]=game_item.get(i*4+j);
			}
		}*/
		
		try{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				if(i==0&&j==0)
				{
					System.out.print("\t");
					board[i][j]="*";
					System.out.print(board[i][j] );
					System.out.print("\t");
					System.out.print("|");
					
				}
				else{
				board[i][j]=game_item.get(i*4+j);
				System.out.print("\t");
				//System.out.print(board[i][j] );
				System.out.print("\t");
				System.out.print("|");
				
			}}
			System.out.print("\n-----------------------------------------------------------------\n");
			
		}}
		catch(ArrayIndexOutOfBoundsException e)
		{
		System.out.println("Wumpus World!!!");	
		}
		

		
		int px=0;
		int py=0;
		while(player_life==1){
		System.out.println("Enter 1 for moving down,2 for moving up,3 for moving left and 4 for moving right");
		int key=sc.nextInt();
		if(key==1)
		{
			
			String temp=board[px][py];
			px=px+1;
			
			
			System.out.println();
			if(px>3)
			{
				px=0;
				SenseNearby(px+1,py);
				System.out.println(msg);
				result(msg);
				board[px+3][py]=board[px][py];
				board[px][py]=temp;
			}
			else
			{
				SenseNearby(px+1,py);
				System.out.println(msg);
				result(msg);
			board[px-1][py]=board[px][py];
			board[px][py]=temp;
			}
			for(int i=0;i<board.length;i++)
			{
				for(int j=0;j<board.length;j++)
				{
					if(i==px)
					if(i==px&&j==py){
						System.out.print("\t");	
						System.out.print(board[px][py]);
						System.out.print("\t");
						System.out.print("|");
						continue;
					}
					
					if(i==(px-1)&&j==py)
					{
						System.out.print("\t");	
						//System.out.print(board[px-1][py]);
						System.out.print("\t");
						System.out.print("|");
					}
					
					
					else{	
					board[i][j]=game_item2.get(i*4+j);
					System.out.print("\t");
					//System.out.print(board[i][j] );
					System.out.print("\t");
					System.out.print("|");
					
				}}
				System.out.print("\n-----------------------------------------------------------------\n");
				
			}
			}
		if(key==2)
			{
			
			String temp=board[px][py];
			px=px-1;
			
			if(px<0)
			{
				px=3;
				SenseNearby(px,py);
				System.out.println(msg);
				result(msg);
				
				board[px-3][py]=board[px][py];
				board[px][py]=temp;
			}
			else{
				SenseNearby(px,py);
				System.out.println(msg);
				result(msg);
			board[px+1][py]=board[px][py];
			board[px][py]=temp;
			}
			for(int i=0;i<board.length;i++)
			{
				for(int j=0;j<board.length;j++)
				{
					if(i==px)
					if(i==px&&j==py){
						System.out.print("\t");	
						System.out.print(board[px][py]);
						System.out.print("\t");
						System.out.print("|");
						continue;
					}
					
					if(i==(px+1)&&j==py)
					{
						System.out.print("\t");	
						//System.out.print(board[px+1][py]);
						System.out.print("\t");
						System.out.print("|");
					}
					
					
					else{	
					board[i][j]=game_item2.get(i*4+j);
					System.out.print("\t");
					//System.out.print(board[i][j] );
					System.out.print("\t");
					System.out.print("|");
					
				}}
				System.out.print("\n-----------------------------------------------------------------\n");
				
			
			}
			}
		if(key==3)
		{
		
		String temp=board[px][py];
		py=py-1;
		if(py<0)
		{
			py=3;
			SenseNearby(px,py);
			System.out.println(msg);
			result(msg);
			board[px][py-3]=board[px][py];
			board[px][py]=temp;
		}
		else{
			SenseNearby(px,py);
			System.out.println(msg);
			result(msg);
		board[px][py+1]=board[px][py];
		board[px][py]=temp;
		}
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				if(i==px)
				if(i==px&&j==py){
					System.out.print("\t");	
					System.out.print(board[px][py]);
					System.out.print("\t");
					System.out.print("|");
					continue;
				}
				
				if(i==(px)&&j==py+1)
				{
					System.out.print("\t");	
					//System.out.print(board[px][py+1]);
					System.out.print("\t");
					System.out.print("|");
				}
				
				
				else{	
				board[i][j]=game_item2.get(i*4+j);
				System.out.print("\t");
				//System.out.print(board[i][j] );
				System.out.print("\t");
				System.out.print("|");
				
			}}
			System.out.print("\n-----------------------------------------------------------------\n");
			
		
			
			}
			}
		if(key==4)
		{
		
		String temp=board[px][py];
		py=py+1;
		
		if(py>3)
		{
			py=0;
			SenseNearby(px,py);
			System.out.println(msg);
			result(msg);
			board[px][py+3]=board[px][py];
			board[px][py]=temp;
		}
		else{
			SenseNearby(px,py);
			System.out.println(msg);
			result(msg);
		board[px][py-1]=board[px][py];
		board[px][py]=temp;
		}
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				if(i==px)
				if(i==px&&j==py){
					System.out.print("\t");	
					System.out.print(board[px][py]);
					System.out.print("\t");
					System.out.print("|");
					continue;
				}
				
				if(i==(px)&&j==py-1)
				{
					System.out.print("\t");	
					//System.out.print(board[px][py-1]);
					System.out.print("\t");
					System.out.print("|");
				}
				
				
				else{	
				board[i][j]=game_item2.get(i*4+j);
				System.out.print("\t");
				//System.out.print(board[i][j] );
				System.out.print("\t");
				System.out.print("|");
				
			}}
			System.out.print("\n-----------------------------------------------------------------\n");
		}}}}
	return null;
	}

	

	private static void result(String m) {
		
		// TODO Auto-generated method stub
		if(m.equals("There is a Glitter"))
		{
			System.out.println("You have collected a goldcoin");
			gold++;
		}
		if(m.equals("There is a stench"))
		{
			System.out.println("You have got caught by a Wumpus and lost the game");
			
		}
		if(m.equals("There is heavy breeze"))
		{
			System.out.println("You have fallen into a pit and lost the game");
			
		}
		
	}


	private static String SenseNearby(int x, int y) {
		// TODO Auto-generated method stub
		//System.out.println(board[x][y]);
		
		if(board[x][y].equals("P"))
		{
			 msg="There is heavy breeze";
		}
		if(board[x][y].equals("G"))
		{
			msg="There is a Glitter";
		}
		if(board[x][y].equals("W"))
		{
		 msg="There is a stench";
		}
		return msg;		
	}


	private void display() {
		// TODO Auto-generated method stub
		char [][] Board = new char[4][4];  
		
	 	 try {
		for (int row=0; row<Board.length;row--){
			for (int column=0;column<Board[0].length;column++){
				System.out.print("\t"+Board[row][column]);
               if(column==0||column==1 || column==2 || column==3)
               {                	System.out.print("\t|\t|\t|");
               }
			
               System.out.print("\n\t-----------------------------------\n");
			}}   }
	//end of the method display()
		catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Wumpus World!");
     }}	
	
	
	

	private void setBoard() {
		// TODO Auto-generated method stub
char[][] Board = new char[4][4];
		
		for (int row=0;row<Board.length; row++ ){
			Arrays.fill(Board[row], ' ');
		}
		
	}

public void runGame() {
	// TODO Auto-generated method stub
	
	setBoard();// call to the setBoard() method
    display();// call to the private method display()	
    menu();//call to the private method menu()
}
}