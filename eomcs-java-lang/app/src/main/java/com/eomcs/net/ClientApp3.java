package com.eomcs.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp3 {

  public static void main(String[] args) throws Exception{
    Scanner keyScan = new Scanner(System.in);

    System.out.println("클라이언트 실행중 ...");

    Socket socket = new Socket("127.0.0.1",8888);
    System.out.println("서버에 연결 되었음");

    PrintStream out= new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    while(true) {
      System.out.println("입력> ");

      int one = 0;
      int two = 0;

      String sign = "";

      String message = keyScan.nextLine();


      Scanner scan = new Scanner(System.in);


      System.out.print("첫번째 값 : ");
      one = scan.nextInt();

      System.out.print("두번째 값 : ");
      two = scan.nextInt();

      System.out.print("사칙연산부호 (+,-,*,/) : ");
      sign = scan.next();

      if(sign.equals("+")) {
        System.out.println(one+"+"+two+"="+(one+two));
      }
      else if(sign.equals("-")) {
        System.out.println(one+"-"+two+"="+(one-two));
      }
      else if(sign.equals("*")) {
        System.out.println(one+"*"+two+"="+(one*two));
      }
      else if(sign.equals("/")) {
        System.out.println(one+"/"+two+"="+(one/two));
      }
      else {
        System.out.println("알수없는 연산자입니다 ... ");
      }

      if(message.equals("quit")) {
        break;
      }

      //    System.out.println("서버에 메세지를 보냈음");
      out.println(message);

      //서버에서 응답이 올때까지 리턴하지 않는다.
      String response =in.nextLine();
      System.out.printf("응답 : %s\n",response);
    }
    out.close();
    in.close();
    socket.close();

    System.out.println("클라이언트 종료");
    keyScan.close();
  }

}