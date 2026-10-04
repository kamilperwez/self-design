import code.controller.GameController;
import code.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //System.out.println("Hello world!");

        int id=1;

        //adding players
        List<Player> playerList=new ArrayList<>();
        System.out.println("Welcome to TicTacToe Game");
        System.out.println("Please enter the dimension for the game: ");
        int dimension=sc.nextInt();
        GameController gameController=new GameController(dimension);
        System.out.println("Do you want a Bot : (Y/N) ");
        String botChoice=sc.next();
        if(botChoice.equalsIgnoreCase("Y")){
            Bot bot=new Bot(id++,"BOT",'$', PlayerType.BOT, BotDifficultyLevel.MEDIUM);
            playerList.add(bot);
        }
        while(id<dimension){
            System.out.println("Please Enter the name of the Player: ");
            String name= sc.next();
            System.out.println("Please Enter the symbol for the Player "+name+" : ");
            char symbol=sc.next().charAt(0);
            Player newPlayer=new Player(id++,name,symbol,PlayerType.HUMAN);
            playerList.add(newPlayer);
        }

        //Real gameplay
        Collections.shuffle(playerList);
        Game game=gameController.createGame(dimension,playerList);
        int playerIndex=-1;
        while(gameController.getStatus(game)==GameStatus.RUNNING ||
                gameController.getStatus(game)==GameStatus.YET_TO_START)
        {
            gameController.updateGameStatus(game,GameStatus.RUNNING);
            playerIndex++;
            playerIndex=playerIndex%playerList.size();
            gameController.displayGame(game);
            Move executeMove= gameController.executeMove(game,playerList.get(playerIndex));
            Player winner=gameController.checkWinner(game,executeMove);
            if(winner !=null){
                System.out.println("WINNER is : "+ winner.getName());
                gameController.displayGame(game);
                gameController.updateGameStatus(game,GameStatus.WIN);
                break;
            }
        }
    }
}