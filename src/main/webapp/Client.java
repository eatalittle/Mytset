import java.net.Socket;
import java.io.*;
import java.util.Scanner;


public class Client {
    public static void main(String [] args){
         String ip="10.112.74.226";
         int port=5000;
         OutputStream out=null;
         InputStream in =null;

         try {
             Socket s = new Socket(ip, port); //建立连接
             Scanner scan = new Scanner(System.in);

             out=s.getOutputStream();
             DataOutputStream out1 = new DataOutputStream(out);//????
             out1.writeUTF("我是客户端"+s.getLocalSocketAddress());

             in=s.getInputStream();
             DataInputStream in1 = new  DataInputStream(in);
             System.out.println("服务器反馈:"+in1.readUTF());

            while(true) {
                String str1 = scan.next();

                System.out.println("客户端发送数据：" + str1);

                out1.writeUTF(str1);

            }






         }
         catch(IOException e)
        {
            e.printStackTrace();
        }

}
}
