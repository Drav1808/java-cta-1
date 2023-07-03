package college.oops;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GradingSystem extends JFrame implements ActionListener {

    JFrame f;
    JButton b;
    JPanel p;
    JLabel ttl,ia1,ia2,ia3,cta,see,total,grade,l1,l2;
    JTextField txtFld1,txtFld2,txtFld3,txtFld4,txtFld5;
    Container contentPane;

    GradingSystem(String title){

        super(title);

        b = new JButton("Calculate");
        b.addActionListener(this);

        txtFld1 = new JTextField(10);  
        txtFld2 = new JTextField(10);  
        txtFld3 = new JTextField(10);  
        txtFld4 = new JTextField(10); 
        txtFld5 = new JTextField(10);

        ttl = new JLabel("Grade Calculator");
        ia1 = new JLabel("Enter IA1 Marks:");
        ia2 = new JLabel("Enter IA2 Marks:");
        ia3 = new JLabel("Enter IA3 Marks:");
        cta = new JLabel("Enter CTA Marks:");
        see = new JLabel("Enter SEE Marks;");
        total = new JLabel("Total Marks:");
        grade = new JLabel("Grade:");

        l1 = new JLabel();
        l2 = new JLabel();

        p = new JPanel();
        p.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=4;
        gbc.ipadx=30;
        p.add(ttl,gbc);

        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=2;
        p.add(ia1,gbc);

        gbc.gridx=2;
        gbc.gridy=1;
        p.add(txtFld1,gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        p.add(ia2,gbc);

        gbc.gridx=2;
        gbc.gridy=2;
        p.add(txtFld2,gbc);

        gbc.gridx=0;
        gbc.gridy=3;
        p.add(ia3,gbc);

        gbc.gridx=2;
        gbc.gridy=3;
        p.add(txtFld3,gbc);

        gbc.gridx=0;
        gbc.gridy=4;
        p.add(cta,gbc);

        gbc.gridx=2;
        gbc.gridy=4;
        p.add(txtFld4,gbc);

        gbc.gridx=0;
        gbc.gridy=5;
        p.add(see,gbc);

        gbc.gridx=2;
        gbc.gridy=5;
        p.add(txtFld5,gbc);

        gbc.gridx=0;
        gbc.gridy=6;
        gbc.gridwidth=4;
        p.add(b,gbc);

        gbc.gridx=0;
        gbc.gridy=7;
        gbc.gridwidth=1;
        p.add(total,gbc);

        gbc.gridx=1;
        gbc.gridy=7;
        p.add(l1,gbc);

        gbc.gridx=2;
        gbc.gridy=7;
        p.add(grade,gbc);

        gbc.gridx=3;
        gbc.gridy=7;
        p.add(l2,gbc);

        contentPane = this.getContentPane();
        contentPane.add(p);

    }

    void print(String content, JTextField t) {
		
        JOptionPane.showMessageDialog(f, content, "Error", JOptionPane.ERROR_MESSAGE);
		
        l1.setText("");
		l2.setText("");
		t.setText("");

	}

    public void actionPerformed(ActionEvent e) {
		int ia1 = -20, ia2 = -20, ia3 = -20, cta = -20, see = -20;
		try {
			 ia1 = Integer.parseInt(txtFld1.getText());
		} catch (NumberFormatException nfe) {
			print("Invalid Input for IA-1 marks", txtFld1);
		}

		try {
			ia2 = Integer.parseInt(txtFld2.getText());
		} catch (NumberFormatException nfe) {
			print("Invalid Input for IA-2 marks", txtFld2);
		}

		try {
			ia3 = Integer.parseInt(txtFld3.getText());

		} catch (NumberFormatException nfe) {
			print("Invalid Input for IA-3 marks", txtFld3);
		}
		try {
			cta = Integer.parseInt(txtFld4.getText());
		} catch (NumberFormatException nfe) {
			print("Invalid Input for CTA marks", txtFld4);
		}
		try {
			see = Integer.parseInt(txtFld5.getText());
		} catch (NumberFormatException nfe) {
			print("Invalid Input for SEE marks", txtFld5);
		}
		int cie;
		int total;
		char grade;

		if (ia1 > 20 || ia1 < 0) 
			print("content: IA1 marks is INCORRECT!", txtFld1);
		else if (ia2 > 20 || ia2 < 0)
			print("content: IA2 marks is INCORRECT!", txtFld2);
		else if (ia3 > 20 || ia3 < 0)
			print("content: IA3 marks is INCORRECT!", txtFld3);
		else if (cta > 10 || cta < 0)
			print("content: CTA marks is INCORRECT!", txtFld4);
		else if (see > 100 || see < 0)
			print("content: SEE marks is INCORRECT!", txtFld5);

		else {

			if (ia1 >= ia2 && ia3 >= ia2)
				cie = ia1 + ia3 + cta;
			else if (ia1 >= ia3 && ia2 >= ia3)
				cie = ia1 + ia2 + cta;
			else
				cie = ia2 + ia3 + cta;

			if (cie < 20)
				print("content: Student is detained from taking SEE", txtFld5);

			if (see < 38)
				print("content:Student FAILED : Grade - F", txtFld5);

			if (see == 38 || see == 39)
				see = 40;

			if (see % 2 == 0)
				total = cie + see / 2;
			else
				total = cie + (see + 1) / 2;

			if (cie >= 20 && see >= 40)
				l1.setText(String.valueOf(total));
			else
				l1.setText("");

			if (total >= 90)
				grade = 'S';
			else if (total >= 80)
				grade = 'A';
			else if (total >= 70)
				grade = 'B';
			else if (total >= 60)
				grade = 'C';
			else if (total >= 50)
				grade = 'D';
			else if (total >= 40)
				grade = 'E';
			else if (cie >= 20 && see >= 40)
				grade = 'F';
			else
				grade = ' ';

			l2.setText(String.valueOf(grade));

		}
	}

}

public class GradingSystemDemo {
    
    public static void main(String[] args) {

        JFrame f = new GradingSystem("Student Grading System");

        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setBounds(200,200,400,400);
        f.setVisible(true);

    }

}
