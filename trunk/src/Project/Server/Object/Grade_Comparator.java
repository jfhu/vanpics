package Project.Server.Object;

import java.util.Comparator;

public final class Grade_Comparator implements Comparator{

	public int compare(Object a, Object b) {
		if (((Grade) a).getPercentage() < ((Grade) b).getPercentage()) {
			return 1;
		} else {
			return 0;
		}
	}

}
