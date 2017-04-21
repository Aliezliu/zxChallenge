package ui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;


public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -17597276056775284L;
	private int width = 500;
	private int height = 500;
	private String title = "������ս��";
	private boolean visible = true;
	private Color backgroundColor = new Color(255,255,255);
	private Color fileInputResultBackgroundColro = new Color(200,200,200);
	
	private JPanel mainPanel = new JPanel();
	private JPanel resultPanel = new JPanel();
	private JPanel checkBoxPanel = new JPanel();
	
	private LayoutManager checkBoxLayout = new GridLayout(5, 1);
	
	private JButton startSolveButton = new JButton("��ʼ���·��");
	private JTextArea fileInputResultText = new JTextArea();
	private JTextArea searchPathResultText = new JTextArea();
	private JFileChooser fileChooser = new JFileChooser();
	
	private JMenuBar menubar = new JMenuBar();
	private JMenu menu = new JMenu("�ļ�");
	private JMenuItem menuItem = new JMenuItem("ѡ��Ҫ���Ե������ļ�");
	
	private File selectedFile = null;
	
	private String shortComsumptionText = "���·��Լ��";
	private String maxPastNodeNumLimitationText = "�����ڵ�����Լ��";
	private String mustPastNodeLimitationText = "���뾭��һЩ�ڵ�Լ��";
	private String mustPastEdgeLimitationText = "���뾭��һЩ��Լ��";
	private String mustNotPastEdgeLimitationText = "���벻����һЩ��Լ��";

	private JCheckBox shortConsumeLimitationCheckBox = new JCheckBox(shortComsumptionText);
	private JCheckBox maxPastNodeNumLimitationCheckBox = new JCheckBox(maxPastNodeNumLimitationText);
	private JCheckBox mustPastNodeLimitationCheckBox = new JCheckBox(mustPastNodeLimitationText);
	private JCheckBox mustPastEdgeLimitationCheckBox = new JCheckBox(mustPastEdgeLimitationText);
	private JCheckBox mustNotPastEdgeLimitationCheckBox = new JCheckBox(mustNotPastEdgeLimitationText);
	
	private ActionListener openFileChooserListener = new OpenFileChooserListener(fileChooser);
	
	private WindowListener mainFrameListener = new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		};
	};
	private void InitMainFrame()
	{
		this.setSize(width,height);
		this.setVisible(visible);
		this.setTitle(title);
		this.setBackground(backgroundColor);
		this.addWindowListener(mainFrameListener);
		this.add(mainPanel);
		InitMainPanel();
		InitMenu();
	}
	
	private void InitCheckBoxPanel()
	{
		shortConsumeLimitationCheckBox.setSelected(true);
		shortConsumeLimitationCheckBox.setEnabled(false);
		checkBoxPanel.add(shortConsumeLimitationCheckBox);
		checkBoxPanel.add(maxPastNodeNumLimitationCheckBox);
		checkBoxPanel.add(mustPastNodeLimitationCheckBox);
		checkBoxPanel.add(mustPastEdgeLimitationCheckBox);
		checkBoxPanel.add(mustNotPastEdgeLimitationCheckBox);
		checkBoxPanel.setLayout(checkBoxLayout);
	}
	private void InitResultPanel()
	{
		resultPanel.setLayout(new GridLayout(3, 1));
		resultPanel.add(startSolveButton);
		resultPanel.add(fileInputResultText);
		fileInputResultText.setEditable(false);
		fileInputResultText.setBackground(fileInputResultBackgroundColro);
		
		resultPanel.add(searchPathResultText);
		searchPathResultText.setEditable(false);
	}
	private void InitMenu()
	{
		this.setJMenuBar(menubar);
		menubar.add(menu);
		menu.add(menuItem);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		menuItem.addActionListener(openFileChooserListener);
	}
	private void InitMainPanel()
	{
		InitCheckBoxPanel();
		InitResultPanel();
		mainPanel.add(checkBoxPanel);
		mainPanel.add(resultPanel);
	}
	public MainFrame() {InitMainFrame();}
	class OpenFileChooserListener implements ActionListener
	{
		private JFileChooser jFileChooser;
		private String labelText = "ѡ���ļ�";
		public OpenFileChooserListener(JFileChooser jFileChooser_){this.jFileChooser = jFileChooser_;}
		@Override
		public void actionPerformed(ActionEvent e) {
			int value = jFileChooser.showDialog(new JLabel(),labelText);
			if(value==JFileChooser.CANCEL_OPTION){return;}
			selectedFile = jFileChooser.getSelectedFile();
//			
//			//���Դ���
//			//System.out.println(selectedFile.getName());
//			FileProcess fp = new FileProcess(selectedFile);
//			ReadFileResultData rfrd = fp.ReadFile();
//			rfrd.printf();
		}
	}
	
	public JTextArea getFileInputResultText() {
		return fileInputResultText;
	}
	public JTextArea getSearchPathResultText() {
		return searchPathResultText;
	}
	public File getSelectedFile() {
		return selectedFile;
	}
}


