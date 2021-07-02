public class Grid {

    public static int[][] grid = new int[10][10];

    public static String addPosition(String col, String row, ClientHandler clientHandler){
        int colindex=Integer.parseInt(col);
        int rowindex=Integer.parseInt(row);
        StringBuilder res= new StringBuilder();
        grid[colindex][rowindex]=Server.players.get(clientHandler);
        System.out.println(Server.players.get(clientHandler));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                res.append(grid[i][j]);
            }
        }
        floodfillAll(Server.players.get(clientHandler));
        return res.toString();

    }
    public static void floodfill(int turn, int col, int row){
        if(turn == 2){
            if(grid[col][row] == 1){
                grid[col][row] = 0;
                floodfill(2, col-1, row);
                floodfill(2, col+1, row);
                floodfill(2, col, row-1);
                floodfill(2, col, row+1);
            }
        }
    }

    public static void floodfillAll(int turn){
        for(int a = 0; a<10; a++){
            for(int b = 0; b<10; b++){
                floodfill(turn,a,b);
            }
        }
    }

}
