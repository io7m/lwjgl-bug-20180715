```
16:43:19.524 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - testSetup
16:43:19.543 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 0 r 0x0
16:43:19.545 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 0 g 0x0
16:43:19.545 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 0 b 0x0
16:43:19.545 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 0 a 0x0
16:43:19.545 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 0 depth 0.0
16:43:19.545 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 0 stencil 0
16:43:19.580 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 1 r 0x3f800000
16:43:19.580 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 1 g 0x1
16:43:19.580 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 1 b 0x1
16:43:19.580 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 1 a 0x1
16:43:19.580 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 1 depth 1.0
16:43:19.583 [main] DEBUG com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest - 1 stencil 1

org.opentest4j.AssertionFailedError: r-1 ==> 
Expected :1
Actual   :1065353216
 <Click to see difference>


	at org.junit.jupiter.api.AssertionUtils.fail(AssertionUtils.java:54)
	at org.junit.jupiter.api.AssertEquals.failNotEqual(AssertEquals.java:195)
	at org.junit.jupiter.api.AssertEquals.assertEquals(AssertEquals.java:152)
	at org.junit.jupiter.api.Assertions.assertEquals(Assertions.java:324)
	at com.io7m.lwjgl.tests.VulkanLWJGLClearValuesTest.testClearColorValueCreateInfoSigned(VulkanLWJGLClearValuesTest.java:222)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:515)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:115)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$6(TestMethodTestDescriptor.java:170)
	at org.junit.jupiter.engine.execution.ThrowableCollector.execute(ThrowableCollector.java:40)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:166)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:113)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:58)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:134)
	at org.junit.platform.engine.support.hierarchical.SingleTestExecutor.executeSafely(SingleTestExecutor.java:66)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:128)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:109)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.SingleTestExecutor.executeSafely(SingleTestExecutor.java:66)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:128)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:109)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1378)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.SingleTestExecutor.executeSafely(SingleTestExecutor.java:66)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:128)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:109)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:49)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:47)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:184)
	at org.junit.platform.launcher.core.DefaultLauncher.lambda$execute$5(DefaultLauncher.java:152)
	at org.junit.platform.launcher.core.DefaultLauncher.withInterceptedStreams(DefaultLauncher.java:166)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:145)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:92)
	at com.intellij.junit5.JUnit5IdeaTestRunner.startRunnerWithArgs(JUnit5IdeaTestRunner.java:74)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
```
