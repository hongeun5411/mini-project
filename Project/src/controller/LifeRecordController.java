package controller;

import java.util.ArrayList;
import java.util.List;

import model.Child;

public class LifeRecordController {

	private List<Child> childList = new ArrayList<Child>();
	private List<Record> lifeRecordList;
	
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
	
//	public String getResult() {
//		List<Child> result = findChild(name);
//	}
}
