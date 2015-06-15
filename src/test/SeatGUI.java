package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SeatGUI extends JFrame {

	JPanel pan_main = new JPanel(new GridLayout(13, 4, 30, 20));
	JPanel pan_north = new JPanel(new GridLayout());
	ArrayList<String> selected_list = new ArrayList<String>();
	ArrayList<String> select_list = new ArrayList<String>();

//	ArrayList<String> select_list = new ArrayList<String>();
	JButton btn_ok = new JButton("확인");
	// SeatGUI(Ticket ticket) {
	int person;

	SeatGUI(int person) {
		load();
		this.person = person;
		Container contentPane;
		contentPane = getContentPane();

		setTitle("좌석 선택");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

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

		// setLayout(new GridLayout(12, 4, 30, 20));

		String[] section = { "1", "2", "3", "4" };
		ImageIcon[] images = { new ImageIcon("../images/1.jpg"),
				new ImageIcon("../images/2.jpg"),
				new ImageIcon("../images/3.jpg"),
				new ImageIcon("../images/4.jpg") };
		JLabel imgLabel = new JLabel(images[0]);

		// JComboBox strCombo = new JComboBox(section);
		//
		// strCombo.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
		// JComboBox cb = (JComboBox) e.getSource();
		// int index = cb.getSelectedIndex();
		// imgLabel.setIcon(images[index]);
		// // 눌렀을 때 번호 출력
		//
		// }
		// });
		//
		// JLabel blank1 = new JLabel();
		// JLabel blank2 = new JLabel();
		//
		// JLabel jl = new JLabel("칸");

		JLabel jl1 = new JLabel("창측");
		JLabel jl2 = new JLabel("내측");
		JLabel jl3 = new JLabel("내측");
		JLabel jl4 = new JLabel("창측");

		//
		// add(blank1);
		// contentPane.add(strCombo);
		//
		// add(jl);
		//
		// add(blank2);
		//
		pan_main.add(jl1);
		pan_main.add(jl2);
		pan_main.add(jl3);
		pan_main.add(jl4);

		int count = 0;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 4; j++) {
				JButton btn = new JButton(String.valueOf(++count));
				
				if(selected_list.contains(String.valueOf(count))){
					btn.setEnabled(false);
				}
				
				pan_main.add(btn);

				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
//						
						if(select_list.size() == person && !select_list.contains(btn.getText())){
							customer4 customer4 = new customer4();
							
						}
						else if (select_list.contains(btn.getText())) {
							select_list.remove(btn.getText());
							btn.setForeground(Color.BLACK);
						} else {
							select_list.add(btn.getText());
							btn.setForeground(Color.RED);

						}
						// TODO Auto-generated method stub

					}
				});
			}
		}
		
		btn_ok.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				save();
				dispose();
			}
		});	
		add(pan_main, "Center");
		add(btn_ok, "South");
		setSize(400, 600);
		setVisible(true);

	}
	public void save() {
		try {

			FileOutputStream fos = new FileOutputStream("Seat.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for(int i = 0; i < select_list.size(); i++){
				selected_list.add(select_list.get(i));
			}
			oos.writeObject(selected_list);
			oos.flush();

			oos.close();
			fos.close();
		} catch (Exception ex) {

		}
	}

	public void load() {
		try {
			FileInputStream fis = new FileInputStream("Seat.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			selected_list = (ArrayList) ois.readObject(); // (ArrayList) 형 변환 어레이리스트로
													// (다읽어서 어레이스트로 바꾼다)
			for (int i = 0; i < select_list.size(); i++) {
				System.out.println(select_list.get(i).toString());
			}

			ois.close();
			fis.close();
			save();
		} catch (Exception ex) {

		}
	}

	
}
class customer4 extends JFrame{
	public customer4(){
		setTitle("console");
		
		
		JLabel jl = new JLabel("좌석을 전부 선택하셨습니다.");
		
		setLayout(new GridLayout(1,0));
		add(jl);
		
		setSize(300,200);
		setVisible(true);
		
	}
	
}

