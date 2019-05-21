public class Board {

    public String[][] grid = new String[11][11];
    String[] letters = new String[]{"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
    String count = "10";



    public Board(){
        populateBoard();
        makeShips();
    }

    public void makeShips(){
        int max = 10;
        int min = 1;
        int range = max - min + 1;

        for(int i=0; i<5; i++){
            int randX = (int)(Math.random() * range) + min;
            int randY = (int)(Math.random() * range) + min;
            if(grid[randX][randY].equals("\uD83E\uDDF0")){
                grid[randX][randY] = "\uD83D\uDEF3";
            }else{
                i--;
            }

        }

    }

    public void populateBoard(){

        for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){
                grid[i][j] = "\uD83E\uDDF0";
            }
        }

        for(int a=10; a>0; a--){
            grid[a][0] = count;
            takeCountDown();
        }

        for(int b=1; b<11; b++){
            grid[0][b] = letters[b];
        }


    }

    public void takeCountDown(){
        int result = Integer.parseInt(count);
        result = result-1;
        count = Integer.toString(result);
    }

    public void printBoard(){
        for(int i=0; i<11; i++){
            for(int j=0; j<11; j++){

                System.out.print(grid[i][j] + "\t");

            }
            System.out.print("\n");
        }
    }

    public void placeShips(){

    }

}
