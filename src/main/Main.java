package main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import constant.Menu;
import model.Task;
import service.Service;
import util.InputUtil;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InputUtil inputUtil = new InputUtil(scanner);
		Service service = new Service();
		boolean running = true;

		while (running) {
			System.out.println(Menu.TITLE);
			System.out.print(Menu.MENU);
			String choice = scanner.nextLine();

			switch (choice) {
			case Menu.CREATE:
				create(inputUtil, service);
				break;
			case Menu.EXIT:
				running = false;
				System.out.println("終了します。");
				break;
			case Menu.READ:
				read(service);
				break;
			case Menu.UPDATE:
				update(inputUtil, service);
				break;
			default:
				System.out.println("選択されたのは: " + choice + "（まだ機能は未実装です）");
			}
			System.out.println();
		}

		scanner.close();
	}

	private static void create(InputUtil inputUtil, Service service) {
		String title = inputUtil.readLine("債務者名：");
		LocalDate lendDate = inputUtil.readDate("貸付日（例: 2026-09-20）：");
		int lendAmount = inputUtil.readInt("貸付金：");
		LocalDate dueDate = inputUtil.readDate("返済予定日（例: 2026-12-31）：");

		Task task = service.addTask(title, lendDate, lendAmount, dueDate);
		System.out.println("登録しました -> " + task);
	}

	private static void read(Service service) {
		List<Task> tasks = service.showTasks();
		if (tasks.isEmpty()) {
			System.out.println("まだ記録がありません。");
			return;
		}
		System.out.println("--- 一覧 ---");
		for (Task task : tasks) {
			System.out.println(task);
		}
	}

	private static void update(InputUtil inputUtil, Service service) {
		int id = inputUtil.readInt("更新したいID：");
		Task existing = service.findById(id);
		if (existing == null) {
			System.out.println("※ そのIDのデータは見つかりませんでした。");
			return;
		}
		System.out.println("現在の内容: " + existing);

		int additionalPaidAmount = inputUtil.readInt("今回の回収金額：");
		LocalDate newDueDate = inputUtil.readDate("新しい返済予定日（例: 2026-12-31）：");

		boolean success = service.updateTask(id, additionalPaidAmount, newDueDate);
		System.out.println(success ? "更新しました。" : "更新に失敗しました。");
	}

}