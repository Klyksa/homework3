package comparator;

import org.apache.commons.lang3.StringUtils;
import model.University;

public class UniversityMainProfileComparator implements UniversityComparator {
    @Override
    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getMainProfile().getProfileName(), u2.getMainProfile().getProfileName());
    }
}
