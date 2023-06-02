// Shift を 2 回押して 'どこでも検索' ダイアログを開き、`show whitespaces` と入力して
// Enter キーを押します。これでコードに空白文字が表示されます。
public class Main {
    public static void main(String[] args) {
        BoardControl board = new BoardControl();
        //ウィンドウ作成のためのクラス
        WindowControl window = new WindowControl(board);


    }
}