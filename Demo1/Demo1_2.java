import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;

public class Demo1_2{
    public static void main(String [] args){
        BufferedReader br=null;
        BufferedWriter bw=null;
        FileReader fr=null;
        FileWriter fw=null;
        try{
            fr=new FileReader("C:\\Users\\Administrator\\Desktop\\LostStar.txt");
            br=new BufferedReader(fr);
            fw=new FileWriter("C:\\Users\\Administrator\\Desktop\\output.txt");
            bw=new BufferedWriter(fw);
            String s=null;
            while((s=br.readLine())!=null){
                bw.write(s);
                System.out.println(s);
            }

        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
                fr.close();
                bw.close();
                fw.close();//请注意这个关闭次序，先打开的后关闭
            }catch(IOException e){
                //e.printStackTrace();
            }
        }
    }
}