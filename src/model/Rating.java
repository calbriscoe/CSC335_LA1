package model;

public enum Rating {
	None, One, Two, Three, Four, Five;
	
	
	public static Rating setRating(int rate) {
		if (rate < 1) {
			rate = 0;
		}
		if (rate > 5) {
			rate = 5;
		}
		
		if (rate == 1) {
			return One;
		} else if (rate == 2) {
			return Two;
		} else if (rate == 3) {
			return Three;
		} else if (rate == 4) {
			return Four;
		} else if (rate == 5) {
			return Five;
		} else {
			return None;
		}
	}
}