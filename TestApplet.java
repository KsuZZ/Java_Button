import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.awt.Image;

public class TestApplet extends Applet {
    LButton bEat;
    Canvas canvas;
    Color color = Color.blue;
	Image img1, img2, img3, img4;
	int im_0 = 1;
    
    public void init() {		
	this.setBackground(new Color(255, 255, 255));
        this.setLayout(new BorderLayout());
       Panel p = new Panel(new BorderLayout());
        bEat = new LButton("����� ����");
	bEat.setForeground(color);
        bEat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
		        bEat.setForeground(color);
                color = Color.blue;
                canvas.repaint();
            }
        });
        p.add(bEat, BorderLayout.CENTER);
        canvas = new Canvas() {
                public void paint(Graphics g) {
					if (im_0 == 1){
				        Image img1= getImage(getCodeBase(), "depositphotos_1.jpg");
				        g.drawImage(img1, getWidth() / 2 - 95, getHeight() / 2 - 95, this);
					}
					else if (im_0 == 2) {
				        Image img2= getImage(getCodeBase(), "depositphotos_2.jpg");
				        g.drawImage(img2, getWidth() / 2 - 95, getHeight() / 2 - 95, this);
					}
                    else if (im_0 == 3) {
				        Image img3= getImage(getCodeBase(), "depositphotos_3.jpg");
				        g.drawImage(img3, getWidth() / 2 - 95, getHeight() / 2 - 95, this);
					}
					else if (im_0 == 4) {
				        Image img4= getImage(getCodeBase(), "depositphotos_4.jpg");
				        g.drawImage(img4, getWidth() / 2 - 95, getHeight() / 2 - 95, this);
					}
					else if (im_0 == 5)
					{
	                	Font f = new Font("Times New Roman", Font.BOLD, 22);
		            g.setFont(f);
					g.drawRect(5, 3, getWidth() - 23 , getHeight() - getHeight() / 10 - 13);
		            g.drawString("�����", getWidth() / 2 - 35, getHeight() / 2 - 95);
					}
					else if (im_0 == 6)
					{
					Image img1= getImage(getCodeBase(), "depositphotos_1.jpg");
				    g.drawImage(img1, getWidth() / 2 - 95, getHeight() / 2 - 95, this);
		            im_0=1;
					}
					First(im_0);
                }
            };
        this.add(p, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER);
    }	
	public void First(int im_0){ 
		this.im_0=im_0;
    }
	
	
	
	
class LButton extends Component {
    // ���� ������������� ������� ������
    protected ActionListener actionListener;
    // ����� ������
    protected String label;
    // ����, ������������ ������ �� ������
    protected boolean pressed = false;
    // ���� ���� ������ (������-�����)
    protected Color color = Color.blue;
    // ����������� ������
    public LButton(String label) {
        // ��������� ����� ������
        this.label = label;
        // �������� ������ ����������� �� ������� �� ����
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
    public LButton() { this("");}
    // ��������� ����������� ������
    public void paint(Graphics g) {
        // ��������� ������� �������� ����� ������
        int width = getSize().width + 10; // ������
        int height = getSize().height + 10; // ������
	    // �������� ��������� �������������, ����������� ������, ��������, ������ ��� ���
        // ������ � ������� ������, � � ����������� �� ����� ��������� "����"
		if (im_0 < 5)
		{
		g.draw3DRect(5, 3, width - 23 , height - height / 10 - 13 , !pressed);
		g.fillRect(5, 3, width - 23 , height - height / 10 - 13);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setPaint(Color.yellow);
		g2d.setStroke(new BasicStroke(3, // ������� ����
                    BasicStroke.CAP_ROUND, // ������ ��������� ������ �����
                    BasicStroke.JOIN_BEVEL)); // ������ �������� �����
					
		g2d.fillOval(width / 2 - 35, height / 2 - height / 10 - 15, 30, 30); // ���� ����
		g2d.setPaint(Color.black);
		if (im_0%2 == 0){
			g2d.fillOval(width / 2 - 29, height / 2 - height / 10 - 9, 10, 10); // ���� ������
			}
		else {
			g2d.fillOval(width / 2 - 29, height / 2 - height / 10 - 9, 10, 4); // ���� ������
			g2d.setPaint(Color.blue);
			int xPoints[];
			int yPoints[];
		xPoints = new int[3];
		yPoints = new int[3];
	    xPoints[0] = width / 2 - 40;
        xPoints[1] = width / 2 - 20;
        xPoints[2] = width / 2 - 32;
        yPoints[0] = height / 2 - height / 10 - 1;
        yPoints[1] = height / 2 - height / 10 - 1;
        yPoints[2] = height / 2 - height / 10 + 10;
		g2d.fillPolygon(xPoints, yPoints, 3);
			}
        // ��������� ���� ������
        g.setColor(Color.blue);
        // ������� ������� �����
		Font f = new Font("Times New Roman", Font.BOLD, 15);
        // ���� ����� ����������, ��
        if (f != null) {
            // ������� �������������� �������� ������
            FontMetrics fm = getFontMetrics(f); //getFont());
            // ������� �������� "������" ����� ������, �������� ��������� ������ � ��, "������" �� ������
            g.setColor(Color.white);
			g.setFont(f);
            g.drawString(label, width / 2 + 50 - fm.stringWidth(label) / 2 + (pressed ? 0 : 1), height / 2 + fm.getMaxDescent() + (pressed ? 2 : 3));
        }
		}
		else
		{
		Font f = new Font("Times New Roman", Font.BOLD, 22);
		g.setFont(f);
		g.drawString("������ ������", width / 2 - 85, height / 2 - height / 10 - 1);
		//im_0 = 0;
		}
    }
    // ��������� ������� ������
    public Dimension getPreferredSize() {
        // ������� ������� �����
        Font f = new Font("Times New Roman", Font.BOLD, 22);
        // ���� ����� ����������, ��
        if (f != null) {
            // ������� �������������� �������� ������
            FontMetrics fm = getFontMetrics(f); //get.Font());
            // � ��������� ������� ������ � ����������� ��
            // �������������� �������� �������� ������ �
            // ����� ������ ����� ������
            return new Dimension(fm.stringWidth(label) + 20, fm.getHeight() + 20);
        } else // � ��������� ������
        {
            // ��������� ������� ������ 100 �� 100 ��������
            return new Dimension(40, 40);
        }
    }
    // ��������� ������� ������ �� ��������� 100 �� 100 ��������
    public Dimension getMinimumSize() {
        return new Dimension(40, 40);
    }

    // ��������������� ������, �������� ���������� AWT-������� �� ����
    // � ������-���������� ������� 
    public void processMouseEvent(MouseEvent e) {
        Graphics g;
        switch (e.getID()) {
            // ������ ������ ����
        case MouseEvent.MOUSE_PRESSED:
            pressed = true; // ��������� ���� �������
			im_0++;
            repaint();      // ���������� ���������
            break;
             // �������� ������ ����
        case MouseEvent.MOUSE_RELEASED:
            // ���� ��� ��������������� ���� �������������
            // ��������� ��� ������ ����������
            if (actionListener != null) {
                // �������� � ���, ��� ��������� action-������� 
                actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, label));
            }
            // ���� ������-��������� ���� ������
            if (pressed == true) {
                pressed = false; // ������� ���� �������
                repaint(); // ���������� ��� ���������
            }
            break;
            // ������ ���� ������� ���������
        case MouseEvent.MOUSE_ENTERED:
            break;
            // ������ ���� �������� � ����������
        case MouseEvent.MOUSE_EXITED:
            // ���� ������ ���� ������
            if (pressed == true) {
                repaint(); // �� ���������� ������-���������
            }
            break;
		}
        // ��������� � ����������� ���� ������������� ������
        super.processMouseEvent(e);
    }
    // ����� ��� ����������� ����� ������������� ������� �� ������
    public void addActionListener(ActionListener listener) {
		//�����, ������� ��������� ����������� � �������-��������� ����������� ��������������� ������� awt
        actionListener = AWTEventMulticaster.add(actionListener, listener);
		//�����, ����������� ������� �� ����
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
    // ����� ��� �������� ����� ������������� ������� �� ������
    public void removeActionListener(ActionListener listener) {
        actionListener = AWTEventMulticaster.remove(actionListener, listener);
    }
}
}

