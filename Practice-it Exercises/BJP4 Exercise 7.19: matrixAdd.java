public static int[][] matrixAdd(int[][] x, int[][] y){
        if(x.length == 0){
            return x;
        }else{
            int[][] z = new int [x.length][x[0].length];
            for (int i = 0; i <x.length; i++) {
                for (int j = 0; j <x[i].length; j++) {
                    z[i][j] = x[i][j] + y[i][j];
                }
            }
            return z;
        }
    }
