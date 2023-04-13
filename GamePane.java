//GamePane Class

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class GamePane extends GridPane
{
    //creating all variables
    private boolean ballVisible;
    private boolean topButtonVisible;
    private boolean bottomButtonVisible;
    private boolean leftButtonVisible;
    private boolean rightButtonVisible;
    private Canvas canvas;
    private GraphicsContext gc;
    private Game game;
 
    public GamePane()
    {
       //instantiating all variables
       game = new Game();
       ballVisible = true;
       ballVisible = true;
       topButtonVisible = true;
       bottomButtonVisible = true;
       leftButtonVisible = true;
       rightButtonVisible = true;
   
       canvas = new Canvas(80, 80);
       gc = canvas.getGraphicsContext2D();
       draw();
       add(canvas, 1, 1);
       
       
       Button topButton = new Button();
       topButton.setMinSize(80, 20);
       topButton.setVisible(topButtonVisible);
       //creating button action event handlers for top, bottom, right, and left buttons
       topButton.setOnAction(event -> 
       {
          // Check if the ball can move up
          if (game.canMoveUp(this)) 
          {
              // Move the ball up
              game.moveBallUp(this);
          }
       });

       add(topButton, 1, 0);
   
       Button bottomButton = new Button();
       bottomButton.setMinSize(80, 20);
       bottomButton.setVisible(bottomButtonVisible);
       bottomButton.setOnAction(event -> 
       {
          // Check if the ball can move up
          if (game.canMoveDown(this)) 
          {
              // Move the ball up
              game.moveBallDown(this);
          }
       });
       add(bottomButton, 1, 2);
   
       Button leftButton = new Button();
       leftButton.setMinSize(20, 80);
       leftButton.setVisible(leftButtonVisible);
       leftButton.setOnAction(event -> 
       {
          // Check if the ball can move up
          if (game.canMoveLeft(this)) 
          {
              // Move the ball up
              game.moveBallLeft(this);
          }
       });

       add(leftButton, 0, 1);
   
       Button rightButton = new Button();
       rightButton.setMinSize(20, 80);
       rightButton.setVisible(rightButtonVisible);
       rightButton.setOnAction(event -> 
       {
          // Check if the ball can move up
          if (game.canMoveRight(this)) 
          {
              // Move the ball up
              game.moveBallRight(this);
          }
       });

       add(rightButton, 2, 1);
   }

    //getters & setters
    public boolean isBallVisible() 
    {
        return ballVisible;
    }

    public void setBallVisible(boolean ballVisible) 
    {
        this.ballVisible = ballVisible;
        draw();
    }

    public boolean isTopButtonVisible() 
    {
        return topButtonVisible;
    }

    public void setTopButtonVisible(boolean topButtonVisible) 
    {
        this.topButtonVisible = topButtonVisible;
        ((Button)getChildren().get(1)).setVisible(topButtonVisible);
    }

    public boolean isBottomButtonVisible() 
    {
        return bottomButtonVisible;
    }

    public void setBottomButtonVisible(boolean bottomButtonVisible) 
    {
        this.bottomButtonVisible = bottomButtonVisible;
        ((Button)getChildren().get(3)).setVisible(bottomButtonVisible);
    }

    public boolean isLeftButtonVisible() 
    {
        return leftButtonVisible;
    }

    public void setLeftButtonVisible(boolean leftButtonVisible) 
    {
        this.leftButtonVisible = leftButtonVisible;
        ((Button)getChildren().get(2)).setVisible(leftButtonVisible);
    }

    public boolean isRightButtonVisible() {
        return rightButtonVisible;
    }

    public void setRightButtonVisible(boolean rightButtonVisible) 
    {
        this.rightButtonVisible = rightButtonVisible;
        ((Button)getChildren().get(4)).setVisible(rightButtonVisible);
    }
    
    //draw method only if ball is visible is true
    public void draw() 
    {
       gc.clearRect(0, 0, 80, 80);
       if (isBallVisible()) 
       {
           gc.setFill(Color.BLUE);
           gc.fillOval(10, 10, 60, 60);
       } 
       else 
       {
           gc.clearRect(0, 0, 80, 80);
       }
   }
}
