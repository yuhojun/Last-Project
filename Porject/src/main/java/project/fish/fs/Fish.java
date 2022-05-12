package project.fish.fs;

import java.util.Scanner;

import project.fish.Impl.FishServiceImpl;
import project.fish.service.FishService;
import project.fish.service.FishVO;

public class Fish {
	FishService fs = new FishServiceImpl();
	FishVO vo = new FishVO();
	Scanner sc = new Scanner(System.in);
	
	public void insertFish() {
		System.out.println("회원가입을 시작합니다");
		System.out.println("ID 입력");
		vo.setUserId(sc.nextLine());
		System.out.println("이름입력");
		vo.setName(sc.nextLine());
		System.out.println("비밀번호 입력");
		vo.setPassword(sc.nextLine());
		
	      int n = fs.insertFish(vo);
	      if (n != 0) {
	         System.out.println("정상적으로 가입이 되었습니다.");
	      } else {
	         System.out.println("다시 가입해주세요");
	      }
		
	}
	
	public void login() {
		System.out.println("ID를 입력해주세요.");
		System.out.println(".");
	}
}
