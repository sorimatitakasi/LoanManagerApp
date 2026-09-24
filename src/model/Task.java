package model;

import java.time.LocalDate;

public class Task {
	private int id;
	private String title; // 債務者名
	private LocalDate lendDate; // 貸付日
	private int lendAmount; // 貸付金
	private int paidAmount; // 回収金額
	private LocalDate dueDate; // 返済予定日
	private boolean paidOff; // 返済済み判定

	public Task(int id, String title, LocalDate lendDate, int lendAmount, LocalDate dueDate) {
		this.id = id;
		this.title = title;
		this.lendDate = lendDate;
		this.lendAmount = lendAmount;
		this.dueDate = dueDate;
		this.paidAmount = 0;
		this.paidOff = false;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getLendDate() {
		return lendDate;
	}

	public void setLendDate(LocalDate lendDate) {
		this.lendDate = lendDate;
	}

	public int getLendAmount() {
		return lendAmount;
	}

	public void setLendAmount(int lendAmount) {
		this.lendAmount = lendAmount;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isPaidOff() {
		return paidOff;
	}

	public void setPaidOff(boolean paidOff) {
		this.paidOff = paidOff;
	}

	public String toString() {
		String status = paidOff ? "返済済み" : "未返済";
		return String.format("ID:%d | %s | 貸付日:%s | 貸付金:%,d円 | 回収金額:%,d円 | 返済予定日:%s | %s",
				id, title, lendDate, lendAmount, paidAmount, dueDate, status);
	}
}