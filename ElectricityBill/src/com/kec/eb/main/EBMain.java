package com.kec.eb.main;
import java.util.*;
import com.kec.eb.service.ConnectionService;

public class EBMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cr = sc.nextInt();
		int pr = sc.nextInt();
		String type = sc.next();
		System.out.println(new ConnectionService().generateBill(cr,pr,type));
	}

}


