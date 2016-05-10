package ro.ing.automation.runner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.springframework.test.annotation.ProfileValueUtils;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Alexandru Giurovici on 15.06.2015.
 */
public class MultiThreadRunner extends SpringJUnit4ClassRunner
{

    private AtomicInteger numThreads;

    private static final int maxThreads = 8;

    private static final Log logger = LogFactory.getLog(MultiThreadRunner.class);
    private final TestContextManager testContextManager;

    public MultiThreadRunner(Class<?> c) throws InitializationError
    {
        super(c);
        numThreads = new AtomicInteger(0);
        logger.debug("MultiThreadRunner launched for " + c);
        this.testContextManager = this.createTestContextManager(c);
    }

    @Override
    protected void runChild(final FrameworkMethod method, final RunNotifier notifier)
    {
        while (numThreads.get() > maxThreads)
        {
            try
            {
                Thread.sleep(25);
            }
            catch (InterruptedException e)
            {
                logger.error("Interrupted: " + method.getName());
                e.printStackTrace();
                return; // The user may have interrupted us; this won't happen normally
            }
        }
        numThreads.incrementAndGet();
        new Thread (new Test(method, notifier)).start();
    }

    @Override
    protected Statement childrenInvoker(final RunNotifier notifier)
    {
        return new Statement()
        {
            @Override
            public void evaluate() throws Throwable
            {
                MultiThreadRunner.super.childrenInvoker(notifier).evaluate();
                // wait for all child threads (tests) to complete
                while (numThreads.get() > 0)
                {
                    Thread.sleep(25);
                }
            }
        };
    }

    public void run(RunNotifier notifier)
    {
        if(!ProfileValueUtils.isTestEnabledInThisEnvironment(this.getTestClass().getJavaClass()))
        {
            notifier.fireTestIgnored(this.getDescription());
        }
        else
        {
            super.run(notifier);
        }
    }


    class Test implements Runnable
    {
        private final FrameworkMethod method;
        private final RunNotifier notifier;

        public Test (final FrameworkMethod method, final RunNotifier notifier) {
            this.method = method;
            this.notifier = notifier;
        }

        @Override
        public void run () {
            logger.error(method.getName());
            MultiThreadRunner.super.runChild(method, notifier);
            try
            {
                numThreads.decrementAndGet();
            }
            catch (Exception e)
            {
                logger.info("No more threads remaining.");
            }
        }
    }
}