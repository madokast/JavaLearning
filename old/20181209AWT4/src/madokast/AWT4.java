package madokast;

import java.awt.*;
import java.awt.event.*;

public class AWT4 {
    public static void fileDialog(){
        Frame f= new Frame("tesr");
        FileDialog d1 =new FileDialog(/*所属副标题*/f,"open file",FileDialog.LOAD);
        FileDialog d2 = new FileDialog(f,"save file", FileDialog.SAVE);

        Button b1 =new Button("open");
        Button b2 =new Button("save");

        b1.addActionListener(e->
        {d1.setVisible(true);
        System.out.println(d1.getDirectory()+d1.getFile());}
        );

        b2.addActionListener(e->
        {d2.setVisible(true);
        System.out.println(d2.getDirectory()+d2.getFile());}
        );

        f.add(b1);
        f.add(b2,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    private Frame f =new Frame("eventQs");
    private Button ok = new Button("ok");
    private TextField tf = new TextField();
    private TextArea ta= new TextArea(6,40);
    private Button b1 = new Button("b1");
    private Button b2 = new Button("b2");

    public void eventQs(){


        ok.addActionListener(new OkListener());

        f.add(tf);
        f.add(ok,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
            }

    class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("OK is clicked");
            tf.setText(tf.getText()+"hello world");
        }
    }

    public void multiListener(){
        b1.addActionListener(
                e->{
                    ta.append("1st eventListener source is "+e.getActionCommand()+"\n");
                }
        );
        b1.addActionListener(
                e->{
                    ta.append("click "+e.getActionCommand()+" button"+"\n");
                }
        );
        b2.addActionListener(
                e->{
                    ta.append("click "+e.getActionCommand()+" button"+"\n");
                }
        );
        Panel p = new Panel();
        p.add(b1);
        p.add(b2);

        f.add(ta);
        f.add(p,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);

    }

    public void windowsListener(){
        f.addWindowListener(new MyWindowsListener());
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

    class MyWindowsListener implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {
            ta.append("windowOpened "+ e.paramString()+"\n");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            ta.append("windowClosing"+ e.paramString()+"\n");
            System.exit(0);
        }

        @Override
        public void windowClosed(WindowEvent e) {
            ta.append("windowClosed"+ e.paramString()+"\n");
        }

        @Override
        public void windowIconified(WindowEvent e) {
            ta.append("windowIconified"+ e.paramString()+"\n");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            ta.append("windowDeiconified"+ e.paramString()+"\n");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            ta.append("windowActivated"+ e.paramString()+"\n");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            ta.append("windowDeactivated"+ e.paramString()+"\n");
        }
    }

    public void windowAdapter(){

        b1.addActionListener(
                e->{
                    System.exit(0);
                }
        );

        f.addWindowListener(new MyWindowAdapter());
        f.add(ta);
        f.add(b1,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    class MyWindowAdapter extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            ta.append("e = " + e);
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        //new AWT4().eventQs();

        //new AWT4().multiListener();

        //new AWT4().windowsListener();

        new AWT4().windowAdapter();
    }
}
