package project.fish.store;

public class Inventory {
	public int inventory_show(int[] cnt) {
		int sum=0;
		   for(int i=0; i<7;i++) {
			   sum+=cnt[i];
		   }
System.out.println("");
		   
		   System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		   System.out.println("");
		
		   if(sum==0) {
			   System.out.println("	    보유한 물품이 없습니다.");
			   System.out.println("	    낚시 상점에 가서 물품을 구매하세요");
			   System.out.println("");
			   System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			   System.out.println("");
		   }
		   else {
			   if(cnt[1]>0) {
				   System.out.println("      1. 무적 낚시대");
				   System.out.println("                     기능 : 생태계 교란종을 잡았을때 게임종료 무효화.");
				   System.out.println("                     갯수 : "+ cnt[1]);
				   System.out.println("");
			   }
			   if(cnt[2]>0) {
				   System.out.println("      2. 황금 낚시대");
				   System.out.println("                     기능 : 물고기를 즉시 잡을 수 있다.");
				   System.out.println("                     갯수 : "+ cnt[2]);
				   System.out.println("");
			   }
			   if(cnt[3]>0) {
				   System.out.println("      2. 일반 낚시대");
				   System.out.println("                     갯수 : "+ cnt[3]);
				   System.out.println("");
			   }
			   if(cnt[4]>0) {
				   System.out.println("      2. 지렁이");
				   System.out.println("                     갯수 : "+ cnt[4]);
				   System.out.println("");
			   }
			   
			   System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			   System.out.println("");
		   }
		return sum;
	}

}
