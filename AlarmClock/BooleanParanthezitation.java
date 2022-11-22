public class BooleanParanthezitation {

static int countWays(int N, String S){
    int n = S.length();
        String s1 = S, s2 = S;
        int[][]dp_true = new int[s1.length()][s2.length()];
        int[][]dp_false = new int[s1.length()][s2.length()];

        for (int g = 0; g < n; g++) {
            for (int i = 0 , j = g; j < n; i++ , j++) {
                if(g==0){
                    char ch = s1.charAt(i);

                    if(ch=='T'){
                        dp_true[i][j] = 1;
                        dp_false[i][j] = 0;
                    }else{
                        dp_true[i][j] = 0;
                        dp_false[i][j] = 1 ;
                    }
                }else{
                    for (int k = i; k < j; k++) {
                       char opertor = s2.charAt(k); 
                       int ltc = dp_true[i][k];
                       int rtc = dp_true[k+1][j];
                        int lfc = dp_false[i][k];
                        int rfc = dp_false[k+1][j];

                       if(opertor=='$'){
                        dp_true[i][j] = ltc * rtc;
                        dp_false[i][j] = rfc*ltc + lfc*rtc + rfc*lfc;
                       }else if(opertor=='|'){
                        dp_true[i][j] = ltc * rtc + lfc*rtc  + ltc*rfc;
                        dp_false[i][j] = lfc*rfc;
                       }else{ //xor
                        dp_true[i][j] = ltc* rfc + lfc*rtc;
                        dp_false[i][j] = rfc*lfc  + ltc*rtc;
                       }
                    }
                }
            }
        }
        return dp_true[0][n-1];
    }
}
