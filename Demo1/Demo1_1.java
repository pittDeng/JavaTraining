import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.print.attribute.standard.Finishings;

public class Demo1_1{
    public static void main(String [] args){
        FileReader fr=null;
        FileWriter fw=null;
        try{
            fr=new FileReader("C:\\Users\\Administrator\\Desktop\\LostStar.txt");
            fw=new FileWriter("C:\\Users\\Administrator\\Desktop\\output.txt");
            int n=0;
            char c[]=new char[1024];
            while((n=fr.read(c))!=-1){
                fw.write(c,0,n);
                System.out.println("success!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                fr.close();
                fw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}