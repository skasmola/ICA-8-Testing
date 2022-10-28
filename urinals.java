import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

// Author : Sakshith Reddy
public class urinals {

    public static void main(String[] args) throws Exception {
        File file = new File("urinal.dat");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){

            String str = sc.nextLine();

            String ans = countUrinals(str);

            FileWriter fw = new FileWriter("rule.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(ans);
            bw.newLine();
            bw.close();

            System.out.println(ans);
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
                return "Please Enter Valid Input";
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

    public String readFile(String fileName) {

        if(fileName.isEmpty()){
            return "File is empty, please enter a valid file";
        } else if (!fileName.equals("urinals.dat")) {
            return "File Not Found";
        }

        return "urinals.dat";
    }
}
