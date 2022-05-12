package project.fish.service;

import java.util.List;

public interface FishService {
	List<FishVO> selectListFish(); 
	FishVO selectFish(FishVO Fish); 
	int insertFish(FishVO Fish); 
	int updateFish(String oId); 
	int deleteFish(String oId); 
	int login(String userID, String password); // 로그인 기능
	int savingMoney(int money, String oId); // 돈 저장 
}
