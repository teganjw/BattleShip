public class Player {

    Board board = new Board();
    boolean gameOn = true;

    public Player() {

    }

    public void handleMove(String[] coord){
        int row = Integer.parseInt(coord[0]);
        int column = Integer.parseInt(coord[1]);

        if(board.grid[row][column].equals("\uD83E\uDDF0")){
            board.grid[row][column] = "\uD83D\uDD35";
        }
        if(board.grid[row][column].equals("\uD83D\uDEF3")){
            board.grid[row][column] = "\uD83D\uDD34";
        }

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
            System.out.println("AWK... YOU LOST...");
        }else{sink = 0;}
    }



}