package controller;

import java.util.ArrayList;
import java.util.List;

import model.Child;
import model.LifeRecord;

public class LifeRecordController {

	private List<Child> childList = new ArrayList<Child>();
	private List<LifeRecord> lifeRecordList = new ArrayList<>();
	
	public void addChild(Child child) {
		
		for (Child c : childList) {
			if (c.getName().equals(child.getName())) {
				System.out.println("이미 등록된 이름입니다.");
				return;
			}
		}
		
		childList.add(child);
	}
	
	public List<Child> getChildList() {
		return childList;
	}
	
	//  lrc.addChild(new Child(name, gender, age, height, weight, fatherPhone, motherPhone)
	
	public Child getChild(String name) {
		for(Child child : childList) {
			if(child.getName().equals(name))
			return child;
			
		}
		return null;
	}
		
	public Child getChild(String name, int age) {
		for(Child child : childList) {
			if(child.getName().equals(name) &&
					child.getAge()==age) {
		             return child;
			}
		}
		
		return null;		
	}
	
	public List<Child> findChild(String name) {
		List<Child> result = new ArrayList<>();
		for(Child c : childList ) {
			
			if ( c.getName().contains(name)) {
				result.add(c);
			}
		}
		return result;
	}
	
	public int removeChild(List<Child> result, int index) {
		Child c = result.get(index);
		int realIndex = getChildList().indexOf(c);
		getChildList().remove(realIndex);
		
		return 1;
	}
	
	public int addRecord(Child c, String fever, String lunch, int nap) {
		LifeRecord record = new LifeRecord();
		record.setChild(c);
		record.setFever(fever);
		record.setLunch(lunch);
		record.setNap(nap);
		
		lifeRecordList.add(record);
		return 1;
	}

	public int updateLifeRecord1(String  name, String fatherPhone, String motherphone) {
		for(int i =0; i < childList.size(); i++ ) {
			Child child = childList.get(i);
			if(child.getName().equals(name) ) {
		             child.setFatherPhone(fatherPhone);
		             child.setMoherphone(motherphone);
		             return 1;
			}
		}
		return 0;
	}
	
	public List<LifeRecord> getRecordList(Child re) {
		// < 전달 받은 원아(Child re)의 기록 목록(결과를 따로 보관)을 반환 >
		
		// * 결과를 담을 리스트
		List<LifeRecord> result = new ArrayList<>();
		
		// * 현재 저장된 기록 목록(lifeRecordList)에서 해당 원아의 기록만 결과리스트에 추가
		// for(초기식;조건식;증감식) {}
		// for(자료형 변수명 : 배열이나리스트명) {}
		for(LifeRecord r : lifeRecordList) {
			
			// 기록된 정보 중 원아의 이름과, 전달받은 원아의 이름이 일치하면 결과에 추가
			if(r.getChild().getName().equals(re.getName())  ) {
				
				result.add(r);
				
			}
			
		} return result;
		
		// * 결과 목록 반환
		
		
	}
	
	
//	public String getResult() {
//		List<Child> result = findChild(name);
//	}
}
