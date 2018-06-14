import javax.swing.*;

/** Класс непосредственно фрейма калькулятора
 * @author Vladimir
 */
public class Calculator {
    /** Фрейм с содержимым */
    private JFrame window;

    /** Панель */
    private Panel panel;

    /** Конструктор, инициализирующий панель с инструментами,
     * фрейм, и задающий его параметры(размер, местоположение,
     * изменяемость размера, видимость, действие для кнопки
     * закрытия) и добавляющий объект панели во фрейм.
     * @see Panel#Panel()
     * */
    public Calculator(){
        panel = new Panel();
        window = new JFrame("Calculator");
        window.setSize(280, 350);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.add(panel);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    /** Метод, возвращающий текущую панель. */
    public Panel getPanel(){
        return panel;
    }


    /** Создание нового калькулятора. */
    public static void main(String[] args) {
              new Calculator();
    }
}
