package com.eomcs.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class ClientApp2 {
  public static void main(String[] args) throws Exception{

    System.out.println("클라실행");
    Socket socket = new Socket("192.168.0.31", 8888);
    System.out.println("서버에 연결됨");

    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream());

    File file = new File("photo.jpg");
    out.writeUTF(file.getName());
    out.writeLong(file.length());
    FileInputStream fileIn = new FileInputStream(file);
    int b;
    while((b = fileIn.read()) != -1) {
      out.write(b);
    }
    fileIn.close();

    System.out.println(in.readUTF());

    in.close();
    out.close();
    socket.close();

    System.out.println("클라종료");
  }
}