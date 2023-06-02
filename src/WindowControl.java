import javax.swing.*;
import java.awt.*;

public class WindowControl extends JPanel{

    private BoardControl board;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;


public WindowControl(BoardControl a) {
        board = a;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel base = new JPanel();
        frame.setContentPane(base);
        base.setPreferredSize(new Dimension());
        frame.setMinimumSize(new Dimension(800,600));
        frame.setTitle("ナンプレ");
        base.setLayout(new BorderLayout());

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        button1.addActionListener(new ButtonEvent(board,WindowControl.this));
        button2.addActionListener(new ButtonEvent(board, WindowControl.this));
        button3.addActionListener(new ButtonEvent(board, WindowControl.this));
        button4.addActionListener(new ButtonEvent(board, WindowControl.this));
        button5.addActionListener(new ButtonEvent(board, WindowControl.this));
        button6.addActionListener(new ButtonEvent(board, WindowControl.this));
        button7.addActionListener(new ButtonEvent(board, WindowControl.this));
        button8.addActionListener(new ButtonEvent(board, WindowControl.this));
        button9.addActionListener(new ButtonEvent(board, WindowControl.this));

        View view = new View(board,base);
        base.add(view, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        base.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(button1,BorderLayout.SOUTH);
        buttonPanel.add(button2,BorderLayout.SOUTH);
        buttonPanel.add(button3,BorderLayout.SOUTH);
        buttonPanel.add(button4,BorderLayout.SOUTH);
        buttonPanel.add(button5,BorderLayout.SOUTH);
        buttonPanel.add(button6,BorderLayout.SOUTH);
        buttonPanel.add(button7,BorderLayout.SOUTH);
        buttonPanel.add(button8,BorderLayout.SOUTH);
        buttonPanel.add(button9,BorderLayout.SOUTH);

        //初期数値を1に設定
        board.setNum(1);
        SetButton(1,false);



        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public void SetButton(int buttonnum, boolean flag){
        if(buttonnum == 1){
                if(flag)button1.setEnabled(true);
                else button1.setEnabled(false);
        }
        if(buttonnum == 2){
                if(flag)button2.setEnabled(true);
                else button2.setEnabled(false);
        }
        if(buttonnum == 3){
                if(flag)button3.setEnabled(true);
                else button3.setEnabled(false);
        }
        if(buttonnum == 4){
                if(flag)button4.setEnabled(true);
                else button4.setEnabled(false);
        }
        if(buttonnum == 5){
                if(flag)button5.setEnabled(true);
                else button5.setEnabled(false);
        }
        if(buttonnum == 6){
                if(flag)button6.setEnabled(true);
                else button6.setEnabled(false);
        }
        if(buttonnum == 7){
                if(flag)button7.setEnabled(true);
                else button7.setEnabled(false);
        }
        if(buttonnum == 8){
                if(flag)button8.setEnabled(true);
                else button8.setEnabled(false);
        }
        if(buttonnum == 9){
                if(flag)button9.setEnabled(true);
                else button9.setEnabled(false);
        }

    }


}


