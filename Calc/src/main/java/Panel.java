import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс панели с инструментами для проведения операции деления
 * @author Vladimir
 */
public class Panel extends JPanel {
    /** Кнопка получения результата */
    private JButton equalsButton = new JButton("=");

    /** Кнопка очистки полей */
    private JButton clearButton = new JButton("Clear");

    /** Ярлык операции деления */
    private JLabel divLabel = new JLabel("/");

    /** Текстовое поле для ввода делимого */
    private JTextField textField1 = new JTextField();

    /** Текстовое поле для ввода делителя */
    private JTextField textField2 = new JTextField();

    /** Текстовое поле для вывода результата */
    private JTextField textField3 = new JTextField();

    /** Шрифт */
    private Font font = new Font("SanSerif", Font.BOLD, 13);

    /** Метод клика по кнопке получения результата */
    public void clickEquals(){
        equalsButton.doClick();
    }

    /** Метод для ввода делимого */
    public void enterDividend(String text){
        textField1.setText(text);
    }

    /** Метод для ввода делителя */
    public void enterDivider(String text){
        textField2.setText(text);
    }

    /** Метод, возвращающий результат из текстового поля*/
    public String getResult(){
       return textField3.getText();
    }

    /** Конструктор для создания панели, который задает параметры и размеры
     * текстовых полей и кнопок. Здесь же они добавляются в панель.
     * Создается 2 ActionListner'a. Один задает действие для кнопки
     * Clear (очищение текстовых полей). Другой - для кнопки получения
     * результата. При делении на 0, и при вводе данных, не являющихся числами,
     * в текстовое поле результата выводится сообщение об ошибке.
     * Оба лиснера добавляются в соответствующие кнопки.
     * */
        Panel(){
            setLayout(null);
            textField1.setBounds(10, 10, 100, 30);
            textField2.setBounds(170, 10, 100, 30);
            textField3.setBounds(45, 100, 180, 30);
            divLabel.setBounds(140, 15, 20, 20);
            equalsButton.setBounds(110, 140, 50, 40);
            clearButton.setBounds(100, 190, 70, 40);
            textField3.setEditable(false);
            divLabel.setFont(font);
            textField1.setFont(font);
            textField2.setFont(font);
            textField3.setFont(font);
            equalsButton.setFont(font);
            add(equalsButton);
            add(textField1);
            add(textField2);
            add(textField3);
            add(divLabel);
            add(clearButton);

            ActionListener clearListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
            }
        };

            ActionListener equalsListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        double d1 = Double.parseDouble(textField1.getText());
                        double d2 = Double.parseDouble(textField2.getText());
                        if (d2 == 0) {
                            textField3.setText("Ошибка! Деление на 0");
                            return;
                    }
                        double res = d1 / d2;
                        textField3.setText(String.valueOf(res));
                    }
                    catch (NumberFormatException ex2){
                        textField3.setText("Ошибка! Неверный ввод");
                    }

                }
            };
            clearButton.addActionListener(clearListener);
            equalsButton.addActionListener(equalsListener);
    }
}
