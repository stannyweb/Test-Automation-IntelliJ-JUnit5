package listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listener implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("The test was disabled: " + context.getTestMethod() + reason);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("The test was successful: " + context.getTestMethod());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("The test was aborted: " + cause.getMessage());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("The test failed: " + cause.getMessage());
    }
}
