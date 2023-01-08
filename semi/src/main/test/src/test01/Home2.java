package test01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import test01.Home2.MyPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

// 채팅 목록
public class Home2 extends JFrame implements ActionListener, KeyListener, MouseListener, ListSelectionListener {

	// 선언부
	String imgPath = ".\\src\\images\\";
	ImageIcon imageIcon = new ImageIcon(imgPath + "main.png");
	JFrame jf = new JFrame();

	JPanel jp_north = new JPanel(); // 위쪽 도화지
	JPanel jp_center = new JPanel();// 가운데 도화지
	JPanel jp_south = new JPanel(); // 아래 버튼 도화지

	JLabel jlb_cht = new JLabel();
	JLabel jlb_nick = new JLabel("닉네임");
	JLabel jlb_list = new JLabel("친구목록");
	JLabel jlb_nickname = new JLabel("닉네임(user1)");

	JTextField jtf_msg = new JTextField("상태메세지를 입력하세요"); // 상태메세지

	JButton jbtn_change_msg = new JButton("수정"); // 상태메세지 수정 버튼
	JButton jbtn_add_friend = new JButton("추가"); // 친구추가 버튼
	JButton jbtn_delete_friend = new JButton("x"); // 친구삭제 버튼
	// 아래 버튼
	JButton jbtn_home = new JButton("친구목록"); // 친구목록 버튼
	JButton jbtn_chatroom = new JButton("채팅방");// 채팅방 버튼
	JButton jbtn_setting = new JButton("설정");// 설정 버튼
	JButton jbtn_logout = new JButton("로그아웃");// 로그아웃 버튼

	
	DefaultListModel model=new DefaultListModel(); // JList에 보이는 실제 데이터
	private JScrollPane scrolled;
	JList list = new JList(model);; // 리스트
	JTextField inputField = new JTextField(10); // 테스트 입력 Field
	JButton addBtn = new JButton("추가");; // 추가 버튼
	JButton delBtn = new JButton("삭제"); // 삭제 버튼




	// 생성자
	//Home2() {
		// initDisplay();
	//}

	// 내부클래스로 배경 이미지 처리
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(imageIcon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}// end of MyPanel - 사용자 패널정의 - LoginForm$1.class, LoginForm$MyPanel.class
		// 화면그리기

	public void initDisplay() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new MyPanel());
		this.setLayout(new BorderLayout(50, 20));// 배치

		// 상단 - 닉네임 - 상태메세지
		jp_north.add(jlb_nick);// 닉네임
		jp_north.add(jtf_msg);
		jp_north.add(jbtn_change_msg);
		jlb_nick.setBounds(40, 20, 100, 35);
		jtf_msg.setBounds(100, 20, 200, 35);
		jtf_msg.setToolTipText("수정버튼을 누르면 메세지를 변경하실 수 있습니다");
		jbtn_change_msg.setBounds(280, 20, 60, 35);

		// 하단 -탭
		jp_south.add(jbtn_home);
		jp_south.add(jbtn_chatroom);
		jp_south.add(jbtn_setting);
		jp_south.add(jbtn_logout);

		// 가운데 - 친구목록
		jp_center.add(jlb_list);
		this.add("Center", jp_center);


		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 하나만 선택 될 수 있도록

		inputField.addKeyListener(this); // 엔터 처리
		addBtn.addMouseListener(this); // 아이템 추가
		delBtn.addMouseListener(this); // 아이템 삭제
		list.addListSelectionListener(this); // 항목 선택시

		this.setLayout(new BorderLayout());

		// JPanel topPanel=new JPanel(new FlowLayout(10,10,FlowLayout.LEFT));
		jp_center.add(inputField);
		jp_center.add(addBtn);
		jp_center.add(delBtn); // 위쪽 패널 [textfield] [add] [del]
		jp_center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 상, 좌, 하, 우 공백(Padding)

		scrolled = new JScrollPane(list);
		scrolled.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		jp_center.add(scrolled);
		// this.add(jp_center,"North");

		this.add("North", jp_north);
		this.add("Center", jp_center); // 가운데 list
		this.add("South", jp_south);

		this.setTitle("친구목록");
		this.setLocation(500, 100);
		this.setSize(350, 600);
		this.setVisible(true);
	}

	// 메인메소드
	public static void main(String[] args) {
		Home2 home2 = new Home2();
		home2.initDisplay();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == addBtn) {
			addItem();
		}
		if (e.getSource() == delBtn) {
			int selected = list.getSelectedIndex();
			removeItem(selected);
		}
	}

	public void removeItem(int index) {
		if (index < 0) {
			if (model.size() == 0)
				return; // 아무것도 저장되어 있지 않으면 return
			index = 0; // 그 이상이면 가장 상위 list index
		}

		model.remove(index);
	}

	public void addItem() {
		String inputText = inputField.getText();
		if (inputText == null || inputText.length() == 0)
			return;
		model.addElement(inputText);
		inputField.setText(""); // 내용 지우기
		inputField.requestFocus(); // 다음 입력을 편하게 받기 위해서 TextField에 포커스 요청
		// 가장 마지막으로 list 위치 이동
		scrolled.getVerticalScrollBar().setValue(scrolled.getVerticalScrollBar().getMaximum());
	}

//MouseListener 
	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

//KeyListener
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_ENTER) {
			addItem();
		}
	}

//ListSelectionListener
@Override
public void valueChanged(ListSelectionEvent e) {
	if(!e.getValueIsAdjusting()) {	//이거 없으면 mouse 눌릴때, 뗄때 각각 한번씩 호출되서 총 두번 호출
		System.out.println("selected :"+list.getSelectedValue());
	}
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
