package check_image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

public class check_image_chengyu {
	private int imgWidth=0;
	private int imgHeight=0;
	private int fontHeight;
	private String fontStyle;
	chengyu cy = new chengyu();
	List<String> ls = cy.input_chengyu();
	
	public void init(int imgWidth, int imgHeight, String fontStyle){
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.fontStyle = fontStyle;
	    fontHeight = imgHeight - 2;
	}
	Color getRandColor(int fc, int bc){
		Random random = new Random();
		if(fc>255) fc=255;
		if(bc>255) bc=255;
		int r=fc+random.nextInt(bc-fc);
		int g=fc+random.nextInt(bc-fc);
		int b=fc+random.nextInt(bc-fc);
		
		return new Color(r,g,b);
	}
	protected void create_check(){
		BufferedImage image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_BGR);
		Graphics2D g = image.createGraphics();
		Random random = new Random();
		g.setColor(getRandColor(150,250));
		g.fillRect(0, 0, imgWidth, imgHeight);
		
		g.setFont(new Font(fontStyle,Font.PLAIN+Font.ITALIC, fontHeight));
		
		g.setColor(new Color(55,55,12));
		g.drawRect(0, 0, imgWidth-1, imgHeight-1);
		
		g.setColor(getRandColor(100,200));
		for(int i=0;i<400;i++){
			int x = random.nextInt(imgWidth);
	        int y = random.nextInt(imgHeight);
	        int xl = random.nextInt(12);
	        int yl = random.nextInt(12);
	        g.setColor(getRandColor(20,110));  
	        g.drawLine(x, y, x + xl, y + yl);
		}
		
		for(int i=0;i<170;i++){
			int x = random.nextInt(imgWidth-1);
	        int y = random.nextInt(imgHeight-1);
	        int xl = random.nextInt(12)+1;
	        int yl = random.nextInt(6)+1;
	        g.setColor(getRandColor(20,110));  
	        g.drawLine(x, y, x + xl, y + yl);
		}
		int number = random.nextInt(12602);
		String sRand=ls.get(number);  
		char[] test = sRand.toCharArray();
		int w = (imgWidth-1*test.length)/test.length;
        for (int i=0;i<test.length;i++)     
        {
        	 Graphics2D g2d = (Graphics2D)g;
        	 AffineTransform at_1 = new AffineTransform();
        	 g2d.setColor(getRandColor(100,200));
        	 int num_i = random.nextInt(3);
        	 g2d.drawString(String.valueOf(test[i]),w*i+num_i,fontHeight-2);
        	 int num = random.nextInt(4);
        	 at_1.setToRotation(num*Math.PI / 180);
        	 g2d.setTransform(at_1);
        }        
        g.dispose();     
        try {
			ImageIO.write(image, "PNG", new File("D:\\checkchengyu\\"+sRand+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}     
		
	}
}





















