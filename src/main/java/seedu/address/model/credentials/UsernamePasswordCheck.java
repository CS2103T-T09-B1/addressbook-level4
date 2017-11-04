package seedu.address.model.credentials;

import seedu.address.commons.util.StringUtil;
import seedu.address.model.ReadOnlyDatabase;

import java.util.List;
import java.util.function.Predicate;

public class UsernamePasswordCheck  implements Predicate<ReadOnlyAccount> {

    private final List<String> keywords;

    public UsernamePasswordCheck(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(ReadOnlyAccount account) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(account.getUsername().fullName, keyword));
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof UsernamePasswordCheck // instanceof handles nulls
                && this.keywords.equals(((UsernamePasswordCheck) other).keywords)); // state check
    }

}