package model;

public class Child {

	private String name;
	private String gender;
	private int age;
	private double height;
	private double weight;
	private String fatherPhone;
	private String motherphone;
	
	public Child() {
		
	}
	

	public Child(String name, String gender, int age, double height, double weight, String fatherPhone,
			String motherphone) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.fatherPhone = fatherPhone;
		this.motherphone = motherphone;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getFatherPhone() {
		return fatherPhone;
	}

	public void setFatherPhone(String fatherPhone) {
		this.fatherPhone = fatherPhone;
	}

	public String getMotherphone() {
		return motherphone;
	}

	public void setMoherphone(String motherphone) {
		this.motherphone = motherphone;
	}


	@Override
	public String toString() {
		return "Child [name=" + name + ", gender=" + gender + ", age=" + age + ", height=" + height + ", weight="
				+ weight + ", fatherPhone=" + fatherPhone + ", motherphone=" + motherphone + "]";
	}

	

	
}
