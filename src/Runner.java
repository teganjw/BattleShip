import java.util.Scanner;


public class Runner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Player p = new Player();
        Opponent o = new Opponent();
        String[] letters = new String[]{"", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};

        String [] arrOfStr = new String[2];

        while(p.gameOn && o.gameOn){
            boolean validShot = false;
            o.checkGame();
            p.checkGame();

            while(!validShot){

                System.out.println("Your board");
                p.board.printBoard();
                System.out.println("Where would you like to shoot? (row #,column letter)");
                String selection = sc.nextLine();

                boolean notValid = validateInput(selection);

                //TEST selection here!!!!!!
                if(notValid){
                    System.out.println("THAT IS NOT A VALID SHOT!! ");
                    break;
                }


                arrOfStr = selection.split(",");

                for(int i=0; i<11; i++){
                    if(letters[i].equals(arrOfStr[1])){
                        arrOfStr[1] = String.valueOf(i);
                    }
                }

                o.handleMove(arrOfStr);
                System.out.println("Opponent Board");
                o.board.printBoard();
                String[] shot = o.shootBack();
                p.handleMove(shot);
                o.checkGame();
                p.checkGame();
                if(p.gameOn==false || o.gameOn==false){
                    break;
                }

            }

        }

    }

    public static boolean validateInput(String input) {

        if(input.length()<3){
            return false;
        }
        if(input.matches("^[1-9,10]+$")){
            return false;
        }

        return true;
    }

}
