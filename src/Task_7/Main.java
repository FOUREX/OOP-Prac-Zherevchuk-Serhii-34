package Task_7;

import Task_6.ResultsHistory;
import Task_7.Observers.Serialization;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Клас реалізуючий логіку візуального інтерфейсу
 */
public class Main extends JFrame {
    private static final ResultsHistory resultsHistory = ResultsHistory.getInstance();
    ObservableViewTable view = new ObservableViewTable();

    private JPanel MainPanel;
    private JSpinner ResultsCount;
    private JSpinner ResultsStart;
    private JButton GenerateButton;
    private JButton GenerateRandomButton;
    private JTable ResultsTable;
    private JButton UndoButton;
    private JButton DeserializeButton;
    private JButton SerializeButton;

    /** Точка входу */
    public static void main(String[] args) {
        new Main();
    }

    /** Конструктор класу */
    public Main() {
        setContentPane(MainPanel);
        setVisible(true);
        setSize(400, 600);

        createTable();

        GenerateButton.addActionListener(new GenerateButtonListener());
        GenerateRandomButton.addActionListener(new GenerateRandomButtonListener());
        UndoButton.addActionListener(new UndoButtonListener());
        SerializeButton.addActionListener(new SerializeButtonListener());
        DeserializeButton.addActionListener(new DeserializeButtonListener());

        view.register(new Serialization());
        view.register(new Task_7.Observers.Init());
        view.register(new Task_7.Observers.Undo());
    }

    /** Обробка натиснень на кнопку "Генерація" */
    class GenerateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultsHistory.add(view.getResults());

            view.init((Integer) ResultsCount.getValue(), (Integer) ResultsStart.getValue());
            view.calculate();

            updateTable();
        }
    }

    /** Обробка натиснень на кнопку "Випадкова генерація" */
    class GenerateRandomButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultsHistory.add(view.getResults());

            view.init((Integer) ResultsCount.getValue());
            view.calculate();

            updateTable();
        }
    }

    /** Обробка натиснень на кнопку "Скасувати" */
    class UndoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultsHistory.undo(view);

            updateTable();
        }
    }

    /** Обробка натиснень на кнопку "Серіалізувати" */
    class SerializeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                view.save("temp/Task_7/results.bin");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            updateTable();
        }
    }

    /** Обробка натиснень на кнопку "Десеріалізувати" */
    class DeserializeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                view.restore("temp/Task_7/results.bin");
                view.calculate();
            } catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }

            updateTable();
        }
    }

    /** Створює пусту таблицю при запуску програми */
    private void createTable() {
        ResultsTable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Довжина сторони", "Сума"}
        ));
    }

    /** Оновлює дані в таблиці */
    private void updateTable() {
        Object[][] data = new Object[view.getResults().size()][2];

        for (int i = 0; i < view.getResults().size(); i++) {
            data[i][0] = view.getResults().get(i).getLength();
            data[i][1] = view.getResults().get(i).getResult();
        }

        ResultsTable.setModel(new DefaultTableModel(
            data,
            new String[]{"Довжина сторони", "Сума"}
        ));
    }
}
