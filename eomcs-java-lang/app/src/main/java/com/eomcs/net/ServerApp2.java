package com.eomcs.net;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp2 {

  public static void main(String[] args) throws Exception {


    System.out.println("서버 실행중...");
    ServerSocket serverSocket =  new ServerSocket(8888);

    Socket socket = serverSocket.accept(); //클라이언트와 연결이 되었는지 기다리면서 확인ㄱ
    System.out.println("client와 연결됨 ");

    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    DataInputStream in =new DataInputStream(socket.getInputStream());

    String filename = in.readUTF();
    // 클라이언트가 보낸 문자열을 한 줄 읽을 때까지 리턴하지 않는다.
    long length = in.readLong();

    FileOutputStream fileOut = new FileOutputStream("photo2.jpg");
    for(long i = 0; i < length; i++) {
      fileOut.write(in.read());
    }
    fileOut.close();

    out.writeUTF("완료!");

    in.close();
    socket.close();
    serverSocket.close();
    System.out.println("서버종료");
  }
}


