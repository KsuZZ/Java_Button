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
        bEat = new LButton("Съешь меня");
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
		            g.drawString("Конец", getWidth() / 2 - 35, getHeight() / 2 - 95);
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
    // Блок прослушивания событий кнопки
    protected ActionListener actionListener;
    // Метка кнопки
    protected String label;
    // Флаг, определяющий нажата ли кнопка
    protected boolean pressed = false;
    // Цвет фона кнопки (светло-серый)
    protected Color color = Color.blue;
    // Конструктор кнопки
    public LButton(String label) {
        // Установим метку кнопки
        this.label = label;
        // Позволим кнопке реагировать на события от мыши
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
    public LButton() { this("");}
    // Рисование содержимого кнопки
    public void paint(Graphics g) {
        // Определим размеры рисуемой части кнопки
        int width = getSize().width + 10; // ширина
        int height = getSize().height + 10; // высота
	    // Нарисуем трёхмерный прямоугольник, обрамляющий кнопку, учитывая, нажата или нет
        // кнопка в текущий момент, и в зависимости от этого установим "тень"
		if (im_0 < 5)
		{
		g.draw3DRect(5, 3, width - 23 , height - height / 10 - 13 , !pressed);
		g.fillRect(5, 3, width - 23 , height - height / 10 - 13);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setPaint(Color.yellow);
		g2d.setStroke(new BasicStroke(3, // толщина пера
                    BasicStroke.CAP_ROUND, // способ отрисовки концов линий
                    BasicStroke.JOIN_BEVEL)); // способ стыковки линий
					
		g2d.fillOval(width / 2 - 35, height / 2 - height / 10 - 15, 30, 30); // овал лица
		g2d.setPaint(Color.black);
		if (im_0%2 == 0){
			g2d.fillOval(width / 2 - 29, height / 2 - height / 10 - 9, 10, 10); // глаз открыт
			}
		else {
			g2d.fillOval(width / 2 - 29, height / 2 - height / 10 - 9, 10, 4); // глаз закрыт
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
        // Установим цвет кнопки
        g.setColor(Color.blue);
        // Выберем текущий шрифт
		Font f = new Font("Times New Roman", Font.BOLD, 15);
        // Если шрифт существует, то
        if (f != null) {
            // Получим характеристики текущего шрифта
            FontMetrics fm = getFontMetrics(f); //getFont());
            // Сначала нарисуем "рельеф" метки кнопки, учитывая геометрию шрифта и то, "нажата" ли кнопка
            g.setColor(Color.white);
			g.setFont(f);
            g.drawString(label, width / 2 + 50 - fm.stringWidth(label) / 2 + (pressed ? 0 : 1), height / 2 + fm.getMaxDescent() + (pressed ? 2 : 3));
        }
		}
		else
		{
		Font f = new Font("Times New Roman", Font.BOLD, 22);
		g.setFont(f);
		g.drawString("Начать заново", width / 2 - 85, height / 2 - height / 10 - 1);
		//im_0 = 0;
		}
    }
    // Установим размеры кнопки
    public Dimension getPreferredSize() {
        // Выберем текущий шрифт
        Font f = new Font("Times New Roman", Font.BOLD, 22);
        // Если шрифт суцествует, то
        if (f != null) {
            // Получим характеристики текущего шрифта
            FontMetrics fm = getFontMetrics(f); //get.Font());
            // И установим размеры кнопки в зависимости от
            // геометрических размеров текущего шрифта и
            // длины строки метки кнопки
            return new Dimension(fm.stringWidth(label) + 20, fm.getHeight() + 20);
        } else // в противном случае
        {
            // Установим размеры кнопки 100 на 100 пикселей
            return new Dimension(40, 40);
        }
    }
    // Установим размеры кнопки по умолчанию 100 на 100 пикселей
    public Dimension getMinimumSize() {
        return new Dimension(40, 40);
    }

    // Переопределение метода, которому передается AWT-событие от мыши
    // в потоке-диспетчере событий 
    public void processMouseEvent(MouseEvent e) {
        Graphics g;
        switch (e.getID()) {
            // Нажата кнопка мьыи
        case MouseEvent.MOUSE_PRESSED:
            pressed = true; // установим флаг нажатия
			im_0++;
            repaint();      // перерисуем компонент
            break;
             // Отпущена кнопка мыши
        case MouseEvent.MOUSE_RELEASED:
            // Если был зарегистрирован блок прослушивания
            // сообщений для нашего компонента
            if (actionListener != null) {
                // Сообщаем о том, что произошло action-событие 
                actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, label));
            }
            // Если кнопка-компонент была нажата
            if (pressed == true) {
                pressed = false; // сбросим флаг нажатия
                repaint(); // перерисуем наш компонент
            }
            break;
            // Курсор мыши покинул компонент
        case MouseEvent.MOUSE_ENTERED:
            break;
            // Курсор мыши появился в компоненте
        case MouseEvent.MOUSE_EXITED:
            // Если кнопка мыши нажата
            if (pressed == true) {
                repaint(); // то перерисуем кнопку-компонент
            }
            break;
		}
        // Обратимся к обработчику мыши родительского класса
        super.processMouseEvent(e);
    }
    // Метод для регистрации блока прослушивания событий от кнопки
    public void addActionListener(ActionListener listener) {
		//Класс, который реализует эффективные и поточно-групповые мероприятия диспетчеризации события awt
        actionListener = AWTEventMulticaster.add(actionListener, listener);
		//Класс, реализующий События от Мыши
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
    }
    // Метод для удаления блока прослушивания событий от кнопки
    public void removeActionListener(ActionListener listener) {
        actionListener = AWTEventMulticaster.remove(actionListener, listener);
    }
}
}

