package view;

import java.util.List;
import java.util.Scanner;

import controller.LifeRecordController;
import model.Child;

public class LifeRecordView {

	private Scanner sc = new Scanner(System.in);
	private LifeRecordController lrc = new LifeRecordController();
	private Object value;

	public void mainMenu() {
		while (true) {
			System.out.println("1. 원생등록");
			System.out.println("2. 원생검색");
			System.out.println("3. 기록관리");
			System.out.println("4. 원생삭제");
			System.out.println("5. 원생수정");
			System.out.println("9. 종료");
			System.out.print("선택: ");

			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				addChild();
				break;
			case 2:
				getChild();
				break;
			case 3:
				updateLifeRecord();
				break;
			case 4:
				removeChild();
				break;
			case 5:
				 updateLifeRecord1();
				break;
			case 9: 
				System.out.println("프로그램 종료");
				return;
			default:
				System.out.println("잘못 선택하였습니다.");
				break;
			}
		}
	}

	public void addChild() {
	System.out.print("이름: ");
	String name = sc.next();
	
	System.out.print("성별(남/여) : ");
	String gender = sc.next();
	if(!gender.equals("남") && !gender.equals("여") ) {
		System.out.println("잘못 입력했습니다.");
		return;
	}

	
	System.out.print("나이: ");
	int age = sc.nextInt();
	
	System.out.print("키: ");
	double height = sc.nextDouble();
	
	System.out.print("몸무게: ");
	double weight = sc.nextDouble();
	
	System.out.print("아빠 전화번호: ");
    String fatherPhone = sc.next();
    
    System.out.print("엄마 전화번호: ");
    String motherPhone = sc.next();
 
 
    
    lrc.addChild(new Child(name, gender, age, height, weight, fatherPhone, motherPhone) );
	}

	public void getChild() {
		System.out.print("조회할 원생 이름: ");
		String name = sc.next();
		
		System.out.print("나이: ");
		int age =sc.nextInt();
		
		Child c= lrc.getChild(name, age);
		
		if(c!=null) {
			System.out.println(c);
		} else {
			System.out.println("해당 원생이 등록되지 않았습니다.");
		}
	}

	public void updateLifeRecord() {
		
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("날짜: 년 월 일");
		String date = sc.next();
		
		System.out.print("출석(출석/결석):");
		String attendance = sc.next();
		
		if (attendance.equals("결석")) {
			System.out.println("결석입니다. 프로그램을 종료합니다.");
			return;
		}
		
		System.out.print("체온(저온/정상/고열) : ");
		String fever =sc.next();
		
		System.out.print("점심(적게/정량/많게) : ");
		String lunch = sc.next();
		
		System.out.print("낮잠 시간: ");	
		int nap = sc.nextInt();
		
		System.out.print("낮잠 분: ");	
		int nap1 = sc.nextInt();
	}
	
	public void removeChild() {
		
		System.out.println("****** 삭제할 원생 이름 : ******");
		sc.nextLine();      // 버퍼 비우기
		String name = sc.nextLine();
			
		List<Child> result = lrc.findChild(name);
	
		if (result.isEmpty()) {
		    System.out.println("검색 결과가 없습니다.");
		    return;
		}

		System.out.println("====== 검색 결과 ======");
		for (int i = 0; i < result.size(); i++) {
		    System.out.println(i + ". " + result.get(i));
		}
		
		System.out.println("삭제할 원생을 선택하세요: ");
		int index = sc.nextInt();
		
		int answer = lrc.removeChild(result, index);

		if (answer == 1) {
			System.out.println("원생 삭제 완료!");
		} else {
			System.out.println("삭제할 원생이 없습니다.");
		}	
	}
	
	public void updateLifeRecord1() {

	    System.out.print("수정할 원생 이름 : ");
	    String name = sc.next();
	    
	    if(lrc.getChild(name) == null) {
	    	System.out.println("해당 원생이 없습니다.");
	    	return;
	    }
	    System.out.print("수정할 아빠 번호 : ");
	    String fatherPhone = sc.next();
	    
	    System.out.print("수정할 엄마 번호 : ");
	    String motherphone = sc.next();

	    int result = lrc.updateLifeRecord1(name, fatherPhone, motherphone);

	    if(result > 0) {
	        System.out.println("수정 완료!");
	    } else {
	        System.out.println("해당 원생이 없습니다.");
	    }
	}
	
}
