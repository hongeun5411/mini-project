package view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import controller.LifeRecordController;
import model.Child;
import model.LifeRecord;

public class LifeRecordView2 {

	private Scanner sc = new Scanner(System.in);
	private LifeRecordController lrc = new LifeRecordController();

	public void mainMenu() {
		while (true) {
			System.out.println("1. 원생관리"); // "1. 원생관리" 를 콘솔창에 출력
			System.out.println("2. 기록관리"); // "2. 기록관리" 를 콘솔창에 출력
			System.out.println("9. 종료");    // "9. 종료" 를 콘솔창에 출력
			System.out.print("선택: ");       // "선택: " 를 콘솔창에 출력

			int menu = sc.nextInt();		// 사용자가 선택(입력)한 메뉴 번호를 변수에 저장
			// int menu => 정수형 변수 선언. 이름이 menu
			// sc.nextInt() => 콘솔창을 통해 입력받은 값을 정수형태로 반환
			// => 콘솔창으로 입력받은 값을 정수형태로 menu 라는 이름의 변수에 저장

			switch (menu) {					// menu 값에 따라서 case 별로 동작할 내용을 처리(조건문)
			case 1:		// menu의 값이 1일때
				
				childMenu();		// childMenu 메소드 호출(실행)
				
				break;				// 멈춤! switch 문 종료
			
			case 2 :	// menu 의 값이 2일 때
				
				recordMenu();	// recordMenu 메소드 호출
				
				break;			// 멈춤! switch 종료!
				
			case 9 :
				
				System.out.println("프로그램을 종료합니다");
				
				return;
			}
			
		}
	}
	

	public void childMenu() {
		
		System.out.println("1. 원아 등록");
		System.out.println("2. 원아 조회");
		System.out.println("3. 원아 수정");
		System.out.println("9. 이전으로");
		
		System.out.print("선택: ");

		int menu = sc.nextInt();
		
		switch (menu) {
		
		case 1 :
			addChild();
			break;
		
		case 2 :
			addChild();
			break;
			
		case 3 :
			updateLifeRecord1();
			break;
			
		case 9 :
			System.out.println("메인 메뉴로 돌아갑니다!");
			return;
		}	
	}	
	

	
	public void addChild() {
		System.out.println("이름 : ");
		String name = sc.next();

		System.out.print("성별(남/여) : ");
		String gender = sc.next();
		if (!gender.equals("남") && !gender.equals("여")) {
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

		lrc.addChild(new Child(name, gender, age, height, weight, fatherPhone, motherPhone));
	}

	private void recordMenu() {
		System.out.print("원아 검색 : ");
		String name = sc.next();
		Child c = lrc.getChild(name);
		
		if(c==null) {
			System.out.println("해당원아가 존재하지 않습니다.");
		return;
		}
		
		System.out.println("1. 기록 추가");
		System.out.println("2. 기록 조회");
		System.out.print("선택: ");
		
		int rc = sc.nextInt();
		
		switch(rc) {
		case 1 : addrecord(c);
		break;
		
		case 2 : viewRecord(c);
			break;
		
		}
		
	}	
	
	public void addrecord(Child c) {
		LocalDate today = LocalDate.now();
		System.out.println(today);

		System.out.print("출석(출석/결석):");
		String attendance = sc.next();

		if (attendance.equals("결석")) {
			System.out.println("결석입니다. 프로그램을 종료합니다.");
			return;
		}

		System.out.print("체온(저온/정상/고열) : ");
		String fever = sc.next();

		System.out.print("점심(적게/정량/많게) : ");
		String lunch = sc.next();

		System.out.print("낮잠 분: ");
		int nap = sc.nextInt();	
		
		int result = lrc.addRecord(c, fever, lunch, nap);
		if(result == 1) {
		System.out.println("기록을 성공했습니다");
		} else {
		System.out.println("기록을 실패했습니다");
		}
	}
	
	public void viewRecord(Child c) {
		
		
		// 해당 원아의 기록 조회
		List<LifeRecord> result = lrc.getRecordList(c);
		
		for(LifeRecord r : result) {
			System.out.println(r);
		} 
	}
	
	public void updateLifeRecord() {

	}

	public void removeChild() {

		System.out.println("****** 삭제할 원생 이름 : ******");
		sc.nextLine(); // 버퍼 비우기
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

		if (lrc.getChild(name) == null) {
			System.out.println("해당 원생이 없습니다.");
			return;
		}
		System.out.print("수정할 아빠 번호 : ");
		String fatherPhone = sc.next();

		System.out.print("수정할 엄마 번호 : ");
		String motherphone = sc.next();

		int result = lrc.updateLifeRecord1(name, fatherPhone, motherphone);

		if (result > 0) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("해당 원생이 없습니다.");
		}
	}

}
