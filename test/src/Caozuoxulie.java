import java.util.Scanner;

public class Caozuoxulie {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] res = new int[n];
        int left = 0;
        int right = n-1;
        int index = n-1;
        while(right > left){
            res[left++] = arr[index--];
            res[right--] = arr[index--];
        }
       	if(left == right){
            res[left] = arr[index];
        }
      	for(int i=0;i<n;i++){
            if(i != n-1){
                System.out.print(res[i] + " ");
            }else{
                System.out.print(res[i]);
            }
        }
    }
}
