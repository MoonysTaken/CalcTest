import org.testng.Assert;
import org.testng.annotations.*;

/** Класс, тестирующий правильность выполнения
 * операции деления.
 * @author Vladimir
 */
public class DivideTest {
    /** Поле для инициализации калькулятора */
    private Calculator calculator = new Calculator();

    /** Создание нового калькулятора */
    @BeforeTest
    public void init(){
        calculator = new Calculator();
    }

    /** Освобождение ресурсов */
    @AfterTest
    public void tearDown(){
        calculator = null;
    }

    /** Метод, выполняющий деление */
    private void action(String dividend, String divider){
        calculator.getPanel().enterDividend(dividend);
        calculator.getPanel().enterDivider(divider);
        calculator.getPanel().clickEquals();
    }
     /** Исходные данные */
    @DataProvider
    public Object[][] divideData(){
        return new Object[][]{
                {"15.5", "5", "3.1"},
                {"15.5", "0", "Ошибка! Деление на 0"},
                {"asd", "21d3", "Ошибка! Неверный ввод"}
        };
    }

    /** Тест (деление положительных чисел, деление на 0, деление нечисловых значений) */
    @Test(dataProvider = "divideData")
    public void divideTest(String dividend, String divider, String expected){
        action(dividend, divider);
        Assert.assertEquals(expected, calculator.getPanel().getResult());
    }

}
