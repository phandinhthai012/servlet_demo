package Test;

import java.util.List;

import dao.DigitalDao;
import entity.Digital;

public class test {
	public static void main(String[] args) {
//		Digital digital = new DigitalDao().getTop1();
//		System.out.println(digital.getId());
		List<Digital> list = new DigitalDao().getTop5();
		for (Digital digital2 : list) {
			System.out.println(digital2.getId());
		}
	}
}
