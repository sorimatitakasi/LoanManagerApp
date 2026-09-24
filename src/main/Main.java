package main;

import java.util.Scanner;

import constant.Menu;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println(Menu.TITLE);
			System.out.print(Menu.MENU);
			String choice = scanner.nextLine();

			switch (choice) {
			case Menu.EXIT:
				running = false;
				System.out.println("終了します。");
				break;
			default:
				System.out.println("a");
			}
			System.out.println();
		}

		scanner.close();
	}
}