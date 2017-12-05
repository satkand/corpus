package automation.framework.utils;

import java.util.Map;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

/**
 * @author anilkumar This class is same as TestNg SoftAssert class with an additional capability to
 *         take a screenshot when ever a softAssert fails
 */
public class FluentAssert extends Assertion {

	AutoUtilities utils = new AutoUtilities();
    // LinkedHashMap to preserve the order
    private Map<AssertionError, IAssert> m_errors = Maps.newLinkedHashMap();

    @Override
    public void executeAssert(IAssert a) {
        try {
            a.doAssert();
        } catch (AssertionError ex) {
            onAssertFailure(a, ex);
            m_errors.put(ex, a);
            utils.takeScreenShot("Screen@_" + utils.timeStamp());
        }
    }

    public void assertAll() {
        if (!m_errors.isEmpty()) {
            StringBuilder sb = new StringBuilder("The following asserts failed:\n");
            boolean first = true;
            for (Map.Entry<AssertionError, IAssert> ae : m_errors.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(ae.getKey().getMessage());
            }
            throw new AssertionError(sb.toString());
        }
    }

}
