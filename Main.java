
/**
 * Main-Problem Set 4B
 *
 * @Cindy Weng 
 * @Oct. 23, 2023
 */
import java.util.*;
public class Main
{

    public static void Main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("palindrom solver: enter a string");
        String pan=sc.nextLine();
        System.out.println("is it a palindrom? "+palindrome(pan));

        System.out.println("pig latin coder: enter a string");
        String pigcode=sc.nextLine();
        System.out.println("What is "+pigcode+" in Pig Latin? "+pigLatin(pigcode));

        System.out.println("StriclyAscending: Please enter a start number an end number on the same line with a space in between.");
        String sa=sc.nextLine();
        String[] nums=sa.split(" ");
        System.out.println("Number of Strictly Ascending Numbers: "+strictlyAscending(Integer.valueOf(nums[0]), Integer.valueOf(nums[1])));

        System.out.println("Enter the number for your time table: ");
        int n=Integer.valueOf(sc.nextLine());
        timeTables(n);
    }

    public static boolean palindrome(String str)
    {
        str=str.toLowerCase();
        String nonLetters = ",.:;()[]{}!?@#$%^&* ";

        String s="";
        for(int i=0; i<str.length(); i++){
            String temp=str.substring(i, i+1);
            if(!nonLetters.contains(temp)){
                s+=temp;
            }
        }

        String pan="";
        for(int i=s.length()-1; i>-1; i--){
            pan+=s.substring(i, i+1);
        }

        if(pan.equals(s)){
            return true;
        }else{
            return false;
        }
    }

    public static String pigLatin(String str){
        if(str.length()<=2){
            return str;
        }else{
            String firstL=str.substring(0, 1);
            String restL=str.substring(1);

            return restL+firstL+"ay";
        }
    }

    public static int strictlyAscending(int start, int end){
        int count=0;
        for(int i=start; i<end+1; i++){
            if(isStrictlyAscending(i)){
                count++;
            }
        }
        return count;
    }

    public static boolean isStrictlyAscending(int n){
        int digN=1;
        int num=n;
        while (num >= 10) {
            num /= 10;
            digN++;
        }

        int prevDig=n%10;
        n/=10;

        for(int i=0; i<digN-1; i++){
            if(n%10>=prevDig){
                return false;
            }
            prevDig=n%10;
            n/=10;
        }   

        return true;
    }

    public static void timeTables(int n){
        int[] arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=i+1;
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<n; c++){
                System.out.print(arr[c]*(r+1)+" ");
            }
            System.out.println();
        }
    }

}
