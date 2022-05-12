package project.fish;

import java.util.Scanner;

import project.fish.Impl.FishServiceImpl;
import project.fish.fs.Fish;
import project.fish.service.FishService;

public class Menu {
	FishService fs = new FishServiceImpl();
	Fish fh = new Fish();
	private Scanner sc = new Scanner(System.in);
	String oId; // 로그인했을때 계속 로구안유지

	public void run() throws InterruptedException {
		mainTitle();
	}

	private int mainTitle() throws InterruptedException {
		boolean a = true;
		while (a) {
			System.out.println("       낚	시	왕              ");
			System.out.println("		o          o");
			System.out.println("        o");
			System.out.println("o            ______      o");
			System.out.println("           _/  (   \\_");
			System.out.println(" _       _/  (       \\_  O");
			System.out.println("| \\_   _/  (   (    0  \\");
			System.out.println("|== \\_/  (   (          |");
			System.out.println("|=== _ (   (   (        |");
			System.out.println("|==_/ \\_ (   (          |");
			System.out.println("|_/     \\_ (   (    \\__/");
			System.out.println("           \\_ (      _/");
			System.out.println("            |  |___/");
			System.out.println("           /__/		");
			String s = "회사를 다니며 주식투자를 하다가 전재산을 잃고 회사에서도 쫓겨나고 고향인 어촌마을로 돌아가게 된다.\n\n"
					+ "수산물시장에서 잡은 물고기로 이익창출하는것을 보고 낚시를 통해 물고기를 잡아 수익내고 돈을 모아 다시 주식투자를 해보겠다는 계획을 세운다. \n\n"
					+ "물고기를 팔아 주인공의 소지금이 500만원이 되면 게임이 종료됩니다.\n\n";

			for (int i = 0; i < s.length(); i++) { // 프롤로그 타이핑 효과
				Thread.sleep(25);
				System.out.print(s.charAt(i));
			}
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("		낚			시		 ");
			System.out.println("		 	1. 회 원 가 입		 ");
			System.out.println(" 		 	2. 로  그  인    	 ");
			System.out.println(" 		 	3. 종   료      	 ");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			int menu = sc.nextInt();

			if (menu == 1) {
				fh.insertFish();
			} else if (menu == 2) {
				System.out.println("ID를 입력해주세요.");
				oId = sc.next();
				System.out.println("비밀번호를 입력해주세요.");
				String oPassword = sc.next();

				int result = fs.login(oId, oPassword);
				if (result == 1) {
					fs.savingMoney(sbMenu(oId), oPassword);
				} else {
					continue;
				}
				break;
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}
		return 0;

	}

	private int sbMenu(String oId) throws InterruptedException {
		boolean a = true;
		while (a) {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("		낚			시		 ");
			System.out.println("		 	1. 게 임 시 작		 ");
			System.out.println(" 		 	2. 정 보 변 경    	 ");
			System.out.println(" 		 	3. 종	  료 	 ");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			int menu = sc.nextInt();

			if (menu == 1) {

			} else if (menu == 2) {
				menu = dataUser(oId);
			} else if (menu == 3) {
				System.out.println("게임을 종료합니다.");
				  a = false;
		            break;
			}
		}
		return 0;

	}

	private int dataUser(String oId) throws InterruptedException {
		boolean a = true;
		while (a) {
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("		정 보 변 경		 ");
			System.out.println("		 	1. 비 밀 번 호 변 경	");
			System.out.println(" 		 	2. 계 정 탈 퇴    	 ");
			System.out.println(" 		 	3. 돌 아 가 기	    ");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			int menu = sc.nextInt();
			
			if (menu == 1) {
				int result = fs.updateFish(oId); //아이디를 비교해서 비밀번호를 바꿈
				if (result == 1) {
		               System.out.println("비밀번호 변경 성공");
		            } else {
		               System.out.println("비밀번호 변경 실패");
		            }
		            continue;
				
			} else if (menu == 2) {
				fs.deleteFish(oId);
				System.out.println("계정삭제완료");
				return mainTitle();
			} else if (menu == 3) {
				  a = false;
		            break;
			}
		}
		return 0;
	}

}
