package main;

public class MyFriend {

	public static void main(String[] args) {
		Friend myFriend = new Friend();

		myFriend.setName("Sample Person");
		myFriend.setAddress("Sample Street", "Sample Suburb", "4000");
		System.out.println("" + myFriend.getName());
		System.out.println("" + myFriend.getStreet());
		System.out.println("Hello world!");

	}

}
