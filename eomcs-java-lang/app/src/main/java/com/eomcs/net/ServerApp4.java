package com.eomcs.net;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp4 {

  public static void main(String[] args) throws Exception {
    Scanner keyScan = new Scanner(System.in);

    System.out.println("서버 실행중...");
    ServerSocket serverSocket =  new ServerSocket(8888);
    Socket socket = serverSocket.accept(); //클라이언트와 연결이 되었는지 기다리면서 확인ㄱ

    System.out.println("client와 연결됨 ");
    Scanner in = new Scanner(socket.getInputStream());
    PrintStream out =new  PrintStream(socket.getOutputStream());
    while(true) {
      // 클라이언트가 보낸 문자열을 한 줄 읽을 때까지 리턴하지 않는다.
      String message = in.nextLine();

      System.out.println(message);
      if(message.equals("quit")) {
        break;
      }
      System.out.print("입력> ");
      //      String str = keyScan.nextLine();
      //      out.println(str);

      String message1 = in.nextLine();
      String message2 = in.nextLine();
      //여기서 부터 여기ㅣ까지
      if(message.equals("+")) {
        System.out.println(message1+"+"+two+"="+(one+two));
      }
      else if(message.equals("-")) {
        System.out.println(one+"-"+two+"="+(one-two));
      }
      else if(message.equals("*")) {
        System.out.println(one+"*"+two+"="+(one*two));
      }
      else if(message.equals("/")) {
        System.out.println(one+"/"+two+"="+(one/two));
      }
      else {
        System.out.println("알수없는 연산자입니다 ... ");
      }
      //여기까지
    }
    socket.close();
    serverSocket.close();
    System.out.println("서버 종료!");
    keyScan.close();
  }

}