import java.util.Scanner;

class GFG {
    public static int  sumn(int n,int sum){
        if(n==0){
            return sum;
        }
        return sumn(n-1,sum+n);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // code here
        System.out.print(sumn(n,0));
    }
}