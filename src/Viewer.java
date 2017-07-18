import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Color;



class Viewer {


    private JTextArea textArea;

    Viewer() {
        Controller controller = new Controller(this);
        EmptyBorder eb = new EmptyBorder(0,0,0,0);

        UIManager.put("PopupMenu.border", new LineBorder(Color.LIGHT_GRAY));
        Font font = new Font("", Font.PLAIN, 11);
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("Файл");
        file.setFont(font);
        file.setBorder(eb);

        JMenuItem create = new JMenuItem("Создать",KeyEvent.VK_N);
        create.addActionListener(controller);
        create.setActionCommand("Create");
        KeyStroke ctrlNKeyStroke = KeyStroke.getKeyStroke("control N");
        create.setAccelerator(ctrlNKeyStroke);
        create.setFont(font);
        create.setBorder(eb);

        JMenuItem open = new JMenuItem("Открыть...",KeyEvent.VK_O);
        open.addActionListener(controller);
        open.setActionCommand("Open");
        KeyStroke ctrlOKeyStroke = KeyStroke.getKeyStroke("control O");
        open.setAccelerator(ctrlOKeyStroke);
        open.setFont(font);
        open.setBorder(eb);

        JMenuItem save = new JMenuItem("Сохранить",KeyEvent.VK_S);
        save.addActionListener(controller);
        save.setActionCommand("Save");
        KeyStroke ctrlSKeyStroke = KeyStroke.getKeyStroke("control S");
        save.setAccelerator(ctrlSKeyStroke);
        save.setFont(font);
        save.setBorder(eb);

        JMenuItem saveAs = new JMenuItem("Сохранить как...");
        saveAs.addActionListener(controller);
        saveAs.setActionCommand("SaveAs");
        saveAs.setFont(font);
        saveAs.setBorder(eb);

        JMenuItem pageSettings = new JMenuItem("Параметры страницы");
        pageSettings.addActionListener(controller);
        pageSettings.setActionCommand("pageSettings");
        pageSettings.setFont(font);
        pageSettings.setBorder(eb);

        JMenuItem printing = new JMenuItem("Печать...",KeyEvent.VK_P);
        printing.addActionListener(controller);
        printing.setActionCommand("Printing");
        KeyStroke ctrlPKeyStroke = KeyStroke.getKeyStroke("control P");
        printing.setAccelerator(ctrlPKeyStroke);
        printing.setFont(font);
        printing.setBorder(eb);

        JMenuItem exit = new JMenuItem("Выход");
        exit.addActionListener(controller);
        exit.setActionCommand("Exit");
        exit.setFont(font);
        exit.setBorder(eb);


        JMenu edit = new JMenu("Правка");
        edit.setFont(font);
        edit.setBorder(eb);

        JMenuItem abolish = new JMenuItem("Отменить", KeyEvent.VK_Z);
        abolish.addActionListener(controller);
        abolish.setActionCommand("Abolish");
        KeyStroke ctrlZKeyStroke = KeyStroke.getKeyStroke("control Z");
        abolish.setAccelerator(ctrlZKeyStroke);
        abolish.setFont(font);
        abolish.setBorder(eb);

        JMenuItem cut = new JMenuItem("Вырезать", KeyEvent.VK_X);
        cut.addActionListener(controller);
        cut.setActionCommand("Cut");
        KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke("control X");
        cut.setAccelerator(ctrlXKeyStroke);
        cut.setFont(font);
        cut.setBorder(eb);

        JMenuItem copy = new JMenuItem("Копировать", KeyEvent.VK_C);
        copy.addActionListener(controller);
        copy.setActionCommand("Copy");
        KeyStroke ctrlCKeyStroke = KeyStroke.getKeyStroke("control C");
        copy.setAccelerator(ctrlCKeyStroke);
        copy.setFont(font);
        copy.setBorder(eb);

        JMenuItem insert = new JMenuItem("Вставить", KeyEvent.VK_V);
        insert.addActionListener(controller);
        insert.setActionCommand("Paste");
        KeyStroke ctrlVKeyStroke = KeyStroke.getKeyStroke("control V");
        insert.setAccelerator(ctrlVKeyStroke);
        insert.setFont(font);
        insert.setBorder(eb);

        JMenuItem delete = new JMenuItem("Удалить", KeyEvent.VK_D);
        delete.addActionListener(controller);
        delete.setActionCommand("Delete");
        KeyStroke ctrlDelKeyStroke = KeyStroke.getKeyStroke("D");
        delete.setAccelerator(ctrlDelKeyStroke);
        delete.setFont(font);
        delete.setBorder(eb);

        JMenuItem toFind = new JMenuItem("Найти", KeyEvent.VK_F);
        toFind.addActionListener(controller);
        toFind.setActionCommand("toFind");
        KeyStroke ctrlFKeyStroke = KeyStroke.getKeyStroke("control F");
        toFind.setAccelerator(ctrlFKeyStroke);
        toFind.setFont(font);
        toFind.setBorder(eb);

        JMenuItem findMore = new JMenuItem("Найти далее", KeyEvent.VK_F3);
        findMore.addActionListener(controller);
        findMore.setActionCommand("findMore");
        KeyStroke ctrlF3KeyStroke = KeyStroke.getKeyStroke("F3");
        findMore.setAccelerator(ctrlF3KeyStroke);
        findMore.setFont(font);
        findMore.setBorder(eb);

        JMenuItem replace = new JMenuItem("Заменить", KeyEvent.VK_H);
        replace.addActionListener(controller);
        replace.setActionCommand("replace");
        KeyStroke ctrlHKeyStroke = KeyStroke.getKeyStroke("control H");
        replace.setAccelerator(ctrlHKeyStroke);
        replace.setFont(font);
        replace.setBorder(eb);

        JMenuItem goOver = new JMenuItem("Перейти", KeyEvent.VK_G);
        goOver.addActionListener(controller);
        goOver.setActionCommand("goOver");
        KeyStroke ctrlGKeyStroke = KeyStroke.getKeyStroke("control G");
        goOver.setAccelerator(ctrlGKeyStroke);
        goOver.setFont(font);
        goOver.setBorder(eb);

        JMenuItem selectAll = new JMenuItem("Выделить все", KeyEvent.VK_A);
        selectAll.addActionListener(controller);
        selectAll.setActionCommand("SelectAll");
        KeyStroke ctrlAKeyStroke = KeyStroke.getKeyStroke("control A");
        selectAll.setAccelerator(ctrlAKeyStroke);
        selectAll.setFont(font);
        selectAll.setBorder(eb);

        JMenuItem timeAndDate = new JMenuItem("Время и дата", KeyEvent.VK_F5);
        timeAndDate.addActionListener(controller);
        timeAndDate.setActionCommand("timeAndDate");
        KeyStroke ctrlF5KeyStroke = KeyStroke.getKeyStroke("F5");
        timeAndDate.setAccelerator(ctrlF5KeyStroke);
        timeAndDate.setFont(font);
        timeAndDate.setBorder(eb);

        JMenu format = new JMenu("Формат");
        format.setFont(font);
        format.setBorder(eb);

        JMenuItem wordWrap = new JMenuItem("Перенос по словам");
        wordWrap.addActionListener(controller);
        wordWrap.setActionCommand("wordWrap");
        wordWrap.setFont(font);
        wordWrap.setBorder(eb);

        JMenuItem abolish1 = new JMenuItem("Отменить");
        abolish1.addActionListener(controller);
        abolish1.setActionCommand("Abolish1");
        abolish1.setFont(font);
        abolish1.setBorder(eb);

        JMenuItem font1 = new JMenuItem("Шрифт...");
        font1.addActionListener(controller);
        font1.setActionCommand("font1");
        font1.setFont(font);
        font1.setBorder(eb);


        JMenu view = new JMenu("Вид");
        view.setFont(font);
        view.setBorder(new EmptyBorder(0,0,0,0));
        JMenuItem statusBar  = new JMenuItem("Строка состояния");
        statusBar.addActionListener(controller);
        statusBar.setActionCommand("Status Bar");
        statusBar.setFont(font);
        statusBar.setBorder(eb);


        JMenu help = new JMenu("Справка");
        help.setFont(font);
        help.setBorder(eb);

        JMenuItem viewHelp = new JMenuItem("Просмотреть справку");
        viewHelp.addActionListener(controller);
        viewHelp.setActionCommand("View Help");
        viewHelp.setFont(font);
        viewHelp.setBorder(eb);

        JMenuItem aboutTheProgram = new JMenuItem("О программе");
        aboutTheProgram.addActionListener(controller);
        aboutTheProgram.setActionCommand("About the program");
        aboutTheProgram.setFont(font);
        aboutTheProgram.setBorder(eb);


        menuBar.add(file);
        file.add(create);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.addSeparator();
        file.add(pageSettings);
        file.add(printing);
        file.addSeparator();
        file.add(exit);

        menuBar.add(edit);
        edit.add(abolish);
        edit.addSeparator();
        edit.add(cut);
        edit.add(copy);
        edit.add(insert);
        edit.add(delete);
        edit.addSeparator();
        edit.add(toFind);
        edit.add(findMore);
        edit.add(replace);
        edit.add(goOver);
        edit.addSeparator();
        edit.add(selectAll);
        edit.add(timeAndDate);

        menuBar.add(format);
        format.add(wordWrap);
        format.add(abolish1);
        format.add(font1);

        menuBar.add(view);
        view.add(statusBar);

        menuBar.add(help);
        help.add(viewHelp);
        help.addSeparator();
        help.add(aboutTheProgram);



        //Менеджер компановки(Север/Юг...)
        BorderLayout bl = new BorderLayout();
        //Текстовое поле
        textArea = new JTextArea();
        //Прокрутка
        JScrollPane scroll = new JScrollPane(textArea);

        JFrame frame = new JFrame();
        frame.setTitle("My Notepad");
        frame.setSize(1000, 600);
        frame.setLocation(100, 100);
        frame.setJMenuBar(menuBar);
        frame.setLayout(bl);
        frame.add("Center", scroll);
        frame.setVisible(true);

    }


    public void setTextToTextArea(String text) {
        textArea.setText(text);
    }

    public String getTextToTextArea() {
        if(textArea.getText().equals("")) {
            return "Empty";
        } else {
            return textArea.getText();
        }
    }
    public void doSomething(String action){
        if(action.equals("Cut")){
            textArea.cut();
        }else if(action.equals("Copy")){
            textArea.copy();
        }else if(action.equals("Paste")){
            textArea.paste();
        }else if(action.equals("Exit")){
            System.exit(0);
        }

    }

}