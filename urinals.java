import java.io.File;
import java.util.Scanner;

// Author : Sakshith Reddy
public class urinals {

    public static void main(String[] args) throws Exception {
        File file = new File("urinal.dat");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){

            String str = sc.nextLine();
//            System.out.println(str);

            String ans = countUrinals(str);

            System.out.println(ans);

//            write to file
//            close

        }
    }

    public static String countUrinals(String str){
        int n = str.length();
        int ans = 0;


        if(str.charAt(0) == '0' && str.charAt(1) == '0'){
            char[] chars = str.toCharArray();
            chars[0] = '1';
            str = String.valueOf(chars);
            ans++;
        }

        for(int i = 1;i < n-1;i++){

            if(str.charAt(i) == '1'){
                if(str.charAt(i-1) == '1' || str.charAt(i+1) == '1'){
                    ans = -1;
                    break;
                }
            }else if(str.charAt(i) == '0'){
                if(str.charAt(i-1) == '0' && str.charAt(i+1) == '0'){
                    char[] chars = str.toCharArray();
                    chars[i] = '1';
                    str = String.valueOf(chars);
                    ans++;
                }
            }else {
                System.out.println("Please enter valid input");
                break;
            }

        }

        if (str.charAt(n-2) == '0' && str.charAt(n-1) == '0') {
            char[] chars = str.toCharArray();
            chars[n-1] = '1';
//          str = String.valueOf(chars);
            ans++;
        }

        return String.valueOf(ans);
    }
}
