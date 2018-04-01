package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	
	

	public TrackCoach() {
	}

	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just Do It: "+fortuneService.getForture();
	}

	// add an init method 
	public void doMyStartup() {
		System.out.println("TrachCoach: inside method doMyStartup Stuff");
	}
	// add a destroy method
	public void doMyCleanup() {
		System.out.println("TrachCoach: inside method doMyCleanup Stuff");
	}
}
