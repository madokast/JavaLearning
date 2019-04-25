package madokast;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

public class AWT5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 1 for SimpleMenu");
        System.out.println("enter 2 for PopupMeneTest");
        System.out.println("enter 3 for SimpleDraw");
        switch(sc.nextInt()){
            case 1:
                new SimpleMenu().ini();
                break;
            case 2:
                new PopupMeneTest().ini();
                break;
            case 3:
                new SimpleDraw().ini();
                break;
        }


    }

}

class SimpleMenu{
    private Frame f = new Frame("Simple Mene");
    private MenuBar mb = new MenuBar();
    private Menu file = new Menu("file");
    private Menu edit = new Menu("edit");
    private MenuItem newItem = new MenuItem("new");
    private MenuItem saveItem = new MenuItem("save");
    private MenuItem exitItem = new MenuItem("exit",new MenuShortcut(KeyEvent.VK_X));//ctrl+x

    private CheckboxMenuItem autoWrap = new CheckboxMenuItem("autoWrap");
    private MenuItem copyItem = new MenuItem("copy");
    private MenuItem pasteItem = new MenuItem("paste");

    private Menu format = new Menu("format");
    private MenuItem commentItem = new MenuItem("comment",new MenuShortcut(KeyEvent.VK_SLASH,true));//ctrl+shift+/
    private MenuItem cancelItem = new MenuItem("cancel");

    private TextArea ta = new TextArea(6,40);

    public void ini(){
        ActionListener exitMuneListener  = e->{
            String cmd = e.getActionCommand();
            ta.append("clice " + cmd +"\n");
            if(cmd.equals("exit"))
                System.exit(0);
        };

        commentItem.addActionListener(exitMuneListener);
        exitItem.addActionListener(exitMuneListener);

        file.add(newItem);
        file.add(saveItem);
        file.add(exitItem);

        edit.add(autoWrap);
        edit.addSeparator();
        edit.add(copyItem);
        edit.add(pasteItem);

        format.add(commentItem);
        format.add(cancelItem);

        edit.add(new MenuItem("-"));
        edit.add(format);

        mb.add(file);
        mb.add(edit);

        f.setMenuBar(mb);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

}

class PopupMeneTest{
    private Frame f = new Frame("SimpleMenu");
    private TextArea ta = new TextArea(6,40);
    private PopupMenu pop = new PopupMenu();
    private CheckboxMenuItem autoWrap = new CheckboxMenuItem("autoWrap");
    private MenuItem copyItem = new MenuItem("copy");
    private MenuItem pasteItem = new MenuItem("paste");
    private Menu format = new Menu("format");
    private MenuItem commentItem = new MenuItem("comment",new MenuShortcut(KeyEvent.VK_SLASH,true));//ctrl+shift+/
    private MenuItem cancelItem = new MenuItem("cancel");

    public void ini(){
        ActionListener menuListener = e->{
            String cmd = e.getActionCommand();

            ta.append("clice " + cmd +"\n");
            if(cmd.equals("exit"))
                System.exit(0);
        };

        commentItem.addActionListener(menuListener);
        pop.add(autoWrap);
        pop.addSeparator();
        pop.add(copyItem);
        pop.add(pasteItem);

        format.add(commentItem);
        format.add(cancelItem);

        pop.add(new MenuItem("-"));
        pop.add(format);

        final Panel p = new Panel();
        p.setPreferredSize(new Dimension(300,160));
        p.add(pop);
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger()){
                    ta.append(String.valueOf(e.getX()));
                    ta.append("\t");
                    ta.append(String.valueOf(e.getY()));
                    ta.append("\n");
                    pop.show(p,e.getX(),e.getY());
                }
            }
        });

        f.add(p);
        f.add(ta,BorderLayout.SOUTH);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.pack();
        f.setVisible(true);

    }
}

class SimpleDraw{
    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";

    private Frame f = new Frame("SimpleDraw");
    private Button rectButton = new Button("drawRect");
    private Button ovalButton = new Button("drawOval");

    private MYCanvas drawArea = new MYCanvas();

    private String shape = "";
    public void ini(){
        Panel p = new Panel();
        rectButton.addActionListener(e->
        {
            shape = RECT_SHAPE;
            drawArea.repaint();
        });

        ovalButton.addActionListener(e->{
            shape = OVAL_SHAPE;
            drawArea.repaint();
        });

        p.add(rectButton);
        p.add(ovalButton);
        drawArea.setPreferredSize(new Dimension(250,180));

        f.add(drawArea);
        f.add(p,BorderLayout.SOUTH);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.pack();
        f.setVisible(true);
    }





    class MYCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            Random rand = new Random();
            if(shape.equals(RECT_SHAPE)){
                g.setColor(new Color(220,100,80));
                g.drawRect(rand.nextInt(200),rand.nextInt(120),40,60);
            }

            if(shape.equals(OVAL_SHAPE)){
                g.setColor(new Color(97, 220, 72));
                g.fillOval(rand.nextInt(200),rand.nextInt(120),50,40);
            }
        }
    }
}