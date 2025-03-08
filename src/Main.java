import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import extra.Extra;
import fileMngr.FileMngr;

public class Main extends JFrame {
	
	private JLabel statusLabel;

    public Main() {
        setTitle("HentaiIDE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Extra.sc_getWidth(), Extra.sc_getHeight());
        setLocationRelativeTo(null); 
       
        
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        fileMenu.setMnemonic(KeyEvent.VK_F); // Горячая клавиша Alt+F

        // Пункты меню "Файл"
        JMenuItem newItem = new JMenuItem("Новый", KeyEvent.VK_C);
        JMenuItem openItem = new JMenuItem("Открыть", KeyEvent.VK_O);
        JMenuItem exitItem = new JMenuItem("Выход", KeyEvent.VK_X);

        // Создание меню "Правка"
        JMenu editMenu = new JMenu("Правка");
        editMenu.setMnemonic(KeyEvent.VK_E);

        // Пункты меню "Правка"
        JMenuItem cutItem = new JMenuItem("Вырезать", KeyEvent.VK_T);
        JMenuItem copyItem = new JMenuItem("Копировать", KeyEvent.VK_C);
        JMenuItem pasteItem = new JMenuItem("Вставить", KeyEvent.VK_V);

        // Добавление обработчиков событий
        exitItem.addActionListener(e -> System.exit(0));
        
        newItem.addActionListener(e -> FileMngr.fl_createPrj(this));
        openItem.addActionListener(e -> {FileMngr.fl_openPrj(this);
        							setVisible(false);
        							setVisible(true);
        							});
        cutItem.addActionListener(e -> statusLabel.setText("Выбран: Вырезать"));
        copyItem.addActionListener(e -> statusLabel.setText("Выбран: Копировать"));
        pasteItem.addActionListener(e -> statusLabel.setText("Выбран: Вставить"));

        // Добавление пунктов в меню "Файл"
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator(); // Разделитель
        fileMenu.add(exitItem);

        // Добавление пунктов в меню "Правка"
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Добавление меню в меню-бар
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
        setJMenuBar(menuBar);
        
        JPanel status = new JPanel();
        status.setBackground(Color.gray);
        
        statusLabel = new JLabel("Готов");
        statusLabel.setForeground(Color.black);
        status.add(statusLabel);
        add(status, BorderLayout.SOUTH);
    }
    
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
}