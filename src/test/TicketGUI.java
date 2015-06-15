package test;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton) e.getSource(); // 왜 필요한가 ?

	}

}

public class TicketGUI extends JFrame {

	ArrayList<Ticket> list = new ArrayList<Ticket>();

	String id;

	TicketGUI(String id) {

		this.id = id;

		load();
		Date today = new Date();
		SimpleDateFormat SD = new SimpleDateFormat("yyyy/MM/dd   kk:mm");

		Container contentPane;
		contentPane = getContentPane();

		setTitle("Final Exam!!");

		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("Option");
		JMenuItem mi = new JMenuItem("Exit");
		mb.add(m);
		m.add(mi);
		setJMenuBar(mb);

		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		setLayout(new FlowLayout(FlowLayout.LEFT, 15, 40));

		ImageIcon im1 = new ImageIcon("korail.jpg");
		JLabel jl8 = new JLabel(im1);

		JLabel blank1 = new JLabel(
				"                              Current time is");
		JLabel blank2 = new JLabel("                       ");
		JLabel blank3 = new JLabel(
				"                                                     ");
		JLabel date = new JLabel(SD.format(today));

		JLabel jl1 = new JLabel("     출발역     ");
		JLabel jl2 = new JLabel("     도착역     ");
		jl1.setFont(new Font("Serif", Font.BOLD, 18));
		jl2.setFont(new Font("Serif", Font.BOLD, 18));
		JLabel jl3 = new JLabel("년");
		JLabel jl4 = new JLabel("월");
		JLabel jl5 = new JLabel("일");
		JLabel jl6 = new JLabel("시 출발");
		jl3.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
		jl4.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
		jl5.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
		jl6.setFont(new Font("Serif", Font.TYPE1_FONT, 18));
		JLabel jl7 = new JLabel("인원");
		jl7.setFont(new Font("Serif", Font.BOLD, 18));

		jl1.setForeground(Color.BLUE);
		jl1.setBackground(Color.WHITE);
		jl1.setOpaque(true);

		jl2.setForeground(Color.BLUE);
		jl2.setBackground(Color.WHITE);
		jl2.setOpaque(true);

		final JTextField tf1 = new JTextField(12);
		final JTextField tf2 = new JTextField(12);

		final JTextField tf3 = new JTextField(8);

		JButton jb = new JButton("완료");
		jb.setBackground(Color.WHITE);
		jb.setFont(new Font("Serif", Font.BOLD, 20));

		String[] year = { "2015", "2016" };
		ImageIcon[] images1 = { new ImageIcon("../images/2015.jpg"),
				new ImageIcon("../images/2016.jpg") };
		JLabel imgLabel1 = new JLabel(images1[0]);

		JComboBox strCombo1 = new JComboBox(year);

		strCombo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb1 = (JComboBox) e.getSource();
				int index1 = cb1.getSelectedIndex();
				imgLabel1.setIcon(images1[index1]);
				// 눌렀을 때 번호 출력
				// String choice_year = year[index1];

			}
		});

		String[] month = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12" };
		ImageIcon[] images2 = { new ImageIcon("../images/1.jpg"),
				new ImageIcon("../images/2.jpg"),
				new ImageIcon("../images/3.jpg"),
				new ImageIcon("../images/4.jpg"),
				new ImageIcon("../images/5.jpg"),
				new ImageIcon("../images/6.jpg"),
				new ImageIcon("../images/7.jpg"),
				new ImageIcon("../images/8.jpg"),
				new ImageIcon("../images/9.jpg"),
				new ImageIcon("../images/10.jpg"),
				new ImageIcon("../images/11.jpg"),
				new ImageIcon("../images/12.jpg") };

		JLabel imgLabel2 = new JLabel(images2[0]);

		JComboBox strCombo2 = new JComboBox(month);

		strCombo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb2 = (JComboBox) e.getSource();
				int index2 = cb2.getSelectedIndex();
				imgLabel2.setIcon(images2[index2]);
				// 눌렀을 때 번호 출력
				// String choice_month = month[index2];

			}
		});

		String[] day = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" };
		ImageIcon[] images3 = { new ImageIcon("../images/1.jpg"),
				new ImageIcon("../images/2.jpg"),
				new ImageIcon("../images/3.jpg"),
				new ImageIcon("../images/4.jpg"),
				new ImageIcon("../images/5.jpg"),
				new ImageIcon("../images/6.jpg"),
				new ImageIcon("../images/7.jpg"),
				new ImageIcon("../images/8.jpg"),
				new ImageIcon("../images/9.jpg"),
				new ImageIcon("../images/10.jpg"),
				new ImageIcon("../images/11.jpg"),
				new ImageIcon("../images/12.jpg"),
				new ImageIcon("../images/13.jpg"),
				new ImageIcon("../images/14.jpg"),
				new ImageIcon("../images/15.jpg"),
				new ImageIcon("../images/16.jpg"),
				new ImageIcon("../images/17.jpg"),
				new ImageIcon("../images/18.jpg"),
				new ImageIcon("../images/19.jpg"),
				new ImageIcon("../images/20.jpg"),
				new ImageIcon("../images/21.jpg"),
				new ImageIcon("../images/22.jpg"),
				new ImageIcon("../images/23.jpg"),
				new ImageIcon("../images/24.jpg"),
				new ImageIcon("../images/25.jpg"),
				new ImageIcon("../images/26.jpg"),
				new ImageIcon("../images/27.jpg"),
				new ImageIcon("../images/28.jpg"),
				new ImageIcon("../images/29.jpg"),
				new ImageIcon("../images/30.jpg"),
				new ImageIcon("../images/31.jpg") };

		JLabel imgLabel3 = new JLabel(images3[0]);

		JComboBox strCombo3 = new JComboBox(day);

		strCombo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb3 = (JComboBox) e.getSource();
				int index3 = cb3.getSelectedIndex();
				imgLabel3.setIcon(images3[index3]);
				// 눌렀을 때 번호 출력
				// String choice_day = day[index3];

			}
		});

		String[] time = { "6", "7", "8", "9", "10", "11", "12", "13", "14",
				"15", "16", "17", "18", "19", "20", "21", "22", "23" };

		ImageIcon[] images4 = { new ImageIcon("../images/1.jpg"),
				new ImageIcon("../images/2.jpg"),
				new ImageIcon("../images/3.jpg"),
				new ImageIcon("../images/4.jpg"),
				new ImageIcon("../images/5.jpg"),
				new ImageIcon("../images/6.jpg"),
				new ImageIcon("../images/7.jpg"),
				new ImageIcon("../images/8.jpg"),
				new ImageIcon("../images/9.jpg"),
				new ImageIcon("../images/10.jpg"),
				new ImageIcon("../images/11.jpg"),
				new ImageIcon("../images/12.jpg"),
				new ImageIcon("../images/13.jpg"),
				new ImageIcon("../images/14.jpg"),
				new ImageIcon("../images/15.jpg"),
				new ImageIcon("../images/16.jpg"),
				new ImageIcon("../images/17.jpg"),
				new ImageIcon("../images/18.jpg"),
				new ImageIcon("../images/19.jpg"),
				new ImageIcon("../images/20.jpg"),
				new ImageIcon("../images/21.jpg"),
				new ImageIcon("../images/22.jpg"),
				new ImageIcon("../images/23.jpg") };

		JLabel imgLabel4 = new JLabel(images4[0]);

		JComboBox strCombo4 = new JComboBox(time);

		strCombo4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb4 = (JComboBox) e.getSource();
				int index4 = cb4.getSelectedIndex();
				imgLabel4.setIcon(images4[index4]);
				// 눌렀을 때 번호 출력
				// String choice_time = time[index4];

			}
		});

		add(jl1);
		add(tf1);

		add(blank1);

		add(jl2);
		add(tf2);

		add(blank2);
		add(date);

		contentPane.add(strCombo1);
		contentPane.add(imgLabel1);
		add(jl3);

		contentPane.add(strCombo2);
		contentPane.add(imgLabel2);
		add(jl4);

		contentPane.add(strCombo3);
		contentPane.add(imgLabel3);
		add(jl5);

		contentPane.add(strCombo4);
		contentPane.add(imgLabel4);
		add(jl6);

		add(jl7);
		add(tf3);

		add(blank3);

		add(jb);

		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 여기에 버튼눌렀을때의 반응을 추가하면됨
				try {
					
					list.add(new Ticket(id, tf1.getText(), tf2.getText(),
							(String) strCombo1.getSelectedItem(),
							(String) strCombo2.getSelectedItem(),
							(String) strCombo3.getSelectedItem(),
							(String) strCombo4.getSelectedItem(), tf3.getText()));
					System.out.println("       출발역--도착역--년--월--일--출발시간--인원");
					for (int i = 0; i < list.size(); i++) {
						System.out.print("[");
						System.out.print(i + 1);
						System.out.print("] ");
						System.out.println(list.get(i).toString());
					}

					save();
					list.clear();
					
					SeatGUI SeatGUI = new SeatGUI(Integer.parseInt(tf3.getText()));
					dispose(); 

				} catch (Exception e1) {
					System.out.print("오류코드 : ");
					System.out.println(e1);
				}

			}
		});

		setSize(500, 400);
		setVisible(true);

	}

	public void load() {
		try {
			FileInputStream fis = new FileInputStream("Ticket.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			list = (ArrayList) ois.readObject(); // (ArrayList) 형 변환 어레이리스트로
													// (다읽어서 어레이스트로 바꾼다)
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}

			ois.close();
			fis.close();
			save();
		} catch (Exception ex) {

		}
	}

	public void save() {
		try {

			FileOutputStream fos = new FileOutputStream("Ticket.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(list);
			oos.flush(); // ?

			oos.close();
			fos.close();
		} catch (Exception ex) {

		}
	}

}
