package com.jpa.Hibernate_Many_To_Many_Unidirectional.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

import com.jpa.Hibernate_Many_To_Many_Unidirectional.dao.UserBankDao;
import com.jpa.Hibernate_Many_To_Many_Unidirectional.dto.Bank;
import com.jpa.Hibernate_Many_To_Many_Unidirectional.dto.User;

public class UserBankInsertController {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		UserBankDao dao=new UserBankDao();
		char p;
		
		do {
			System.out.println("Enter your option....");
			System.out.println("1.INSERT\n2.GetById\n3.DELETE\n4.UPDATE\n5.DISPLAY\n6.DeleteByJPQL\n7.UpdateByJPQL");
			int key=sc.nextInt();
			switch(key) {
		case 1:{
		List<Bank> banks=Arrays.asList(new Bank(321, "HDFC", "Noida", "hdfc6645", 420),new Bank(322, "SBI", "Banglore", "sbi786", 461));
		
		
		List<User> users=Arrays.asList(new User("Md Irfan", 3423566, 999999,LocalDate.of(2024, 01, 31), "123", banks),
					new User("Suresh Kumar", 23847934, 8888888, LocalDate.of(2024, 02, 29),"124", banks));
		
		dao.saveUserBankDao(users,banks);
		}
		case 2:{
			User user=dao.getAllBankByUserId(2);
			List<Bank> banks=user.getBanks();
			banks.forEach(a->{
				
			System.out.println(a.getId());
			System.out.println(a.getName());
			System.out.println(a.getBranchCode());
			System.out.println(a.getAddress());
			System.out.println(a.getIfscCode());
			});
					
			
		}
		break;
		
		case 3:{
			System.out.println("Enter the id to delete");
			int id=sc.nextInt();
			User user=dao.deleteUserByIdDao(id);
			if(user!=null){
				System.out.println("Data Deleted Successfully");
			}else {
				System.out.println("Data Not deleted Successfully");
			}
		}
		break;
		case 4:{
			for (User user: dao.getAllUserAndBankDao()) {
				System.out.println(user);
				
			}
			
		}
		break;
			
			}System.out.println("Press Y/y to continue");
			p=sc.next().charAt(0);
			
			}while(p=='Y'|| p== 'y');
		System.out.println("Program ends");

	}

}
