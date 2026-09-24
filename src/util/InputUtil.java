package util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {

	private final Scanner scanner;

	public InputUtil(Scanner scanner) {
		this.scanner = scanner;
	}

	public String readLine(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine().trim();
	}

	public int readInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			String line = scanner.nextLine().trim();
			try {
				return Integer.parseInt(line);
			} catch (NumberFormatException e) {
				System.out.println("※ 数値を入力してください。");
			}
		}
	}

	public LocalDate readDate(String prompt) {
		while (true) {
			System.out.print(prompt);
			String line = scanner.nextLine().trim();
			try {
				return LocalDate.parse(line);
			} catch (DateTimeParseException e) {
				System.out.println("※ 日付は yyyy-MM-dd の形式で入力してください（例: 2026-09-20）。");
			}
		}
	}
}