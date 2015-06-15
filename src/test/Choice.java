package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class customer1 extends JFrame {
	public customer1() {
		setTitle("console");

		JLabel jl = new JLabel("����â�� ����մϴ�.");

		setLayout(new GridLayout(1, 0));
		add(jl);

		setSize(300, 200);
		setVisible(true);

	}

}

class customer2 extends JFrame {
	public customer2() {
		setTitle("console");

		JLabel jl = new JLabel("���� �Ϸ�Ǿ����ϴ�.");

		setLayout(new GridLayout(1, 0));
		add(jl);

		setSize(300, 200);
		setVisible(true);

	}
}

public class Choice extends JFrame {
	Scanner a = new Scanner(System.in);

	ArrayList<Ticket> list = new ArrayList<Ticket>();

	FileInputStream fin = null;
	ObjectInputStream ois = null;

	FileOutputStream fout = null;
	ObjectOutputStream oos = null;

	String id;

	Choice(String user_id) {
		this.id = user_id;
		setTitle("you have to choice!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		setLayout(new GridLayout(1, 2, 30, 30));

		JButton jb1 = new JButton("����");
		JButton jb2 = new JButton("������");

		add(jb1);
		add(jb2);

		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���⿡ ��ư���������� ������ �߰��ϸ��
				try {

					TicketGUI g = new TicketGUI(id);
					customer1 customer1 = new customer1();

				} catch (Exception e1) {
					System.out.print("�����ڵ� : ");
					System.out.println(e1);
				}

			}
		});
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ���⿡ ��ư���������� ������ �߰��ϸ��
				console console = new console(id);

				try {
					// console console = new console(id);

				} catch (Exception e1) {
					System.out.print("�����ڵ� : ");
					System.out.println(e1);
				}

			}

		});

		setSize(500, 400);
		setVisible(true);

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

	public void load() {
		try {
			FileInputStream fis = new FileInputStream("Ticket.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			list = (ArrayList) ois.readObject(); // (ArrayList) �� ��ȯ ��̸���Ʈ��
													// (���о ��̽�Ʈ�� �ٲ۴�)
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}

			ois.close();
			fis.close();
			save();
		} catch (Exception ex) {

		}
	}

}
