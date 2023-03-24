package com.eomcs.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp5 {

  static int result = 0;

  static int plus(String value) {
    return result += Integer.parseInt(value);
  }

  static int minus(String value) {
    return result -= Integer.parseInt(value);
  }

  static int multiple(String value) {
    return result *= Integer.parseInt(value);
  }

  static int divide(String value) {
    return result /= Integer.parseInt(value);
  }


  public static void main(String[] args) throws Exception{
    Scanner keyScan = new Scanner(System.in);

    System.out.println("클라이언트 실행중 ...");

    Socket socket = new Socket("127.0.0.1",8888);
    System.out.println("서버에 연결 되었음");

    PrintStream out= new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    while(true) {
      System.out.println("계산기> ");
      String message = keyScan.nextLine();
      if(message.equals("quit")) {
        break;
      }

      System.out.print("첫번째 값 : ");
      String message1 = keyScan.nextLine();

      System.out.print("두번째 값 : ");
      String message2 = keyScan.nextLine();

      System.out.print("사칙연산부호 (+,-,*,/) : ");
      String message3 = keyScan.nextLine();

      String message4 = "";
      System.out.print(message4);


      if(message3.equals("+")){
        System.out.println(message1+"+"+message2+"="+(Integer.parseInt(message1)+Integer.parseInt(message2)));
        message4 =String.valueOf(Integer.parseInt(message1)+Integer.parseInt(message2));
        System.out.println(message4);

        //     ClientApp5.plus(Integer.parseInt(message2));
        //        ClientApp5.minus(Integer.parseInt(message4));
        //        ClientApp5.multiple(Integer.parseInt(message4));
        //        ClientApp5.divide(Integer.parseInt(message4));
      }
      else if(message3.equals("-")) {
        System.out.println(message1+"-"+message2+"="+(Integer.parseInt(message1)-Integer.parseInt(message2)));
        String minusResult = (message1+"-"+message2+"="+(Integer.parseInt(message1)-Integer.parseInt(message2)));
        out.println(minusResult);
      }
      else if(message3.equals("*")) {
        System.out.println(message1+"*"+message2+"="+(Integer.parseInt(message1)*Integer.parseInt(message2)));
        String mutipleResult = (message1+"*"+message2+"="+(Integer.parseInt(message1)*Integer.parseInt(message2)));
        out.println(mutipleResult);
      }
      else if(message3.equals("/")) {
        System.out.println(message1+"/"+message2+"="+(Integer.parseInt(message1)/Integer.parseInt(message2)));
        String devideResult = (message1+"/"+message2+"="+(Integer.parseInt(message1)/Integer.parseInt(message2)));
        out.println(devideResult);
      }
      else {
        System.out.println("알수없는 연산자입니다 ... ");
      }

      out.println(message);
      out.println(message1);
      out.println(message2);
      out.println(message3);
      out.println(message4);

      out.close();
      in.close();
      socket.close();
    }


    System.out.println("클라이언트 종료");
    keyScan.close();
  }


}