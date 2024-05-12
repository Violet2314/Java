import java.io.*;
import java.nio.charset.Charset;

public class hjsaikod {
    public hjsaikod() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
        //File wok = new File("地址");
        FileOutputStream os = new FileOutputStream("地址");
        os.write(97);
        String str = "thangks";
        byte[] bytes = str.getBytes();
        os.write(bytes);
        os.close();
        FileReader so = new FileReader("地址", Charset.forName("GBK"));

        char[] chars = new char[1024];
        int len;
        while((len = so.read(chars)) != 0){
            System.out.println(new String(chars,0,len));
        }
        FileInputStream fis = new FileInputStream("myio\\a.txt");
    }

}
