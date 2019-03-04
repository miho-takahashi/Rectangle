package EIEV3;
import java.applet.Applet;
import java.awt.*;

public class RectangleEditor extends Applet implements Runnable{

    Command command;
    Board board;

    Thread thread =null;

    public void init(){

        board = new Board();
        command = new Command(board);

        thread = new Thread(this);
        thread.start();
    }

    /*public void update(Graphics g){
        paint(g);
    }*/


    public void run(){
        try{
            boolean doing = true;
            while(doing){
                System.out.println("1:create 2:move 3:expand 4:delete 5:deleteAll 6:intersect 7:displayBoard 8:exit");
                switch(new Input().inputInteger("操作したい番号の入力")){
                case 1:
                    command.create();
                    break;
                case 2:
                    command.move();
                    break;
                case 3:
                    command.expand_shrink();
                    break;
                case 4:
                    command.delete();
                    break;
                case 5:
                    command.deleteAll();
                    break;
                case 6:
                    command.intersect();
                    break;
                case 7:
                    command.displayBoard();
                    break;
                case 8:
                    System.out.println("操作を終了します");
                    doing = false;
                    break;
                default:
                    System.out.println("error");
                }
                repaint();
            }
        }catch(Exception e){
            System.out.print(e.toString());
        }
    }
    public void paint(Graphics g){
        for (Rectangle rectangle : board.getRectangles()) {
			if (rectangle != null) {
				g.setColor(board.getRGBColor(rectangle.getColor()));
				g.fillRect(rectangle.getX(),rectangle.getY(),rectangle.getWidth(), rectangle.getHeight());
			}
		}
    }

}
