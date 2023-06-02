import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEvent implements ActionListener {
    BoardControl board;
    WindowControl windowControl;
    public ButtonEvent(BoardControl a, WindowControl b) {
        board = a;
        windowControl = b;
    }

    public void actionPerformed(ActionEvent e) {
        for(int i=1;i<10;i++){
            windowControl.SetButton(i,true);
        }
        if(e.getActionCommand().equals("1")){
            board.setNum(1);
            windowControl.SetButton(1,false);
        }
        if(e.getActionCommand().equals("2")){
            board.setNum(2);
            windowControl.SetButton(2,false);
        }
        if(e.getActionCommand().equals("3")){
            board.setNum(3);
            windowControl.SetButton(3,false);
        }
        if(e.getActionCommand().equals("4")){
            board.setNum(4);
            windowControl.SetButton(4,false);
        }
        if(e.getActionCommand().equals("5")){
            board.setNum(5);
            windowControl.SetButton(5,false);
        }
        if(e.getActionCommand().equals("6")){
            board.setNum(6);
            windowControl.SetButton(6,false);
        }
        if(e.getActionCommand().equals("7")){
            board.setNum(7);
            windowControl.SetButton(7,false);
        }
        if(e.getActionCommand().equals("8")){
            board.setNum(8);
            windowControl.SetButton(8,false);
        }
        if(e.getActionCommand().equals("9")){
            board.setNum(9);
            windowControl.SetButton(9,false);
        }
    }
}