package codejava.biostuffs.model;

public class Persona {
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String occupation;
	private String computer_literacy;
	private String portrait;
	private String hobbies;
	private String bio;

	public Persona(Integer id, String name, Integer age, String gender, String occupation, String computer_literacy,
			String portrait, String hobbies, String bio) {
		this(name, age, gender, occupation, computer_literacy, portrait, hobbies, bio);
		this.id = id;

	}

	public Persona(String name, Integer age, String gender, String occupation, String computer_literacy,
			String portrait, String hobbies, String bio) {

		this.name = name;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.computer_literacy = computer_literacy;
		this.portrait = portrait;
		this.hobbies = hobbies;
		this.bio = bio;
	}

	public Persona() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getComputer_literacy() {
		return computer_literacy;
	}

	public void setComputer_literacy(String computer_literacy) {
		this.computer_literacy = computer_literacy;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Pernsona [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", occupation="
				+ occupation + ", computer_literacy=" + computer_literacy + ", portrait=" + portrait + ", hobbies="
				+ hobbies + ", bio=" + bio + "]";
	}

}
