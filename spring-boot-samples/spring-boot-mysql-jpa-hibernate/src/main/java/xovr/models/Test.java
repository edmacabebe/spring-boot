package xovr.models;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tests")
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String name;
	
	private String description;
	
	@NotNull
	private float passingScore;
	
	
	private float totalScore;
	
	private Time duration;
	
	public Test() {}
	
	public Test(long id) {
		this.id = id;
	}
	
	public Test(String name, String description, Time duration, float passingScore, float totalScore) {
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.passingScore = passingScore;
		this. totalScore = totalScore;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the passingScore
	 */
	public Number getPassingScore() {
		return passingScore;
	}

	/**
	 * @param passingScore the passingScore to set
	 */
	public void setPassingScore(float passingScore) {
		this.passingScore = passingScore;
	}

	/**
	 * @return the totalScore
	 */
	public float getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(float totalScore) {
		this.totalScore = totalScore;
	}

	/**
	 * @return the testDuration
	 */
	public Time getTestDuration() {
		return duration;
	}

	/**
	 * @param testDuration the testDuration to set
	 */
	public void setTestDuration(Time testDuration) {
		this.duration = testDuration;
	}

}
