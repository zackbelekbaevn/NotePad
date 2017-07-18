import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;


class Controller implements ActionListener{

    Viewer viewer;
    private String nameOfFile;

    Controller(Viewer viewer) {
        this.viewer = viewer;
        nameOfFile = "";
    }
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        if(command.equals("Open")){
            String text = openFile();
            viewer.setTextToTextArea(text);
        }else if(command.equals("Create")) {
            String text = viewer.getTextToTextArea();
            if(text.equals("Empty")) {
            }else{
                String textNew = createNewDocument(nameOfFile, text);
                viewer.setTextToTextArea(textNew);
            }
        }else if(command.equals("Exit")){
            viewer.doSomething("Exit");
        }else if(command.equals("Cut")){
            viewer.doSomething("Cut");
        }else if(command.equals("Copy")){
            viewer.doSomething("Copy");
        }else if(command.equals("Paste")){
            viewer.doSomething("Paste");
        }else if(command.equals("View Help")){
            openWebPage("https://support.microsoft.com/ru-ru/products/windows");
        }else if(command.equals("About the program")){
            ImageIcon icon = createImageIcon("images/middle.gif");
            JOptionPane.showMessageDialog(new JFrame(),
                    "Eggs are not supposed to be green.",
                    "Inane custom dialog",
                    JOptionPane.INFORMATION_MESSAGE,
                    icon);
        }else if(command.equals("Save")){
            String source = viewer.getTextToTextArea();

            try{
                OutputStream output = new FileOutputStream("smthing.txt");
                for(int i = 0; i < source.length(); i++){
                    int unicode = source.charAt(i);
                    output.write(unicode);
                }
                output.close();
            }catch(FileNotFoundException fne){
            }catch (IOException ioe){

            }
        }
    }

    public String createNewDocument(String fileName, String textValue) {

        String text = "";

        Object[] options = {"Да", "Нет", "Отмена"};
        JFrame f = new JFrame();
        int n = JOptionPane.showOptionDialog(f,
                "Текст в файле " + fileName + " был изменен."
                        + "\nСохранить изменения?",
                "Блокнот",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);

        switch(n) {
            case 0:
                text = openFile();
                break;

            case 1:
                text = "";
                break;

            case -1:
            case 2:
                text = textValue;
                break;

        }

        return text;
    }

    public String openFile() {

        String textFromFile = "";
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(new JFrame());
        File file = fc.getSelectedFile();
        try {
            InputStream f = new FileInputStream(file);
            int symbolByte;


            while((symbolByte = f.read()) != -1) {
                textFromFile = textFromFile + (char)symbolByte;
            }
        }catch(IOException error){
            System.out.println(error);
        }
        nameOfFile = file.toString();
        return textFromFile;
    }
    public void openWebPage(String url){
        try{
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        }catch (java.io.IOException e){
            System.out.println(e.getMessage());
        }
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Controller.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}       