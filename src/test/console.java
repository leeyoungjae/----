package test;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

public class console extends JFrame {
	ArrayList<String> select_list = new ArrayList<String>();
	ArrayList<Ticket> list = new ArrayList<Ticket>();

	JPanel jp = new JPanel(new GridLayout(4, 1));
	
	JTextField jtf = new JTextField();
	JLabel jl = new JLabel();

	String id;
	int index;

	console(String id) {
		this.id = id;
		load();
		load2();
		JMenuBar mb = new JMenuBar();
		JMenu m = new JMenu("Option");
		JMenuItem mi = new JMenuItem("Exit");
		mb.add(m);
		m.add(mi);
		setJMenuBar(mb);

		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		DefaultTableModel model = new DefaultTableModel() {
			public boolean isCellEditAble(int row, int column) {
				return false;
			}
		};
		model.addColumn("유저");
		model.addColumn("출발역");
		model.addColumn("도착역");
		model.addColumn("날짜");
		model.addColumn("시간");
		model.addColumn("인원");
//		model.addColumn("좌석번호");

		for (int i = 0; i < list.size(); i++) {
			Ticket temp_ticket = list.get(i);
			
			String temp_id = temp_ticket.getUserId();

			String temp_d_station = temp_ticket.getD_station();
			String temp_a_station = temp_ticket.getA_station();
			String temp_year = temp_ticket.getYear();
			String temp_month = temp_ticket.getMonth();
			String temp_day = temp_ticket.getDay();
			String temp_time = temp_ticket.getTime();
			String temp_person = temp_ticket.getPerson(); //
//			String temp_seat = (String)select_list.get(i);

			model.addRow(new String[] { temp_id, temp_d_station+"역",
					temp_a_station+"역", temp_year+"년 "+ temp_month+"월 "+ temp_day+"일", temp_time+"시",
					temp_person+"명" });
			
			

		}

		JButton jb1 = new JButton("환불[제거]");
		JButton jb2 = new JButton("자리변경");
		//JButton jb3 = new JButton("좌석 선택");
		JButton jb3 = new JButton("검색");
		
	
		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		//jp.add(jb4);
		
		
		
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(center);
		}

		add(jp, BorderLayout.EAST);
		add(scroll, BorderLayout.CENTER);

		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				index = table.getSelectedRow();
				

				// if(e.getClickCount() == 2){

				// }
			}
		});

		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 여기에 버튼눌렀을때의 반응을 추가하면됨
				try {
					model.removeRow(index);
					list.remove(index);
					save();
					load();
					select_list.remove(index);
					save2();
					load2();

				} catch (Exception e1) {
					System.out.print("오류코드 : ");
					System.out.println(e1);
				}

			}
		});
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 여기에 버튼눌렀을때의 반응을 추가하면됨
				try {
					model.removeRow(index);
					list.remove(index);
					save();
					load();
					select_list.remove(index);
					save2();
					load2();
					
					
					TicketGUI g = new TicketGUI(id);
					customer3 customer3 = new customer3();
					//set 모델로 수정
					
					

				} catch (Exception e1) {
					System.out.print("오류코드 : ");
					System.out.println(e1);
				}

			}
		});
		
//		jb3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// 여기에 버튼눌렀을때의 반응을 추가하면됨
//				try {
//					SeatGUI SeatGUI = new SeatGUI(Integer.parseInt(list.get(index).person));
//					
//					
//					
//					
//
//				} catch (Exception e1) {
//					System.out.print("오류코드 : ");
//					System.out.println(e1);
//				}
//
//			}
//		});
		
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 여기에 버튼눌렀을때의 반응을 추가하면됨
				try {
					
					
					
					

				} catch (Exception e1) {
					System.out.print("오류코드 : ");
					System.out.println(e1);
				}

			}
		});

		setSize(1000, 500);
		setVisible(true);

	}

	



	public void save() {
		try {

			FileOutputStream fos = new FileOutputStream("Ticket.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(list);
			oos.flush();

			oos.close();
			fos.close();
		} catch (Exception ex) {

		}
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
	
	public void save2() {
		try {

			FileOutputStream fos = new FileOutputStream("Seat.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(select_list);
			oos.flush();

			oos.close();
			fos.close();
		} catch (Exception ex) {

		}
	}

	public void load2() {
		try {
			FileInputStream fis = new FileInputStream("Seat.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			select_list = (ArrayList) ois.readObject(); // (ArrayList) 형 변환 어레이리스트로
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

class customer3 extends JFrame{
	public customer3(){
		setTitle("console");
		
		
		JLabel jl = new JLabel("다시 예매 해주세요.");
		
		setLayout(new GridLayout(1,0));
		add(jl);
		
		setSize(300,200);
		setVisible(true);
		
	}
	
}
