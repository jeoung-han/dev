package mian;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import template.ImgPanel;
import template.invisiableButton;
import template.invisiabletestField;

public class JejudoJoah {

	private JFrame frame;
	private JTextField idTextField;
	private JPasswordField passwordField;

	/*** Launch the application.*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JejudoJoah window = new JejudoJoah();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*** Create the application.*/
	public JejudoJoah() {
		initialize();
	}

	/*** Initialize the contents of the frame.*/
	private void initialize() {
		frame = new JFrame("JEJUDO JOAH");
		ImgPanel mainPage = new ImgPanel(new ImageIcon("D:\\dev\\mydev\\javaWorkspace\\GUI\\img\\mainPage.jpg").getImage());
		ImgPanel subPage = new ImgPanel(new ImageIcon("D:\\dev\\mydev\\javaWorkspace\\GUI\\img\\subPage.jpg").getImage());
		ImgPanel joinPage = new ImgPanel(new ImageIcon("D:\\dev\\mydev\\javaWorkspace\\GUI\\img\\joinPage.jpg").getImage());
		ImgPanel menuPage = new ImgPanel(new ImageIcon("D:\\dev\\mydev\\javaWorkspace\\GUI\\img\\menuPage.jpg").getImage());
		
		/**메뉴 페이지*/
		frame.getContentPane().add(menuPage);
		menuPage.setVisible(false);
		
		JButton menuBtn1 = new invisiableButton("내정보수정");
		menuBtn1.setBounds(137, 165, 222, 33);
		menuPage.add(menuBtn1);
		
		JButton menuBtn2 = new invisiableButton("포인트확인");
		menuBtn2.setBounds(137, 205, 222, 33);
		menuPage.add(menuBtn2);
		
		JButton menuBtn3 = new invisiableButton("내예약확인");
		menuBtn3.setBounds(137, 245, 222, 33);
		menuPage.add(menuBtn3);
		
		JButton menuBtn4 = new invisiableButton("문의내역확인");
		menuBtn4.setBounds(137, 285, 222, 33);
		menuPage.add(menuBtn4);
		
		JButton menuBtn5 = new invisiableButton("여행예약");
		menuBtn5.setBounds(137, 400, 222, 33);
		menuPage.add(menuBtn5);
		
		JButton menuBtn6 = new invisiableButton("예약변경");
		menuBtn6.setBounds(137, 440, 222, 33);
		menuPage.add(menuBtn6);
		
		JButton menuBtn7 = new invisiableButton("예약취소");
		menuBtn7.setBounds(137, 480, 222, 33);
		menuPage.add(menuBtn7);
		
		JButton menuBtn8 = new invisiableButton("관광지");
		menuBtn8.setBounds(137, 585, 222, 33);
		menuPage.add(menuBtn8);
		
		JButton menuBtn9 = new invisiableButton("맛집");
		menuBtn9.setBounds(137, 625, 222, 33);
		menuPage.add(menuBtn9);
		
		JButton menuBtn10 = new invisiableButton("카페");
		menuBtn10.setBounds(137, 665, 222, 33);
		menuPage.add(menuBtn10);
		
		JButton menuBtn11 = new invisiableButton("문의");
		menuBtn11.setBounds(137, 770, 222, 33);
		menuPage.add(menuBtn11);
		
		JButton menuBtn12 = new invisiableButton("질문");
		menuBtn12.setBounds(137, 810, 222, 33);
		menuPage.add(menuBtn12);
		
		JButton menuBackBtn = new invisiableButton();
		menuBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 뒤로가기
				subPage.setVisible(true);
				menuPage.setVisible(false);
			}
		});
		menuBackBtn.setBounds(12, 10, 61, 57);
		menuPage.add(menuBackBtn);
		
		
		/**회원가입 페이지*/
		frame.getContentPane().add(joinPage);
		joinPage.setVisible(false);
		
		JTextField nameTF = new invisiabletestField(new LineBorder(new Color(144,168,94), 2, true));
		nameTF.setBounds(174, 136, 353, 41);
		nameTF.setColumns(10);
		joinPage.add(nameTF);
		
		JTextField textField_1 = new invisiabletestField(new LineBorder(new Color(144,168,94), 2, true));
		textField_1.setBounds(174, 221, 353, 41);
		textField_1.setColumns(10);
		joinPage.add(textField_1);
		
		JTextField idTF = new invisiabletestField(new LineBorder(new Color(144,168,94), 2, true));
		idTF.setBounds(174, 336, 353, 41);
		idTF.setColumns(10);
		joinPage.add(idTF);
		
		JTextField nickTF = new invisiabletestField(new LineBorder(new Color(144,168,94), 2, true));
		nickTF.setBounds(174, 508, 353, 41);
		nickTF.setColumns(10);
		joinPage.add(nickTF);
		
		JTextField phoneTF = new invisiabletestField(new LineBorder(new Color(144,168,94), 2, true));
		phoneTF.setBounds(174, 622, 353, 41);
		phoneTF.setColumns(10);
		joinPage.add(phoneTF);
		
		JTextField emailTF = new invisiabletestField(new LineBorder(new Color(144,168,94), 2, true));
		emailTF.setBounds(174, 707, 353, 41);
		emailTF.setColumns(10);
		joinPage.add(emailTF);
						
		JPasswordField joinPasswordField = new JPasswordField();
		joinPasswordField.setFont(new Font("굴림", Font.PLAIN, 15));
		joinPasswordField.setBounds(174, 422, 353, 41);
		joinPasswordField.setBorder(new LineBorder(new Color(144,168,94), 2, true));
		joinPasswordField.setOpaque(false); 
		joinPage.add(joinPasswordField);
		
		JButton joinBtn = new invisiableButton("nextBtn");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 회원가입
			}
		});
		joinBtn.setBounds(0, 822, 550, 78);
		joinPage.add(joinBtn);
		
		JButton checkedIdBtn = new invisiableButton("idCheckBtn");
		checkedIdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 아이디 중복 확인
			}
		});
		checkedIdBtn.setBounds(470, 294, 57, 32);
		joinPage.add(checkedIdBtn);
		
		JButton joinBackBtn = new invisiableButton();
		joinBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 뒤로가기
				mainPage.setVisible(true);
				joinPage.setVisible(false);
			}
		});
		joinBackBtn.setBounds(12, 10, 61, 57);
		joinPage.add(joinBackBtn);
		
		/**서브 페이지*/
		frame.getContentPane().add(subPage);
		subPage.setVisible(false);
		
		JButton reservBtn = new invisiableButton("예약Btn");
		reservBtn.setBounds(15, 258, 521, 104);
		subPage.add(reservBtn);
		
		JButton inforBtn = new invisiableButton("정보Btn");
		inforBtn.setBounds(15, 384, 521, 104);
		subPage.add(inforBtn);
		
		JButton toggleBtn = new invisiableButton("toggle");
		toggleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 메뉴이동
				menuPage.setVisible(true);
				subPage.setVisible(false);
			}
		});
		toggleBtn.setBounds(480, 14, 44, 45);
		subPage.add(toggleBtn);
				
		
		/**메인 페이지*/
		frame.getContentPane().add(mainPage);
		mainPage.setVisible(true);
		
		idTextField = new invisiabletestField("아이디를 입력하세요");
		idTextField.setFocusTraversalKeysEnabled(false);
		idTextField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_TAB) {
					passwordField.requestFocus();
					passwordField.setText(null);
				}
			}
		});
		idTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idTextField.setText(null);
			}
		});
		idTextField.setBounds(193, 353, 253, 42);
		idTextField.setColumns(10);
		mainPage.add(idTextField);
		
		passwordField = new JPasswordField("0000");
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setText(null);
			}
		});
		passwordField.setFont(new Font("굴림", Font.PLAIN, 15));
		passwordField.setBounds(193, 408, 253, 42);
		passwordField.setOpaque(false);
		passwordField.setBorder(null);
		mainPage.add(passwordField);
		
		JButton loginBtn = new invisiableButton("loginBt");
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 로그인 버튼 작동 이벤트
				mainPage.setVisible(false);
				subPage.setVisible(true);
			}
		});
		loginBtn.setBounds(220, 470, 97, 23);
		mainPage.add(loginBtn);
		
		JButton gotoJoinBtn = new invisiableButton();
		gotoJoinBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(false);
				joinPage.setVisible(true);
			}
		});
		gotoJoinBtn.setBounds(124, 530, 77, 23);
		mainPage.add(gotoJoinBtn);
		
		JButton findIdBtn = new invisiableButton();
		findIdBtn.setBounds(213, 530, 89, 23);
		mainPage.add(findIdBtn);
		
		JButton findPassBtn = new invisiableButton();
		findPassBtn.setBounds(321, 530, 97, 23);
		mainPage.add(findPassBtn);
		
		//사이즈 설정
		frame.pack();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
