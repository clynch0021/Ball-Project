//Game Application class

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Game extends Application 
{
    private GamePane[][] gamePanes;

    @Override
    public void start(Stage primaryStage) 
    {
       BorderPane borderPane = new BorderPane();
   
       // Top label
       Label topLabel = new Label("Welcome to the ball game!");
       topLabel.setAlignment(Pos.CENTER);
       borderPane.setTop(topLabel);
   
       // Grid of GamePanes
       GridPane gridPane = new GridPane();
       gamePanes = new GamePane[4][4];
       for (int i = 0; i < 4; i++) 
       {
           for (int j = 0; j < 4; j++) 
           {
               GamePane gamePane = new GamePane();
               this.gamePanes[i][j] = gamePane;
               gridPane.add(gamePane, j, i);
           }
       }
       //Hide the ball in the GamePane at position 0,2
       gamePanes[0][2].setBallVisible(false);
   
       borderPane.setCenter(gridPane);
   
       Scene scene = new Scene(borderPane, 600, 600);
       primaryStage.setTitle("Ball Game");
       primaryStage.setScene(scene);
       primaryStage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
   //methods to use in button listeners in GamePane class. Two for each up, down, left, right
   public boolean canMoveUp(GamePane gamePane) 
   {
       int rowIndex = GridPane.getRowIndex(gamePane);
       int columnIndex = GridPane.getColumnIndex(gamePane);
       if (rowIndex > 0 && gamePanes[rowIndex - 1][columnIndex].isBallVisible()) {
           return false;
       }
       if (rowIndex > 1 && gamePanes[rowIndex - 2][columnIndex].isBallVisible()) {
           return false;
       }
       return rowIndex > 1;
   }
   
   public void moveBallUp(GamePane gamePane) 
   {
       int rowIndex = GridPane.getRowIndex(gamePane);
       int columnIndex = GridPane.getColumnIndex(gamePane);
       gamePanes[rowIndex - 2][columnIndex].setBallVisible(true);
       gamePanes[rowIndex][columnIndex].setBallVisible(false);
       gamePanes[rowIndex - 1][columnIndex].setBallVisible(false);
   }
   
   public boolean canMoveDown(GamePane gamePane) 
   {
       int rowIndex = GridPane.getRowIndex(gamePane);
       int columnIndex = GridPane.getColumnIndex(gamePane);
       if (rowIndex < 3 && gamePanes[rowIndex + 1][columnIndex].isBallVisible()) 
       {
           return false;
       }
       if (rowIndex < 2 && gamePanes[rowIndex + 2][columnIndex].isBallVisible()) 
       {
           return false;
       }
       return rowIndex < 2;
   }
   
   public void moveBallDown(GamePane gamePane) 
   {
       int rowIndex = GridPane.getRowIndex(gamePane);
       int columnIndex = GridPane.getColumnIndex(gamePane);
       gamePanes[rowIndex + 2][columnIndex].setBallVisible(true);
       gamePanes[rowIndex][columnIndex].setBallVisible(false);
       gamePanes[rowIndex + 1][columnIndex].setBallVisible(false);
   }
   
   public boolean canMoveLeft(GamePane gamePane) 
   {
       int rowIndex = GridPane.getRowIndex(gamePane);
       int columnIndex = GridPane.getColumnIndex(gamePane);
       if (columnIndex > 1 && gamePanes[rowIndex][columnIndex - 2].isBallVisible())
       {
           return false;
       }
       if (columnIndex > 0 && gamePanes[rowIndex][columnIndex - 1].isBallVisible()) 
       {
           return false;
       }
       return columnIndex > 1;
   }
   
   public void moveBallLeft(GamePane gamePane) 
   {
       int rowIndex = GridPane.getRowIndex(gamePane);
       int columnIndex = GridPane.getColumnIndex(gamePane);
       gamePanes[rowIndex][columnIndex - 2].setBallVisible(true);
       gamePanes[rowIndex][columnIndex].setBallVisible(false);
       gamePanes[rowIndex][columnIndex - 1].setBallVisible(false);
   }
   
   public boolean canMoveRight(GamePane gamePane) 
   {
       int rowIndex = GridPane.getRowIndex(gamePane);
       int columnIndex = GridPane.getColumnIndex(gamePane);
       if (columnIndex < 2 && gamePanes[rowIndex][columnIndex + 2].isBallVisible()) 
       {
           return false;
       }
       if (columnIndex < 3 && gamePanes[rowIndex][columnIndex + 1].isBallVisible()) 
       {
           return false;
       }
       return columnIndex < 2;
   }
   
   public void moveBallRight(GamePane gamePane) 
   {
       int rowIndex = GridPane.getRowIndex(gamePane);
       int columnIndex = GridPane.getColumnIndex(gamePane);
       gamePanes[rowIndex][columnIndex + 2].setBallVisible(true);
       gamePanes[rowIndex][columnIndex].setBallVisible(false);
       gamePanes[rowIndex][columnIndex + 1].setBallVisible(false);
   }   
}
