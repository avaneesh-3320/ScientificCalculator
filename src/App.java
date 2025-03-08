public class App {
    public static void main(String[] args) throws Exception {
        for(int i = 1; i <= 12; i++){
            int sigma = 0;
            int factorial = 1;
            for(int j = 1; j <= i; j++){
                sigma += j;
                factorial *= j;
            }
            System.out.println(i + "=" + sigma + "and fact = " + factorial);
        }
    }
}