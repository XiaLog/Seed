package web.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */

public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	private static Random r = new Random();
    private static char[] chs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    private static final int NUMBER_OF_CHS = 4;
    private static final int IMG_WIDTH = 105;
    private static final int IMG_HEIGHT = 45;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);    // ʵ����BufferedImage
        Graphics g = image.getGraphics();
        Color c = new Color(200, 200, 255);                                             // ��֤��ͼƬ�ı�����ɫ                                        
        g.setColor(c);
        g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);                                        // ͼƬ�ı߿�
        
        StringBuffer sb = new StringBuffer();                                           // ���ڱ�����֤���ַ���
        int index;                                                                      // ������±�
        for (int i = 0; i < NUMBER_OF_CHS; i++) {
            index = r.nextInt(chs.length);                                              // ���һ���±�
            g.setColor(new Color(r.nextInt(88), r.nextInt(210), r.nextInt(150)));       // ���һ����ɫ
            g.drawString(chs[index] + "", 26 * i + 3, 23);                              // �����ַ�
            sb.append(chs[index]);                                                      // ��֤���ַ���
        }
        request.getSession().setAttribute("piccode", sb.toString());                    // ����֤���ַ������浽session��
        ImageIO.write(image, "jpg", response.getOutputStream());    
	}

}
