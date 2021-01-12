package org.proiect;

import org.proiect.util.EmptyFieldException;
import org.proiect.util.FileUtility;
import org.proiect.util.NoBookSelectedException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import static org.proiect.BookCategory.*;

public class UserInterface {

    private static  final int BUTTON_WIDTH=200;
    private static  final int LABEL_WIDTH=300;
    private static  final int INPUT_WIDTH=210;
    private static  final int BUTTON_ALIGNMENT=175;
    private static  final int LABEL_ALIGNMENT=20;
    private static  final int INPUT_ALIGNMENT=120;
    private static  final int FIELD_HIGHT=25;
    private static  final int LIST_BUTTONS_ALIGNMENT=340;
    private static  final int ROW1=20;
    private static  final int ROW2=60;
    private static  final int ROW3=100;
    private static  final int ROW4=140;
    private static  final int ROW5=600;

    private static JButton addBookButton;
    private static JButton listBooksButton;
    private static JButton saveButton;
    private static JButton exitButton;
    private static JButton deleteButton;
    private static JButton modifyButton;
    private static JButton backToMenuButton;
    private static JTextField titleInput;
    private static JTextField authorInput;
    private static JTextField pagesInput;
    private static JRadioButton mcRadio;
    private static JRadioButton cRadio;
    private static JRadioButton aaRadio;
    private static JRadioButton ctmRadio;
    private static JRadioButton fRadio;
    private static JRadioButton iRadio;
    private static JRadioButton sfRadio;
    private static JRadioButton rRadio;
    private static JRadioButton yaRadio;
    private static JRadioButton aRadio;
    private static ButtonGroup radioGroup;

    private static JList<String> list;
    private static DefaultListModel<String> bookListModel;
    private static JFrame frame;

    private static List<Book> bookList = new ArrayList<>();

    public static JPanel buildPanel() {
        bookList= FileUtility.readFromFile();

        frame = new JFrame("Biblioteca");
        frame.setSize(580, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        frame.setVisible(true);
        showMenuPage(panel);
        return panel;
    }

    private static void showAddPage(JPanel panel) {

        JLabel titleLabel = new JLabel("Titlu: ");
        titleLabel.setBounds(LABEL_ALIGNMENT,ROW1,LABEL_WIDTH,FIELD_HIGHT);
        panel.add(titleLabel);

        titleInput = new JTextField(20);
        titleInput.setBounds(INPUT_ALIGNMENT,ROW1,INPUT_WIDTH,FIELD_HIGHT);
        panel.add(titleInput);

        JLabel authorLabel = new JLabel("Autor: ");
        authorLabel.setBounds(LABEL_ALIGNMENT,ROW2,LABEL_WIDTH,FIELD_HIGHT);
        panel.add(authorLabel);

        authorInput= new JTextField(20);
        authorInput.setBounds(INPUT_ALIGNMENT,ROW2,INPUT_WIDTH,FIELD_HIGHT);
        panel.add(authorInput);

        JLabel pagesLabel = new JLabel("Pagini: ");
        pagesLabel.setBounds(LABEL_ALIGNMENT,ROW3,LABEL_WIDTH,FIELD_HIGHT);
        panel.add(pagesLabel);

        pagesInput= new JTextField(20);
        pagesInput.setBounds(INPUT_ALIGNMENT,ROW3,INPUT_WIDTH,FIELD_HIGHT);
        panel.add(pagesInput);

        JLabel categoryLabel = new JLabel("Categorie >> Fictiune: ");
        categoryLabel.setBounds(LABEL_ALIGNMENT,ROW4,LABEL_WIDTH,FIELD_HIGHT);
        panel.add(categoryLabel);
        
        radioGroup= new ButtonGroup();

        mcRadio = new JRadioButton();
        mcRadio.setText("Moderni, contemporani");
        mcRadio.setBounds(100,180,200,FIELD_HIGHT);

        cRadio = new JRadioButton();
        cRadio.setText("Clasici");
        cRadio.setBounds(100,220,200,FIELD_HIGHT);

        aaRadio = new JRadioButton();
        aaRadio.setText("Actiune, aventura");
        aaRadio.setBounds(100,260,200,FIELD_HIGHT);

        ctmRadio = new JRadioButton();
        ctmRadio.setText("Crime, thriller, mister");
        ctmRadio.setBounds(100,300,200,FIELD_HIGHT);

        fRadio = new JRadioButton();
        fRadio.setText("Fantasy");
        fRadio.setBounds(100,340,200,FIELD_HIGHT);

        iRadio = new JRadioButton();
        iRadio.setText("Istorica");
        iRadio.setBounds(100,380,200,FIELD_HIGHT);

        sfRadio = new JRadioButton();
        sfRadio.setText("Science fiction");
        sfRadio.setBounds(100,420,200,FIELD_HIGHT);

        rRadio = new JRadioButton();
        rRadio.setText("Romance");
        rRadio.setBounds(100,460,200,FIELD_HIGHT);

        yaRadio = new JRadioButton();
        yaRadio.setText("Young adult");
        yaRadio.setBounds(100,500,200,FIELD_HIGHT);

        aRadio = new JRadioButton();
        aRadio.setText("Altele");
        aRadio.setBounds(100,540,200,FIELD_HIGHT);

        radioGroup.add(mcRadio);
        radioGroup.add(cRadio);
        radioGroup.add(aaRadio);
        radioGroup.add(ctmRadio);
        radioGroup.add(fRadio);
        radioGroup.add(iRadio);
        radioGroup.add(sfRadio);
        radioGroup.add(rRadio);
        radioGroup.add(yaRadio);
        radioGroup.add(aRadio);

        panel.add(mcRadio);
        panel.add(cRadio);
        panel.add(aaRadio);
        panel.add(ctmRadio);
        panel.add(fRadio);
        panel.add(iRadio);
        panel.add(sfRadio);
        panel.add(rRadio);
        panel.add(yaRadio);
        panel.add(aRadio);

        saveButton = new JButton("Save");
        saveButton.setBounds(120,ROW5,100,FIELD_HIGHT);
        saveButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if(titleInput.getText().equals("")||authorInput.getText().equals("")||pagesInput.getText().equals("")||
                                (!mcRadio.isSelected() && !cRadio.isSelected() && !aaRadio.isSelected() && !ctmRadio.isSelected() && !fRadio.isSelected() && !iRadio.isSelected() && !sfRadio.isSelected() && !rRadio.isSelected() && !yaRadio.isSelected() && !aRadio.isSelected())
                        ){
                            JOptionPane.showMessageDialog(panel, "Te rog sa completezi toate campurile!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            throw new EmptyFieldException("Te rog sa completezi toate campurile!");
                        }
                        else{
                        Book book = new Book();
                        book.setTitle(titleInput.getText());
                        book.setAuthor(authorInput.getText());
                        book.setPages(pagesInput.getText());
                        
                        if(mcRadio.isSelected()){
                            book.setCategory(MODERNI_CONTEMPORANI);
                        }
                        if(cRadio.isSelected()){
                            book.setCategory(CLASICI);
                        }
                        if(aaRadio.isSelected()){
                            book.setCategory(ACTIUNE_AVENTURA);
                        }
                        if(ctmRadio.isSelected()){
                            book.setCategory(CRIME_THRILLER_MISTER);
                        }
                        if(fRadio.isSelected()){
                            book.setCategory(FANTASY);
                        }
                        if(iRadio.isSelected()){
                            book.setCategory(ISTORICA);
                        }
                        if(sfRadio.isSelected()){
                            book.setCategory(SCIENCE_FICTION);
                        }
                        if(rRadio.isSelected()){
                            book.setCategory(ROMANCE);
                        }
                        if(yaRadio.isSelected()){
                            book.setCategory(YOUNG_ADULT);
                        }
                        if(aRadio.isSelected()){
                            book.setCategory(ALTELE);
                        }
                        bookList.add(book);
                        clearPanel(panel);
                        showListPage(panel);}
                    }
                }
        );
        panel.add(saveButton);
    }
    private static void showModifyPage(JPanel panel, Book book) {

        JLabel titleLabel = new JLabel("Titlu: ");
        titleLabel.setBounds(LABEL_ALIGNMENT,ROW1,LABEL_WIDTH,FIELD_HIGHT);
        panel.add(titleLabel);

        titleInput = new JTextField(20);
        titleInput.setBounds(INPUT_ALIGNMENT,ROW1,INPUT_WIDTH,FIELD_HIGHT);
        titleInput.setText(book.getTitle());
        panel.add(titleInput);

        JLabel authorLabel = new JLabel("Autor: ");
        authorLabel.setBounds(LABEL_ALIGNMENT,ROW2,LABEL_WIDTH,FIELD_HIGHT);
        panel.add(authorLabel);

        authorInput= new JTextField(20);
        authorInput.setBounds(INPUT_ALIGNMENT,ROW2,INPUT_WIDTH,FIELD_HIGHT);
        authorInput.setText(book.getAuthor());
        panel.add(authorInput);

        JLabel pagesLabel = new JLabel("Pagini: ");
        pagesLabel.setBounds(LABEL_ALIGNMENT,ROW3,LABEL_WIDTH,FIELD_HIGHT);
        panel.add(pagesLabel);

        pagesInput= new JTextField(20);
        pagesInput.setBounds(INPUT_ALIGNMENT,ROW3,INPUT_WIDTH,FIELD_HIGHT);
        pagesInput.setText(book.getPages());
        panel.add(pagesInput);

        JLabel categoryLabel = new JLabel("Categorie >> Fictiune: ");
        categoryLabel.setBounds(LABEL_ALIGNMENT,ROW4,LABEL_WIDTH,FIELD_HIGHT);
        panel.add(categoryLabel);

        radioGroup= new ButtonGroup();

        mcRadio = new JRadioButton();
        mcRadio.setText("Moderni, contemporani");
        mcRadio.setBounds(100,180,200,FIELD_HIGHT);
        if(book.getCategory().equals(MODERNI_CONTEMPORANI))
            mcRadio.setSelected(true);

        cRadio = new JRadioButton();
        cRadio.setText("Clasici");
        cRadio.setBounds(100,220,200,FIELD_HIGHT);
        if(book.getCategory().equals(CLASICI))
            cRadio.setSelected(true);

        aaRadio = new JRadioButton();
        aaRadio.setText("Actiune, aventura");
        aaRadio.setBounds(100,260,200,FIELD_HIGHT);
        if(book.getCategory().equals(ACTIUNE_AVENTURA))
            aaRadio.setSelected(true);

        ctmRadio = new JRadioButton();
        ctmRadio.setText("Crime, thriller, mister");
        ctmRadio.setBounds(100,300,200,FIELD_HIGHT);
        if(book.getCategory().equals(CRIME_THRILLER_MISTER))
            ctmRadio.setSelected(true);

        fRadio = new JRadioButton();
        fRadio.setText("Fantasy");
        fRadio.setBounds(100,340,200,FIELD_HIGHT);
        if(book.getCategory().equals(FANTASY))
            fRadio.setSelected(true);

        iRadio = new JRadioButton();
        iRadio.setText("Istorica");
        iRadio.setBounds(100,380,200,FIELD_HIGHT);
        if(book.getCategory().equals(ISTORICA))
            iRadio.setSelected(true);

        sfRadio = new JRadioButton();
        sfRadio.setText("Science fiction");
        sfRadio.setBounds(100,420,200,FIELD_HIGHT);
        if(book.getCategory().equals(SCIENCE_FICTION))
            sfRadio.setSelected(true);

        rRadio = new JRadioButton();
        rRadio.setText("Romance");
        rRadio.setBounds(100,460,200,FIELD_HIGHT);
        if(book.getCategory().equals(ROMANCE))
            rRadio.setSelected(true);

        yaRadio = new JRadioButton();
        yaRadio.setText("Young adult");
        yaRadio.setBounds(100,500,200,FIELD_HIGHT);
        if(book.getCategory().equals(YOUNG_ADULT))
            yaRadio.setSelected(true);

        aRadio = new JRadioButton();
        aRadio.setText("Altele");
        aRadio.setBounds(100,540,200,FIELD_HIGHT);
        if(book.getCategory().equals(ALTELE))
            aRadio.setSelected(true);

        radioGroup.add(mcRadio);
        radioGroup.add(cRadio);
        radioGroup.add(aaRadio);
        radioGroup.add(ctmRadio);
        radioGroup.add(fRadio);
        radioGroup.add(iRadio);
        radioGroup.add(sfRadio);
        radioGroup.add(rRadio);
        radioGroup.add(yaRadio);
        radioGroup.add(aRadio);

        panel.add(mcRadio);
        panel.add(cRadio);
        panel.add(aaRadio);
        panel.add(ctmRadio);
        panel.add(fRadio);
        panel.add(iRadio);
        panel.add(sfRadio);
        panel.add(rRadio);
        panel.add(yaRadio);
        panel.add(aRadio);

        saveButton = new JButton("Save");
        saveButton.setBounds(120,ROW5,100,FIELD_HIGHT);
        saveButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(titleInput.getText().equals("")||authorInput.getText().equals("")||pagesInput.getText().equals("")||
                                (!mcRadio.isSelected() && !cRadio.isSelected() && !aaRadio.isSelected() && !ctmRadio.isSelected() && !fRadio.isSelected() && !iRadio.isSelected() && !sfRadio.isSelected() && !rRadio.isSelected() && !yaRadio.isSelected() && !aRadio.isSelected())
                        ){
                            JOptionPane.showMessageDialog(panel, "Te rog sa completezi toate campurile!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            throw new EmptyFieldException("Te rog sa completezi toate campurile!");
                        }
                        else{
                        book.setTitle(titleInput.getText());
                        book.setAuthor(authorInput.getText());
                        book.setPages(pagesInput.getText());
                        if(mcRadio.isSelected()){
                            book.setCategory(MODERNI_CONTEMPORANI);
                        }
                        if(cRadio.isSelected()){
                            book.setCategory(CLASICI);
                        }
                        if(aaRadio.isSelected()){
                            book.setCategory(ACTIUNE_AVENTURA);
                        }
                        if(ctmRadio.isSelected()){
                            book.setCategory(CRIME_THRILLER_MISTER);
                        }
                        if(fRadio.isSelected()){
                            book.setCategory(FANTASY);
                        }
                        if(iRadio.isSelected()){
                            book.setCategory(ISTORICA);
                        }
                        if(sfRadio.isSelected()){
                            book.setCategory(SCIENCE_FICTION);
                        }
                        if(rRadio.isSelected()){
                            book.setCategory(ROMANCE);
                        }
                        if(yaRadio.isSelected()){
                            book.setCategory(YOUNG_ADULT);
                        }
                        if(aRadio.isSelected()){
                            book.setCategory(ALTELE);
                        }
                        clearPanel(panel);
                        showListPage(panel);}
                    }
                }
        );
        panel.add(saveButton);
    }
    private static void showMenuPage(JPanel panel) {

        JLabel name = new JLabel("Biblioteca");
        name.setFont(new Font("Verdana", Font.PLAIN, 30));
        name.setBounds(200,ROW1,LABEL_WIDTH,FIELD_HIGHT);
        panel.add(name);

        Icon icon = new ImageIcon("src/main/resources/books.png");
        JLabel label = new JLabel(icon);
        label.setBounds(250,80,50,50);
        panel.add(label);
        panel.updateUI();

        addBookButton=new JButton("Adauga o carte");
        addBookButton.setBounds(BUTTON_ALIGNMENT,160,BUTTON_WIDTH,FIELD_HIGHT);
        addBookButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearPanel(panel);
                        showAddPage(panel);
                    }
                }
        );
        panel.add(addBookButton);

        listBooksButton=new JButton("Afiseaza cartile");
        listBooksButton.setBounds(BUTTON_ALIGNMENT,200,BUTTON_WIDTH,FIELD_HIGHT);
        listBooksButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearPanel(panel);
                        showListPage(panel);
                    }
                }
        );
        panel.add(listBooksButton);

        exitButton=new JButton("Exit");
        exitButton.setBounds(BUTTON_ALIGNMENT,240,BUTTON_WIDTH,FIELD_HIGHT);
        exitButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FileUtility.writeToFile(bookList);
                        frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
                    }
                }
        );
        panel.add(exitButton);
        panel.updateUI();
    }
    private static void showListPage(JPanel panel) {
        bookListModel = new DefaultListModel<>();
        addBooksToJList();

        list = new JList<>(bookListModel);
        list.setBounds(20,ROW1,300,620);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(list);

        list.getSelectedIndex();

        modifyButton = new JButton("Modifica");
        modifyButton.setBounds(LIST_BUTTONS_ALIGNMENT,ROW1,BUTTON_WIDTH,FIELD_HIGHT);
        modifyButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int selectedIndex=list.getSelectedIndex();
                        if(selectedIndex<0){
                            JOptionPane.showMessageDialog(panel, "Te rog sa alegi o carte!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            throw new NoBookSelectedException("Te rog sa alegi o carte!");

                        }else{
                            clearPanel(panel);
                            showModifyPage(panel,bookList.get(selectedIndex));
                        }
                    }
                }
        );
        panel.add(modifyButton);

        deleteButton = new JButton("Sterge");
        deleteButton.setBounds(LIST_BUTTONS_ALIGNMENT,ROW2,BUTTON_WIDTH,FIELD_HIGHT);
        panel.add(deleteButton);
        deleteButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int selectedIndex=list.getSelectedIndex();
                        if(selectedIndex<0){
                            JOptionPane.showMessageDialog(panel, "Te rog sa alegi o carte!",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            throw new NoBookSelectedException("Te rog sa alegi o carte!");

                        }else{
                            bookList.remove(selectedIndex);
                            bookListModel.clear();
                            addBooksToJList();
                        }
                    }
                }
        );

        backToMenuButton = new JButton("Meniu");
        backToMenuButton.setBounds(LIST_BUTTONS_ALIGNMENT,ROW3,BUTTON_WIDTH,FIELD_HIGHT);
        panel.add(backToMenuButton);
        backToMenuButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearPanel(panel);
                        showMenuPage(panel);
                    }
                }
        );
    }
    private static void addBooksToJList() {
        bookList.forEach(book->bookListModel.addElement((bookList.indexOf(book)+1)+". "+book.getTitle()+ " de "+book.getAuthor()));
    }
    private static void clearPanel(JPanel panel) {
        panel.removeAll();
        panel.updateUI();
    }
}
