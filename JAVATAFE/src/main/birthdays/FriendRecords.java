package main.birthdays;

public class FriendRecords {

	private String friendsName;
	private String likes;
	private String dislikes;
	private String birthdayDay;
	private String birthdayMonth;

	public FriendRecords() {
		friendsName = "Default Name";
		likes = "Default like";
		dislikes = "Default dislikes";
		birthdayDay = "12";
		birthdayMonth = "2";
	}

	public FriendRecords(String _friendsName, String _likes, String _dislikes, String _birthdayDay,
			String _birthdayMonth) {
		friendsName = _friendsName;
		likes = _likes;
		dislikes = _dislikes;
		birthdayDay = _birthdayDay;
		birthdayMonth = _birthdayMonth;
	}

	public void setRecords(String _friendsName, String _likes, String _dislikes, String _birthdayDay,
			String _birthdayMonth) {
		friendsName = _friendsName;
		likes = _likes;
		dislikes = _dislikes;
		birthdayDay = _birthdayDay;
		birthdayMonth = _birthdayMonth;
	}

	public String getFriendsName() {
		return friendsName;
	}

	public void setFriendsName(String friendsName) {
		this.friendsName = friendsName;
	}

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getDislikes() {
		return dislikes;
	}

	public void setDislikes(String dislikes) {
		this.dislikes = dislikes;
	}

	public String getBirthdayDay() {
		return birthdayDay;
	}

	public void setBirthdayDay(String birthdayDay) {
		this.birthdayDay = birthdayDay;
	}

	public String getBirthdayMonth() {
		return birthdayMonth;
	}

	public void setBirthdayMonth(String birthdayMonth) {
		this.birthdayMonth = birthdayMonth;
	}

}
