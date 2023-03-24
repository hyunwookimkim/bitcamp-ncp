package com.eomcs.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp4 {

  public static void main(String[] args) throws Exception{
    Scanner keyScan = new Scanner(System.in);

    System.out.println("클라이언트 실행중 ...");

    Socket socket = new Socket("192.168.0.220",8888);
    System.out.println("서버에 연결 되었음");

    PrintStream out= new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    while(true) {
      System.out.println("계산기> ");
      String message = keyScan.nextLine();
      if(message.equals("quit")) {
        break;
      }
      while(true) {
        System.out.print("첫번째 값 : ");
        String message1 = keyScan.nextLine();

        System.out.print("두번째 값 : ");
        String message2 = keyScan.nextLine();

        System.out.print("사칙연산부호 (+,-,*,/) : ");
        String message3 = keyScan.nextLine();

        String message4 = "";
        System.out.print(message4);


        if(message3.equals("+")) {
          System.out.println(message1+"+"+message2+"="+(Integer.parseInt(message1)+Integer.parseInt(message2)));
          message4 =String.valueOf(Integer.parseInt(message1)+Integer.parseInt(message2));
          System.out.println(message4);
        }
        else if(message3.equals("-")) {
          System.out.println(message1+"-"+message2+"="+(Integer.parseInt(message1)-Integer.parseInt(message2)));
          message4 =String.valueOf(Integer.parseInt(message1)-Integer.parseInt(message2));
          System.out.println(message4);
        }
        else if(message3.equals("*")) {
          System.out.println(message1+"*"+message2+"="+(Integer.parseInt(message1)*Integer.parseInt(message2)));
          message4 =String.valueOf(Integer.parseInt(message1)*Integer.parseInt(message2));
          System.out.println(message4);
        }
        else if(message3.equals("/")) {
          System.out.println(message1+"/"+message2+"="+(Integer.parseInt(message1)/Integer.parseInt(message2)));
          message4 =String.valueOf(Double.parseDouble(message1)/Double.parseDouble(message2));
          System.out.println(message4);
        }
        else {
          System.out.println("알수없는 연산자입니다 ... ");
        }

        out.println(message);
        out.println(message1);
        out.println(message2);
        out.println(message3);
        out.println(message4);

        if(message.equals("quit")) {
          break;
        }
      }
      out.close();
      in.close();
      socket.close();
    }
    System.out.println("클라이언트 종료");
    keyScan.close();
  }

}