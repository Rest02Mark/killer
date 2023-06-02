import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class View extends JPanel implements MouseListener {

    BoardControl board;
    JPanel base;
    public View(BoardControl a, JPanel b) {
        /* TODO 自動生成されたコンストラクター・スタブ */
        board = a;
        base = b;
        this.addMouseListener(this);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int side = Math.min(getWidth()/9,getHeight()/9) -4;
        int hidari = (getWidth()-9*side)/2;
        int ue = (getHeight()-9*side)/2;
        hidari -= 8;
        ue -= 8;

        for(int i=0;i<10;i++){
            if(i%3 == 0){
                //縦線
                g.drawLine(hidari+i*side-1, ue, hidari+i*side-1, ue+9*side);
                g.drawLine(hidari+i*side+1, ue, hidari+i*side+1, ue+9*side);
                //横線
                g.drawLine(hidari, ue+i*side-1, hidari+9*side, ue+i*side-1);
                g.drawLine(hidari, ue+i*side+1, hidari+9*side, ue+i*side+1);
            }
            g.drawLine(hidari, ue+i*side, hidari+9*side, ue+i*side);
            g.drawLine(hidari+i*side, ue, hidari+i*side, ue+9*side);
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED); // 赤色の線に設定
        g2.setFont(new Font("Arial", Font.BOLD, 40)); // フォントとサイズを設定
        g2.setStroke(new BasicStroke(3)); // 線の太さを設定


        //数字の表示
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                //if(board.isBackNum(i,j) != 0){
                //    g2.drawString(String.valueOf(board.isBackNum(i,j)),hidari+j*side+side/3-2,ue+i*side+side*2/3+4);
                //}
                if(board.isFrontNum(i,j)!= 0){
                    if(board.isFrontNum(i,j) == board.isBackNum(i,j)) {
                        g2.setColor(Color.BLACK);
                    }else{
                        g2.setColor(Color.RED);
                    }
                    g2.drawString(String.valueOf(board.isFrontNum(i,j)),hidari+j*side+side/3-2,ue+i*side+side*2/3+4);
                }
            }
        }
    }

    //マウスイベント
    @Override
    public void mouseClicked(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        System.out.println("x:"+x+" y:"+y);
        int side = Math.min(getWidth()/9,getHeight()/9) -4;
        int hidari = (getWidth()-9*side)/2;
        int ue = (getHeight()-9*side)/2;
        hidari -= 8;
        ue -= 8;
        int i = (y-ue)/side;
        int j = (x-hidari)/side;
        System.out.println("i:"+i+" j:"+j);
        if(i>=0 && i<9 && j>=0 && j<9){
            //あってるものは変更不可
            //if(board.isFrontNum(i,j)!= board.isBackNum(i,j))board.setFrontNum(i,j,board.getNum());
            board.setFrontNum(i,j,board.getNum());
            base.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
