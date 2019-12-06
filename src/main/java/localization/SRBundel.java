package localization;

import java.util.ListResourceBundle;

public class SRBundel extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"Hi","EN"}};
    }
}
