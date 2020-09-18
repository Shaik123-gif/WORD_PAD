import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Notepad implements ActionListener,WindowListener
{
JFrame j;
JMenuBar mb;
JMenu file,edit,format,view,help;
JMenuItem new1,open,save,saveas,exit,cut,copy,paste,find,go_to,selectall,replace;
JTextArea ta;
JFileChooser fo;
int c=0,happen=0;
Notepad()
{
j=new JFrame("NOTEPAD");
mb=new JMenuBar();
file=new JMenu("File");
edit=new JMenu("Edit");
format=new JMenu("Format");
view=new JMenu("View");
help=new JMenu("Help");
mb.add(file);
mb.add(edit);
mb.add(format);
mb.add(view);
mb.add(help);
new1=new JMenuItem("New");
open=new JMenuItem("Open");
save=new JMenuItem("Save");
saveas=new JMenuItem("Save As");
exit=new JMenuItem("Exit");
file.add(new1);
file.add(open);
file.add(save);
file.add(saveas);
file.add(exit);
cut=new JMenuItem("Cut");
copy=new JMenuItem("Copy");
paste=new JMenuItem("Paste");
go_to=new JMenuItem("Go To");
selectall=new JMenuItem("Select All");
find=new JMenuItem("Find");
replace=new JMenuItem("Replace");
edit.add(cut);
edit.add(copy);
edit.add(paste);
edit.add(find);
edit.add(replace);
edit.add(go_to);
edit.add(selectall);
ta=new JTextArea();
j.add(ta);
new1.addActionListener(this);
exit.addActionListener(this);
cut.addActionListener(this);
copy.addActionListener(this);
paste.addActionListener(this);
selectall.addActionListener(this);
go_to.addActionListener(this);
replace.addActionListener(this);
find.addActionListener(this);
open.addActionListener(this);
saveas.addActionListener(this);
save.addActionListener(this);
j.setJMenuBar(mb);
j.setVisible(true);
j.setSize(500,500);
paste.setEnabled(false);
fo=new JFileChooser();
j.addWindowListener(this);
j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);
}
public void windowClosing(WindowEvent we)
{
System.out.println("hello");
if(happen==0)
{
JOptionPane.showMessageDialog(j,"you not save the file");
}
}
public void windowClosed(WindowEvent we)
{
}
public void windowOpened(WindowEvent we)
{
}
public void windowDeactivated(WindowEvent we)
{
}
public void windowActivated(WindowEvent we)
{
}
public void windowIconified(WindowEvent we)
{
}
public void windowDeiconified(WindowEvent we)
{
}
public void actionPerformed(ActionEvent ae)
{
String y="";
int p;
if(ae.getSource()==new1)
ta.setText("");
else if(ae.getSource()==exit)
System.exit(0);
else if(ae.getSource()==cut)
{
ta.cut();
paste.setEnabled(true);
}
else if(ae.getSource()==copy)
{
ta.copy();
paste.setEnabled(true);
}
else if(ae.getSource()==paste)
ta.paste();
else if(ae.getSource()==selectall)
{
ta.selectAll();
paste.setEnabled(true);
}
else if(ae.getSource()==find)
{
String str=JOptionPane.showInputDialog("Find What:");
System.out.println(str);
}
else if(ae.getSource()==open)
{
try
{
fo.showOpenDialog(j);
if(fo.getSelectedFile()==null)
return;
FileInputStream fin=new FileInputStream(fo.getSelectedFile());
while((p=fin.read())!=-1)
{
y=y+(char)p;
}
ta.setText(y);
}
catch(Exception e)
{
System.out.println(e);
}
}
else if(ae.getSource()==saveas)
{
try
{
fo.showSaveDialog(j);
if(fo.getSelectedFile()==null)
return;
FileOutputStream fout=new FileOutputStream(fo.getSelectedFile());
fout.write(ta.getText().getBytes());
happen=1;
c=1;
}
catch(Exception e)
{
System.out.println(e);
}
}
else if(ae.getSource()==save)
{
if(c==1)
{
try
{
FileOutputStream fout=new FileOutputStream(fo.getSelectedFile());
fout.write(ta.getText().getBytes());
}
catch(Exception e)
{}
}
else
{
try
{
fo.showSaveDialog(j);
if(fo.getSelectedFile()==null)
return;
FileOutputStream fout1=new FileOutputStream(fo.getSelectedFile());
fout1.write(ta.getText().getBytes());
c=1;
happen=1;
}
catch(Exception e)
{}
}
}
}
public static void main(String ars[])
{
Notepad n=new Notepad();
}
}
