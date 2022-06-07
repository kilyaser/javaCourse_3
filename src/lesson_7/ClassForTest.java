package lesson_7;

public class ClassForTest {

    @BeforeSuite
    public void bforeTest() {
        System.out.println("methodBefore");
    }
    @AfterSuite
    public void afterTest() {
        System.out.println("methodAfter");
    }
    @Test(priority = 3)
    public void Test1() {
        System.out.println("Test1 priority 3");
    }
    @Test
    public void Test2() {
        System.out.println("Test1 priority default");
    }
}
