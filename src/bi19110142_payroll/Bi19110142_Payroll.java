/**
 */
package bi19110142_payroll;

/**
 *
 * @author Mohammad Ariff Bin Kassim BI19110142
 */

import javax.swing.*; //import java swing class
import java.awt.*; //import java awt class
import java.awt.event.*; //import java awt event class


public class Bi19110142_Payroll extends JFrame implements ActionListener {

	JTextField emp_name = new JTextField(15); //Create an employee's name text field instance
	JTextField depart     = new JTextField(15); //Create an employee's department text field instance
        JTextField emp_id = new JTextField(15); //Create an employee's id text field instance
	JTextField rate     = new JTextField(15); //Create a rate per day text field instance
	JTextField days     = new JTextField(15); //Create a number of working days text field instance
        JTextField ot     = new JTextField(15);  //Create an overtime text field instance


	JButton Compute = new JButton("Compute");  //Create compute button
	JButton Clear   = new JButton("Clear"); //Create clear button


    JLabel emp_label2 = new JLabel(); //Create an employee's name text-based panel
    JLabel depart_label2 = new JLabel(); //Create an employee's department text-based panel
    JLabel id_label2 = new JLabel(); //Create an employee's id text-based panel
    JLabel ot_label2 = new JLabel(); //Create an overtime text-based panel
    JLabel dsall_label2 = new JLabel(); //Create a day shift allowance text-based panel
    JLabel nsall_label2 = new JLabel(); //Create a night shift allowance text-based panel
    JLabel epf_label2 = new JLabel(); //Create an epf text-based panel
    JLabel socso_label2 = new JLabel(); //Create a socso text-based panel
    JLabel gross = new JLabel(); //Create a gross salary text-based panel
    JLabel totalgross_label2 = new JLabel(); //Create a total gross salary text-based panel
    JLabel totaldeduction_label2 = new JLabel(); //Create a total deduction salary text-based panel
    JLabel totalsalary_label2 = new JLabel(); //Create a total salary text-based panel
    JLabel report = new JLabel(); //Create a report text-based panel
     
    double dsall = 100; //declare value of day shift allowance
    double nsall = 200; //declare value of night shift allowance
    double calcot = 0.00; //declare value of overtime calculation allowance
    double grosssolve = 0.00; //declare value of gross calculation allowance
    double calcepf = 0.00; //declare value of epf calculation allowance
    double calcsocso = 0.00; //declare value of socso calculation allowance
    double totalgross = 0.00; //declare value of total gross salary calculation allowance
    double totaldeduction = 0.00; //declare value of total deduction calculation allowance
    double totalsalary = 0.00; //declare value of total salary calculation allowance

public Bi19110142_Payroll() {

  super("Payroll System"); //create a new Jframe container
  setSize(243,380); //Give the frame an initial size
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate the programe when we close the application

  JPanel pane = new JPanel();

  JLabel emp_name_label = new JLabel("     Name         "); //create an employee's name text-based panel
  JLabel depart_label     = new JLabel("   Department    "); //create an employee's name department text-based panel
  JLabel id_label     = new JLabel("        ID           "); //create an employee's id text-based panel
  JLabel rate_label     = new JLabel("   Rate Per Day "); //create a rate per day text-based panel
  JLabel days_label     = new JLabel("   No. of Days  "); //create a number of working days text-based panel
  JLabel ot_label     = new JLabel("   Overtime(hrs)"); //create an overtime text-based panel

  pane.add(emp_name_label); //Add the employee's name label to the frame
  pane.add(emp_name); //Add the employee's name label to the frame

  pane.add(depart_label); //Add the employee's department label to the frame
  pane.add(depart); //Add the employee's department label to the frame

  pane.add(id_label); //Add the employee's id label to the frame
  pane.add(emp_id); //Add the employee's id label to the frame

  pane.add(rate_label); //Add the rate per day label to the frame
  pane.add(rate); //Add the rate per day label to the frame
  
  pane.add(days_label); //Add the number of working days label to the frame
  pane.add(days); //Add the number of working days label to the frame
  
  pane.add(ot_label); //Add the overtime label to the frame
  pane.add(ot); //Add the overtime label to the frame

  pane.add(Compute); //Add the compute button to the frame
  pane.add(Clear); //Add the clear button to the frame

  Compute.addActionListener(this); //Add action listener
  Clear.addActionListener(this); //Add action listener
  Compute.setToolTipText("Click here to solve the salary."); //Add tool tip text
  Clear.setToolTipText("Click here to clear text fields."); //Add tool tip text

  
  add(pane); //To create pane

  setVisible(true); //Display the frame
  
} //end public

    //Handle the button 
    public void actionPerformed(ActionEvent e) {

        //compute button action performed
        if (Compute == e.getSource()) {
            String name = emp_name.getText(); //To get employee's name text
            String depart2 = depart.getText(); //To get employee's department text
            String id2 = emp_id.getText(); //To get employee's id text

            double emp_rate = Double.parseDouble(rate.getText());  //To get rate per day text
            int emp_days = Integer.parseInt(days.getText());  //To get number of working days text
            int ot_days = Integer.parseInt(ot.getText());  //To get overtime text

            calcot = (emp_rate / 8 * ot_days); //overtime calculation formula
            grosssolve = (emp_rate * emp_days); //gross salary calculation formula
            totalgross = (calcot + dsall + nsall + grosssolve); //total gross salary calculation formula
            calcepf = (emp_rate * 7 / 100) * emp_days; //epf calculation formula
            calcsocso = (emp_rate * 2 / 100) * emp_days; //socso calculation formula
            totaldeduction = calcepf + calcsocso; //total deduction calculation formula
            totalsalary = totalgross - totaldeduction; //total salary calculation formula

            
            try {
                //compute button action performed
                if (e.getSource() == Compute) {

                    JOptionPane.showMessageDialog(null, "=== Salary Report ===" //to show salary report text
                            + "\n\n Employee's Name  : " + name //to show employee's name output
                            + "\n Department : " + depart2 //to show employee's department output
                            + "\n Employee's ID  : "+ id2  //to show employee's id output
                            + "\n\n Gross Salary : RM " + String.format("%.2f", grosssolve) //to show gross salary output
                            + "\n Total Overtime : RM " + String.format("%.2f", calcot)  //to show overtime output
                            + "\n Day Shift Allowance : RM " + String.format("%.2f", dsall)  //to show day shift allowance output
                            + "\n Night Shift Allowance : RM " + String.format("%.2f", nsall)  //to show night shift allowance output
                            + "\n\n EPF : RM " + String.format("%.2f", calcepf)  //to show epf output
                            + "\n SOCSO : RM " + String.format("%.2f", calcsocso)  //to show socso output
                            + "\n\n Total Gross Salary : RM " + String.format("%.2f", totalgross) //to show total gross salary output
                            + "\n Total Deduction : RM " + String.format("%.2f", totaldeduction)  //to show total deduction output
                            + "\n Total Salary : RM " + String.format("%.2f", totalsalary));   //to show total salary output
                } //end if
                
            } //end try
            
            catch (NumberFormatException nfe) {

                JOptionPane.showMessageDialog(null, "You have entered invalid input",
                        "Warning", JOptionPane.ERROR_MESSAGE); //to add the output to another frame
            } //end catch

        } //end if 
        
           //clear button action performed
           else if (Clear == e.getSource()) {

            emp_name.setText(""); //to create an employee's name text-based panel
            depart.setText(""); //to create an employee's department text-based panel
            emp_id.setText(""); //to create an employee's id text-based panel
            rate.setText(""); //to create a rate per day text-based panel
            days.setText(""); //to create a number of working days text-based panel
            report.setText(""); //to create a report text-based panel
            emp_label2.setText(""); //to create an employee's name text-based panel
            depart_label2.setText(""); //to create an employee's department text-based panel
            id_label2.setText(""); //to create an employee's id text-based panel
            ot_label2.setText(""); //to create an overtime text-based panel
            ot.setText(""); //to create an overtime text-based panel
            dsall_label2.setText(""); //to create a day shift allowance text-based panel
            nsall_label2.setText(""); //to create a night shift allowance text-based panel
            gross.setText(""); //to create a gross salary text-based panel
            totalgross_label2.setText(""); //to create a total gross salary text-based panel
            epf_label2.setText(""); //to create an epf text-based panel
            socso_label2.setText(""); //to create a socso text-based panel
            totaldeduction_label2.setText(""); //to create a total deduction text-based panel
            totalsalary_label2.setText(""); //to create a total salary text-based panel
            
       } //end if else
        
    } //end public void

    public static void main(String[] args) {
        //create the frame on the event dispatching thread
        Bi19110142_Payroll employee = new Bi19110142_Payroll();
        
    } // end public static void

} //end public class