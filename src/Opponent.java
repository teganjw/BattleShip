import java.util.Random;

public class Opponent {

    Board board = new Board();
    boolean gameOn = true;
    int[] xValues = new int[5];
    int[] yValues = new int[5];
    int randPlace = 0;

    public Opponent() {
        hideShips();
    }

    public void hideShips(){

        int place = 0;

        for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                if(board.grid[i][j].equals("\uD83D\uDEF3")){
                    xValues[place] = i;
                    yValues[place] = j;
                    place++;
                    board.grid[i][j] = "\uD83E\uDDF0";
                }
            }
        }

    }

    public void handleMove(String[] coord){
        int row = Integer.parseInt(coord[0]);
        int column = Integer.parseInt(coord[1]);
        boolean hit = false;

        for(int a=0; a<5; a++){
            System.out.print(xValues[a] + "*");
            System.out.print(yValues[a] + "! ");
        }
        System.out.println("row: " + row);
        System.out.println("column: " + column);

        for(int i=0; i<5; i++){
            if(row == xValues[i] && column == yValues[i]){
                board.grid[row][column] = "\uD83D\uDD34";
                hit = true;
            }
        }
        if(!hit){
            board.grid[row][column] = "\uD83D\uDD35";
        }

    }

    public String[] shootBack(){
        Random rand = new Random();
        boolean guessValid = false;

        int a = rand.nextInt(10)+1;
        int b = rand.nextInt(10)+1;

        while(!guessValid){

            if(board.grid[a][b].equals("\uD83D\uDD35") || board.grid[a][b].equals("\uD83D\uDD34")){
                a = rand.nextInt(10)+1;
                b = rand.nextInt(10)+1;
            }else{
                guessValid = true;
            }
        }

        String c = String.valueOf(a);
        String d = String.valueOf(b);


        String[] shot = new String[]{c,d};

        return shot;
    }

    public void checkGame(){
        int sink = 0;
        for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                if(board.grid[i][j].equals("\uD83D\uDD34")){
                    sink++;
                }
            }
        }
        if(sink==5){
            gameOn = false;
            System.out.println("YOU WIN!!!!!!!!");
        }else{sink = 0;}
    }



}
