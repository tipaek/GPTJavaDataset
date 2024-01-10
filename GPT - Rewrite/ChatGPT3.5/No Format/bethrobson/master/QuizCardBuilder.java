package chap14;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class QuizCardBuilder {

    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame frame;

    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }

    public void go() {
        frame = new JFrame("Quiz Card Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        question = new JTextArea(6, 20);
        answer = new JTextArea(6, 20);
        JButton nextButton = new JButton("Next Card");
        cardList = new ArrayList<>();
        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");

        setupTextArea(question, bigFont);
        setupTextArea(answer, bigFont);

        setupScrollPane(question);
        setupScrollPane(answer);

        nextButton.addActionListener(new NextCardListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");

        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());

        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        mainPanel.add(qLabel);
        mainPanel.add(question);
        mainPanel.add(aLabel);
        mainPanel.add(answer);
        mainPanel.add(nextButton);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }

    private void setupTextArea(JTextArea textArea, Font font) {
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(font);
    }

    private void setupScrollPane(JTextArea textArea) {
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
        }
    }

    public class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);

            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }

    public class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            cardList.clear();
            clearCard();
        }
    }

    private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    private void saveFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (QuizCard card : cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Couldn't write the cardList out");
            ex.printStackTrace();
        }
    }
}
