public class BoardControl {

    //9*
    private final int[][] BackBoard;
    private final int[][] FrontBoard;
    public int[][] copyFrontBoard;
    private int num = 1;

    public BoardControl() {
        BackBoard = new int[9][9];
        FrontBoard = new int[9][9];
        copyFrontBoard = new int[9][9];
        //リストを宣言
        int[] tmp = new int[81];
        //0から80までの数字が入った配列を作る
        for(int i = 0; i < 81; i++){
            tmp[i] = i;
        }
        //tmpの中身をシャッフル
        for(int i = 0; i < 81; i++){
            int index = (int)(Math.random() * 81);
            int tmp2 = tmp[i];
            tmp[i] = tmp[index];
            tmp[index] = tmp2;
        }
        initBoard();

        //数独の問題作成
        if(!CreateBackboard(0,0)){
            System.out.println("backboard is not created");
        }
        //問題をセット
        setProblem();

        displaybackboard();
    }

    private boolean CreateBackboard(int row, int col) {
        if(col == 9){
            col = 0;
            row++;
            if(row == 9){
                return true;
            }
        }

        int[] values = {1,2,3,4,5,6,7,8,9};
        //valueの中身をシャッフル
        for(int i = 0; i < 9; i++){
            int index = (int)(Math.random() * 9);
            int tmp2 = values[i];
            values[i] = values[index];
            values[index] = tmp2;
        }

        for(int value: values){
            if(isValid(row,col,value)){
                BackBoard[row][col] = value;
                if(CreateBackboard(row,col+1)){
                    return true;
                }
                BackBoard[row][col] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int row, int col, int value) {
        //縦をチェック
        for(int i = 0; i < 9; i++){
            if(BackBoard[i][col] == value){
                return false;
            }
        }
        //横をチェック
        for(int i = 0; i < 9; i++){
            if(BackBoard[row][i] == value){
                return false;
            }
        }
        //3*3をチェック
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for(int i = rowStart; i < rowStart + 3; i++){
            for(int j = colStart; j < colStart + 3; j++){
                if(BackBoard[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }

    private void displaybackboard() {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++) {
                System.out.print(BackBoard[i][j]);
            }
            System.out.println();
        }
    }

    private void initBoard() {
        for (int i = 0; i < 9; i++) {
            BackBoard[i][i] = 0;
            FrontBoard[i][i] = 0;
        }
    }

    public int isBackNum(int col, int row){
        return BackBoard[col][row];
    }
    public int isFrontNum(int col, int row){
        return FrontBoard[col][row];
    }

    public void setNum(int a){
        num = a;
        System.out.println(num);
    }
    public int getNum(){
        return num;
    }

    public void setFrontNum(int col, int row, int num){
        FrontBoard[col][row] = num;
        if(ClearCheck()){
            System.out.println("Clear");
        }
    }

    public boolean ClearCheck(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++) {
                if(isFrontNum(i,j) != isBackNum(i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    public void setProblem() {
        int[] tmp = new int[81];
        //0から80までの数字が入った配列を作る
        for(int i = 0; i < 81; i++){
            tmp[i] = i;
        }
        //tmpの中身をシャッフル
        for(int i = 0; i < 81; i++){
            int index = (int)(Math.random() * 81);
            int tmp2 = tmp[i];
            tmp[i] = tmp[index];
            tmp[index] = tmp2;
        }
        int idx = 0;

        do{
            setFrontNum(tmp[idx] / 9, tmp[idx] % 9, BackBoard[tmp[idx] / 9][tmp[idx] % 9]);
            idx++;
            //FrontboardをcopyFrontboardにコピー
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    int aaaa = FrontBoard[i][j];
                    copyFrontBoard[i][j] = aaaa;
                }
            }
        }while(!Solve_wo_Backtracking() && idx < 81);

        if(idx == 81){
            System.out.println("problem is not created");
        }
    }

    private boolean Solve_wo_Backtracking() {
        //copyFrontboardの全てのマスが埋まっているか確認
        boolean flag = true;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(copyFrontBoard[i][j] != isBackNum(i,j)){
                    flag = false;
                    break;
                }
            }
            if(!flag)break;
        }
        if(flag){
            return true;
        }
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                //既に数字が入ってる場合飛ばす
                if(copyFrontBoard[row][col] != 0)continue;
                for(int value = 1;value <=9;value++){
                    int num;
                    if((num = onlyone(row,col)) > 0){
                       copyFrontBoard[row][col] = num;
                        if(Solve_wo_Backtracking()){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private int onlyone(int row, int col) {
        int num = -1;
        for(int value = 1;value <=9;value++){
            //flag 0 = その数字が入れられる
            //flag 1 = その数字が入れられない
            int flag =0;
            //縦の確認
            for(int i = 0; i < 9; i++){
                if(copyFrontBoard[i][col] == value){
                    flag = 1;
                }
            }
            //横の確認
            for(int i = 0; i < 9; i++){
                if(copyFrontBoard[row][i] == value){
                    flag = 1;
                }
            }
            //3*3の確認
            int rowStart = (row / 3) * 3;
            int colStart = (col / 3) * 3;
            for(int i = rowStart; i < rowStart + 3; i++){
                for(int j = colStart; j < colStart + 3; j++){
                    if(copyFrontBoard[i][j] == value){
                        flag = 1;
                    }
                }
            }
            if(flag == 0){
                if(num != -1){
                    return -1;
                }
                num = value;
            }
        }
        return num;
    }
}

//setProblem2 仮定法ありで問題を解けるか
