package test01;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Home extends JDialog implements ActionListener  {
	   boolean isIdCheck = false;
	   String imgPath = ".\\src\\images\\";
	   JDialog jdl_home = new JDialog(); // 홈 프레임
	   Container c = getContentPane();
	   ImageIcon imageIcon = new ImageIcon(imgPath+"main.png");

	   JFrame f = new JFrame();
	   
	   JPanel jp_user = new JPanel(null); // 회원정보
	   JPanel jp_list_friend = new JPanel(null); //친구리스트 
	   JPanel jp_setting = new JPanel(null); //기타 버튼 
	   JPanel jp_all = new JPanel(null); //기타 버튼 
	   

	   JLabel jlb_nick = new JLabel("닉네임");  
	   JLabel jlb_list = new JLabel("친구목록");
	   JLabel jlb_nickname = new JLabel("닉네임(user1)");
	   
	   JTextField jtf_msg = new JTextField("상태메세지를 입력하세요"); // 상태메세지
	   
	   JButton jbtn_change_msg = new JButton("수정"); // 상태메세지 수정 버튼
	   JButton jbtn_add_friend = new JButton("추가"); // 친구추가 버튼
	   JButton jbtn_delete_friend = new JButton("x"); // 친구삭제 버튼
	   //아래 버튼
	   JButton jbtn_home = new JButton("친구목록"); // 친구목록 버튼
	   JButton jbtn_chatroom = new JButton("채팅방");// 채팅방 버튼
	   JButton jbtn_setting = new JButton("설정");// 설정 버튼
	   JButton jbtn_logout = new JButton("로그아웃");// 로그아웃 버튼

	   public void initDisplay() {
		   class MyPanel extends JPanel{
				public void paintComponent(Graphics g){
					g.drawImage(imageIcon.getImage(), 0, 0, null);
					setOpaque(true);
					super.paintComponent(g);
				}
			}
		   //버튼 엑션 리스너
		   MyPanel mp = new MyPanel();
		   jbtn_change_msg.addActionListener(this);
		   jbtn_add_friend.addActionListener(this);
		   jbtn_delete_friend.addActionListener(this);
		   jbtn_home.addActionListener(this);
		   jbtn_chatroom.addActionListener(this);
		   jbtn_setting.addActionListener(this);
		   jbtn_logout.addActionListener(this);
	      // 타이틀
	      ImageIcon bookIcon = new ImageIcon(imgPath+"title.png");
	      jdl_home.setIconImage(bookIcon.getImage());
	      jdl_home.setTitle("양파쿵야 톡 홈");
	      // 정보입력 부분
	      
	      jp_user.add(jlb_nick);// 닉네임
	      jp_user.add(jtf_msg);
	      jp_user.add(jbtn_change_msg);
	      jlb_nick.setBounds(40, 20, 100, 35);
	      jtf_msg.setBounds(100, 20, 180, 35);
	      jtf_msg.setToolTipText("수정버튼을 누르면 메세지를 변경하실 수 있습니다");
	      jbtn_change_msg.setBounds(280, 20, 60, 35);

	      jp_user.add(jlb_list);
	      jlb_list.setBounds(40, 70, 100, 35);
	      jp_user.add(jbtn_add_friend);
	      jbtn_add_friend.setBounds(280, 70, 60, 35);
	      jp_user.add(jlb_nickname);
	      jlb_nickname.setBounds(50, 120, 100, 35);
	      jp_user.add(jbtn_delete_friend);
	      jbtn_delete_friend.setBounds(150, 130, 20, 20);
	      

	      //f.add(jp_user, BorderLayout.NORTH);
	      //f.add(jp_list_friend, BorderLayout.CENTER);
	      /*
	      jp_list_friend.add(jlb_list);
	      jp_list_friend.add(jbtn_add_friend);

	      jp_all.add(jp_user);
	      jp_all.add(jp_list_friend);
*/	      
//	      jlb_id.setFont(f_label);
//	      jp_join.add(jlb_idAvble);// 아이디 중복검사 결과
//	      jlb_idAvble.setVisible(false);
//	      jp_join.add(jlb_idNotAvble);
//	      jlb_idAvble.setBounds(95, 180, 180, 35);
//	      jlb_idNotAvble.setBounds(95, 180, 200, 35);
//	      jlb_idNotAvble.setVisible(false);
//	      jp_join.add(jtf_pw);// 비밀번호
//	      jp_join.add(jlb_pw);
//	      jtf_pw.setBounds(95, 210, 180, 35);
//	      jlb_pw.setBounds(35, 210, 200, 35);
//	      jlb_pw.setFont(f_label);
//	      jp_join.add(jtf_pw2);// 비밀번호확인
//	      jp_join.add(jlb_pw2);
//	      jtf_pw2.setBounds(95, 255, 180, 35);
//	      jlb_pw2.setBounds(10, 255, 200, 35);
//	      jlb_pw2.setFont(f_label);
//	      jp_join.add(jtf_birth);// 생년월일
//	      jp_join.add(jlb_birth);
//	      jtf_birth.setBounds(95, 300, 180, 35);
//	      jlb_birth.setBounds(35, 300, 200, 35);
//	      jlb_birth.setFont(f_label);
//	      jp_join.add(jtf_phone);// 전화번호
//	      jp_join.add(jlb_phone);
//	      jtf_phone.setBounds(95, 345, 180, 35);
//	      jlb_phone.setBounds(35, 345, 200, 35);
//	      jlb_phone.setFont(f_label);
//	      jp_join.add(jtf_nickName);// 닉네임
//	      jp_join.add(jlb_nickName);
//	      jtf_nickName.setBounds(95, 390, 180, 35);
//	      jlb_nickName.setBounds(45, 390, 200, 35);
//
//	      jbtn_idconfirm.setBorderPainted(false); // 아이디 중복검사 버튼 외곽 라인 없애기
//	      jbtn_idconfirm.setForeground(Color.WHITE); // 아이디 중복검사 버튼 텍스트 색깔 (흰색)
//	      jbtn_idconfirm.setBackground(new Color(0, 64, 0)); // 아이디 중복검사 버튼 색깔 넣기 (갈색)
//	      jbtn_idconfirm.setBounds(285, 145, 90, 35);
//	      jbtn_join.setBounds(42, 450, 300, 45);
//	      jlb_title.setFont(f_join);// 회원가입 라벨 붙이기
//	      jlb_title.setBounds(20, 30, 125, 45);
//	      jp_join.add(jlb_title);// 회원가입 라벨 왼쪽 상단에 붙이기
//	      jp_join.add(jbtn_join);// 회원가입 버튼
//	      jp_join.add(jbtn_idconfirm);// 아이디 중복검사 버튼
//	      jp_join.setBackground(new Color(146, 208, 80)); // 도화지 색깔 노란색
	      //jp_user.setBackground(new Color(0, 50, 90));
	      // JDialog, 회원가입 메인창 정의
	      
	      jdl_home.setTitle("양파쿵야 톡 홈");
	      jdl_home.setContentPane(jp_user);
	      //jdl_home.setContentPane(jp_list_friend);

	      jdl_home.setSize(400, 600);
	      jdl_home.setLocationRelativeTo(null);// 창 가운데서 띄우기
	      jdl_home.setVisible(true);
	   }

	   // 단위테스트욤
	   public static void main(String[] args) {
	      Home home = new Home();
	      home.initDisplay();
	   }

	   @Override
	   public void actionPerformed(ActionEvent e) {
	      // TODO Auto-generated method stub

	   }
}