package project.fish.store;

public class Store {
	int mncd = 10;
	int gdncd = 10;
	int ncd = 10;
	int gre = 10;
	
	 public void choice() throws InterruptedException {
		 System.out.println("");
		 System.out.println("낚시 상점에 입장하였습니다.\n");
		 
		 System.out.println("물건을 구매하시려면 1번을 눌러주세요.");
		 System.out.println("(2번을 누르면 뒤로 갑니다.)\n");
		 
	 }
	 public int show_booty(int leg, int tail, int scales, int gr) {
		 System.out.println("");
		 System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		 System.out.println("");
		 
		 int sum = leg+tail+scales+gr;
		 if(sum==0) {
			 System.out.println("	    보유한 전리품이 없습니다.");
			 System.out.println("	    낚시를 통해 전리품을 획득하세요");
			 System.out.println("");
			 System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			 System.out.println("");
		 }
		 if(sum!=0) {
			 if(leg!=0) {
				 System.out.println("      1. 무적 낚시대");
				 System.out.println("                     가격 : 500,000원");
				 System.out.println("                     갯수 : "+ leg);
				 System.out.println("");
			 }
			 if(tail!=0) {
				 System.out.println("      2. 황금 낚시대");
				 System.out.println("                     가격 : 250,000원");
				 System.out.println("                     갯수 : "+ tail);
				 System.out.println("");
			 }
			 if(scales!=0) {
				 System.out.println("      3. 일반 낚시대");
				 System.out.println("                     가격 : 30,000원");
				 System.out.println("                     갯수 : "+ scales);
				 System.out.println("");
			 }
			 if(gr!=0) {
				 System.out.println("      3. 지렁이");
				 System.out.println("                     가격 : 100원");
				 System.out.println("                     갯수 : "+ gr);
				 System.out.println("");
			 }
			 System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			 System.out.println("");
			 System.out.print("판매할 낚시용품을 번호를 입력하세요 (2. 돌아가기) : ");
			 System.out.println("");
		 }
		return sum;
	 }
	 
	 public void show() {
		 System.out.println("");
		    System.out.println("━━━━━━━━━━━━━━ 낚시대 ━━━━━━━━━━━━━━");
		    System.out.println("");
		    System.out.println("       1. 무적 낚시대(500,000원) ");
		    System.out.println("       2. 황금 낚시대(250,000원) ");
		    System.out.println("       3. 일반 낚시대(30,000원) ");
		    System.out.println("");
		    System.out.println("━━━━━━━━━━━━━━ 미끼  ━━━━━━━━━━━━━━");
		    System.out.println("");
		    System.out.println("       4. 지렁이(100원)");
		    System.out.println("");
		    System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		    System.out.print("원하시는 물건을 번호를 입력하세요 (2. 돌아가기) : ");
		    System.out.println("");
	 }
	 public int purchase(int money, int number) {
		 System.out.println("낚시 상점에서 물건을 구매 시도하는 중입니다.");
		 if(number == 1) {
		   if(mncd <= money)
		    return money - mncd;
		  }
		 if(number == 2) {
			   if(gdncd <= money)
			    return money - gdncd;
			  }
		 if(number == 3) {
			   if(ncd <= money)
			    return money - ncd;
			  }
		 if(number == 4) {
			   if(gre <= money)
			    return money - gre;
			  }
		 
		return -1;
		 
	 }
}
