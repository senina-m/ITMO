import static java.lang.Math.*;
public class Laba1{
        public static void main(String args[]){
                short[] d = new short[16];
                short k = 2;
                for(int i = 0; k <= 17; i++){
                        d[i] = k;
                        k++;
                }
                double[] m = new double[11];
                for(int i = 0; i < 11; i++){
                        m[i] = Math.random()*13 - 2;
                }
                double[][] arr = new double[16][11];
                for(int i = 0; i < 16; i++){
                        for(int j = 0; j < 11; j++){
                                double x = m[j];
                                if(d[i] == 12){
                                        arr[i][j] = atan(pow(E, pow(-pow(cos(x), 2), 1.0 / 3)));
                                }else{
                                        if((d[i] == 2) || (d[i] == 4) || (d[i] == 5) || (d[i] == 7) ||
                                        (d[i] == 8) || (d[i] == 11) || (d[i] == 14) || (d[i] == 16)){
                                                arr[i][j] = pow(E, pow(E, pow(x, 1.0 / 3)));
                                        }else{
                                                arr[i][j] = pow(2*sin(0.25/pow(x, 2)), 2);
                                        }
                                }
                                System.out.format("%8.2e", arr[i][j]);
                        }
                        System.out.println();
                }
        }
}
